package part1.lesson19.DAO;

import part1.lesson19.JdbcConnector;
import part1.lesson19.Model.Role;
import part1.lesson19.Model.User;
import part1.lesson19.Service.ConnectionManager;
import part1.lesson19.Service.ConnectionManagerJdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoJdbc implements RoleDao{
    private static final ConnectionManager connectionManager =
            ConnectionManagerJdbc.getInstance();
    public RoleDaoJdbc(){
        JdbcConnector.createRoleTable();

    }

    @Override
    public void addRole(Role role) {

        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        Savepoint savepoint = null;
        int id = -1;
        try {

            PreparedStatement preparedStatement1 = connection.prepareStatement("select max(id) from roles");
            ResultSet rs = preparedStatement1.executeQuery();
            if (rs.next()){
                id=rs.getInt(1);
            }
            id++;
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();

            preparedStatement = connection.prepareStatement("INSERT INTO roles (id,name ) values (?,?)");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,role.getName());
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

    @Override
    public void deleteRoleById(int id) {
        Connection connection = connectionManager.getConnection();

        Savepoint savepoint = null;
        try {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM roles WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback(savepoint);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }



    @Override
    public void updateRoleById(Role role) {
        Connection connection = connectionManager.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE roles SET  name=? WHERE id=?");
            preparedStatement.setString(1,role.getName());
            preparedStatement.setInt(2,role.getId());
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

    @Override
    public List<Role> getAllRole() {
        List<Role> list = new ArrayList<>();

        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from roles");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new Role(
                        resultSet.getInt("id"),
                        resultSet.getString("name")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addManyRole(List<String> roles){
        Connection connection = connectionManager.getConnection();
        int id = -1;
        Savepoint savepoint = null;
        try {

            PreparedStatement preparedStatement1 = connection.prepareStatement("select max(id) from roles");
            ResultSet rs = preparedStatement1.executeQuery();
            if (rs.next()){
                id=rs.getInt(1);
            }
            id++;
            connection.setAutoCommit(false);
             savepoint = connection.setSavepoint();

            PreparedStatement preparedStatement =  connection.prepareStatement("INSERT INTO roles (id,name ) values (? ,?) ");
            for (int i= 0;i<roles.size();i++){
                preparedStatement.setInt(1,id++);
                preparedStatement.setString(2,roles.get(i));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
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
}
