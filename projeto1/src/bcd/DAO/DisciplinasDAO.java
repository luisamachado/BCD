package bcd.DAO;

import bcd.ConnectionFactory;
import bcd.tabelas.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisa
 */
public class DisciplinasDAO {

    public boolean inserir(Connection conexao, String nome) {
        // O try dessa forma fecha a conexão 
        try {
            String sql = "INSERT INTO Disciplinas (nome) VALUES (?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<Disciplina> listar(Connection conexao) {
        List<Disciplina> disc = new ArrayList<>();
        // O try dessa forma fecha a conexão
        try {
            String sql = "SELECT * FROM Disciplinas";

            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Disciplina c = new Disciplina(
                            rs.getString("nome"));
                    c.setIdDisc(rs.getInt("idDisc"));
                    disc.add(c);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return disc;
    }

    public int descobreId(String nome) {
        int id = 0;

        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "SELECT * FROM Disciplinas WHERE nome like '" + nome + "'";

            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    id = rs.getInt("idDisc");
                }
            } 
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return id;
    }
}
