package part1.lesson19.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJdbc implements ConnectionManager{
    public static final ConnectionManager INSTANCE = new ConnectionManagerJdbc();

    private ConnectionManagerJdbc() {
    }

    public static ConnectionManager getInstance() {
        return INSTANCE;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/innopolis",
                    "postgres",
                    "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
