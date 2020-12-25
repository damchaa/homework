package part1.lesson19.DAO;

import part1.lesson19.JdbcConnector;
import part1.lesson19.Model.Product;
import part1.lesson19.Model.User;
import part1.lesson19.Service.ConnectionManager;
import part1.lesson19.Service.ConnectionManagerJdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJdbc implements ProductDao {
    private static final ConnectionManager connectionManager =
            ConnectionManagerJdbc.getInstance();
    public ProductDaoJdbc(){
        JdbcConnector.createProductTable();
    }


    @Override
    public void addProduct(Product product) {

        Connection connection = connectionManager.getConnection();
        Savepoint savepoint =null;
        int id= -1;
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement("select max(id) from products");
            ResultSet rs = preparedStatement1.executeQuery();
            if (rs.next()){
                id=rs.getInt(1);
            }
            id++;
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (id,name ,price) values (?,?,?)");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,product.getName());
            preparedStatement.setInt(3,product.getPrice());

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
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                list.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteProductByLogin(int id) {
        Connection connection = connectionManager.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE id=?");
            preparedStatement.setInt(1,id);
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

    @Override
    public void updateProductById(Product product) {
        Connection connection = connectionManager.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE roles SET  name=?,price=? WHERE id=?");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3,product.getId());
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
}
