package part1.lesson19.DAO;

import part1.lesson19.Model.Role;
import part1.lesson19.Model.User;

import java.util.List;

public interface RoleDao {
    void addRole(Role role);
    void deleteRoleById(int id);
    void addManyRole(List<String> roles);
    void updateRoleById(Role role);
    List<Role> getAllRole();
}
