package part1.lesson19;

import part1.lesson19.Service.ConnectionManager;
import part1.lesson19.Service.ConnectionManagerJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnector {
    private static final ConnectionManager connectionManager =
            ConnectionManagerJdbc.getInstance();
    public static void createUserTable()  {
        try{
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS users");
            statement.execute(
                    "Create TABLE users(id int not null  ,login varchar ,password varchar ,role_id int)"
            );
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createRoleTable(){

        try{
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS roles");
            statement.execute(
                    "Create TABLE roles(id  int not null   ,name varchar)"
            );

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void createProductTable(){
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS products");
            statement.execute(
                    "Create TABLE products(id int not null ,name varchar,price int,img varchar )"
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
