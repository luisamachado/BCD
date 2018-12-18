package bcd.DAO;

import bcd.ConnectionFactory;
import bcd.tabelas.Historico;
import bcd.tabelas.Pergunta;
import bcd.tabelas.Prova;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luisa
 */
public class ProvasDAO {

    public void inserir(Prova p) throws SQLException {
        // O try dessa forma fecha a conexão  
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "INSERT INTO Provas (data, semestre, idDisc) VALUES"
                    + "(?,?,?)";

            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, p.getAno());
                stmt.setInt(2, p.getSemestre());
                stmt.setInt(3, p.getIdDisc());

                stmt.execute();
            }
        }
    }

    public int descobreId(Prova p) {
        int id = 0;
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "SELECT idProva FROM Provas WHERE semestre=" + p.getSemestre()
                    + " AND idDisc=" + p.getIdDisc() + " AND data=" + p.getAno();
            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    id = rs.getInt("idProva");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return id;
    }

    public List<Pergunta> selecionaPerg(int idProva, int num, int anoAtual, int vez, boolean nunca, String idsAssuntos) throws SQLException {
        // O try dessa forma fecha a conexão  
        List<Pergunta> perg = new ArrayList<>();
        List<Historico> h = new ArrayList<>();
        Historico item;

        String not = "";
        if (nunca == true) {
            not = " AND p.idPergunta NOT IN (SELECT h.idPergunta FROM Historico h) ";
        }
        String ultima = "";
        int min = anoAtual - vez;
        if (vez != 0) {           
            ultima = " AND p.idPergunta IN (SELECT h.idPergunta FROM Historico h"
                    + " INNER JOIN Provas p ON p.idProva = h.idProva"
                    + " WHERE p.data<" + min + ")";
        }
        if (nunca == true && vez != 0) {
            ultima = " OR p.idPergunta IN (SELECT h.idPergunta FROM Historico h"
                    + " INNER JOIN Provas p ON p.idProva = h.idProva"
                    + " WHERE p.data<" + min + ")";
        }
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "SELECT * FROM Perguntas p INNER JOIN Assuntos a "
                    + "ON a.idAssunto = p.idAssunto WHERE p.idAssunto IN (" 
                    + idsAssuntos + ")" + not + ultima + " ORDER BY RANDOM() LIMIT " + num;
            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Pergunta c = new Pergunta(
                            rs.getString("pergunta"),
                            rs.getInt("idAssunto"),
                            rs.getBoolean("flag_alternativa"));
                    if (rs.getBoolean("flag_alternativa") == true) {
                        c.setAlternativas(rs.getString("alternativa"));
                    } else {
                        c.setAlternativas(" ");
                    }
                    perg.add(c);
                    int id = rs.getInt("idPergunta");
                    item = new Historico(idProva, id);
                    h.add(item);
                }
            }
            HistoricoDAO hist = new HistoricoDAO();
            if (h.size() != num) {
                String msg = "Foram encontradas " + h.size() + " questões. Falta "
                        + (num - h.size()) + " questões.";
                JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            }
            for (Historico a : h) {
                hist.inserir(a.getIdProva(), a.getIdPerg());
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return perg;
    }
}
