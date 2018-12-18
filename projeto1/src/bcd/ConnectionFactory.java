package bcd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisa
 */
public class ConnectionFactory {

    private static final String dbPath = "pj01_db.db";
    private static Connection conexao;

    public static Connection getConnetion() {
        conexao = null;
        try {
            // verifica se tem drive para o sqlite:
            Class.forName("org.sqlite.JDBC"); 
            conexao = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexao;
    }
}
