package part1.lesson19.DAO;

import part1.lesson19.Model.Product;
import part1.lesson19.Model.User;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    List<Product> getAllProduct();
    void deleteProductByLogin(int id);
    void updateProductById(Product product);
}
