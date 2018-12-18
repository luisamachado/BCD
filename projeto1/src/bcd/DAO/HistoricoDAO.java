package bcd.DAO;

import bcd.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisa
 */
public class HistoricoDAO {

    public boolean inserir(int idProva, int idPergunta) throws SQLException {
        // O try dessa forma fecha a conexão
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "INSERT INTO Historico (idProva, idPergunta) VALUES"
                    + "(?,?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, idProva);
                stmt.setInt(2, idPergunta);

                stmt.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(HistoricoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
