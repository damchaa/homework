package part1.lesson19;


import part1.lesson19.DAO.ProductDaoJdbc;
import part1.lesson19.DAO.RoleDao;
import part1.lesson19.DAO.RoleDaoJdbc;
import part1.lesson19.DAO.UserDaoJdbc;
import part1.lesson19.Model.Product;
import part1.lesson19.Model.Role;
import part1.lesson19.Model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        UserDaoJdbc userDaoJdbc = new UserDaoJdbc();
        RoleDaoJdbc roleDaoJdbc = new RoleDaoJdbc();
        ProductDaoJdbc productDaoJdbc = new ProductDaoJdbc();
        User user = new User(1,"maruyama","pass",1);
        User user1 = new User(2,"ono","pass",2);
        User user2 = new User(3,"kosei","pass",3);
        User user3 = new User(4,"ono","password",4);

        userDaoJdbc.addUser(user);
        userDaoJdbc.addUser(user1);
        userDaoJdbc.addUser(user2);
        List<User> list = userDaoJdbc.getAllUser();
        for (User users: list){
            System.out.println(users);
        }

        userDaoJdbc.deleteUserByLogin("damcha");

        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("user");
        roles.add("manager");
        roleDaoJdbc.addRole(new Role("supervisior"));
        roleDaoJdbc.addManyRole(roles);
        roleDaoJdbc.deleteRoleById(5);

        productDaoJdbc.addProduct(new Product(1,"kimono",1500));
        productDaoJdbc.addProduct(new Product(2,"back",3000));
        productDaoJdbc.addProduct(new Product(3,"belt",1400));
        productDaoJdbc.getAllProduct();
        productDaoJdbc.deleteProductByLogin(2);
        productDaoJdbc.getAllProduct();



    }
}
