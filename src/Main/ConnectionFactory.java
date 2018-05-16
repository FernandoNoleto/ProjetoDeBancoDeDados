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
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/hexa2", "postgres", "Fernando102030");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
