package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author UFT
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "<SENHA DO BANCO AQUI>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
