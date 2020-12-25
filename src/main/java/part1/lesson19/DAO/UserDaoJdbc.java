package part1.lesson19.DAO;

import part1.lesson19.JdbcConnector;
import part1.lesson19.Model.User;
import part1.lesson19.Service.ConnectionManager;
import part1.lesson19.Service.ConnectionManagerJdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbc implements UserDao {
    private static final ConnectionManager connectionManager =
            ConnectionManagerJdbc.getInstance();
    public UserDaoJdbc(){
        JdbcConnector.createUserTable();
    }
    @Override
    public void addUser(User user) {

        Connection connection = connectionManager.getConnection();

        Savepoint savepoint = null;

        int id= -1;
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement("select max(id) from users");
            ResultSet rs = preparedStatement1.executeQuery();
            if (rs.next()){
                id=rs.getInt(1);
            }
            id++;
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (id,login ,password,role_id) values (?,?,?,?)");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,user.getLogin());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setInt(4,user.getRoleId());
            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                connection.rollback(savepoint);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    public void deleteUserByLogin(String name){
        Connection connection = connectionManager.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE login=?");
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);

        }
        catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void updateUserByLogin(User user){
        Connection connection = connectionManager.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET id=?, login=?, password=?, role_id=? WHERE login=?");
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getLogin());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setInt(4,user.getRoleId());
            preparedStatement.setString(5,user.getLogin());
            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    public List<User> getAllUser(){
        List<User> list = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                list.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("role_id")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
