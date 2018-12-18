package bcd.DAO;

import bcd.ConnectionFactory;
import bcd.tabelas.Assunto;
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
public class AssuntosDAO {

    public boolean inserir(Assunto a) {
        // O try dessa forma fecha a conexão
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "INSERT INTO Assuntos (idDisc, nome) "
                    + "VALUES (?,?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, a.getIdDisc());
                stmt.setString(2, a.getNome());
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssuntosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<Assunto> listar(Connection conexao) {
        List<Assunto> a = new ArrayList<>();
        // O try dessa forma fecha a conexão
        try {
            String sql = "SELECT * FROM Assuntos";

            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Assunto c = new Assunto(
                            rs.getString("nome"),
                            rs.getInt("idDisc"));
                    c.setIdDisc(rs.getInt("idAssunto"));
                    a.add(c);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return a;
    }

    public List<Assunto> listarPorDisc(int id) {
        List<Assunto> a = new ArrayList<>();
        // O try dessa forma fecha a conexão
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "SELECT * FROM Assuntos WHERE idDisc like  " + id;

            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Assunto c = new Assunto(
                            rs.getString("nome"),
                            rs.getInt("idDisc"));
                    c.setIdDisc(rs.getInt("idAssunto"));
                    a.add(c);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return a;
    }

    public Assunto listarPorNome(String nome) {
        Assunto a = null;
        // O try dessa forma fecha a conexão
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "SELECT * FROM Assuntos WHERE nome like  " + nome;

            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                a = new Assunto(rs.getString("nome"), rs.getInt("idDisc"));
                a.setIdDisc(rs.getInt("idAssunto"));

            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return a;
    }

    public int descobreIdDisc(String nome) {
        int id = 0;

        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "SELECT * FROM Assuntos WHERE nome like '" + nome + "'";

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
    
    public int descobreId(String nome) {
        int id = 0;

        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "SELECT * FROM Assuntos WHERE nome like '" + nome + "'";

            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    id = rs.getInt("idAssunto");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return id;
    }
}
