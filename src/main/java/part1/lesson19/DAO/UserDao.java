package part1.lesson19.DAO;

import part1.lesson19.Model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getAllUser();
    void deleteUserByLogin(String login);
    void updateUserByLogin(User user);
}
