package repository;

import model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(String username);

    User getUserByUsername(String username);

    List<User> listUsers();

    void evictUser(User user);
    boolean checkUserReg(String username);

//    boolean checkUserAuthen(String username, String password);
//    boolean checkAdminAuthen(User user);
//    boolean blockingUserCheck(User user);
//    void blockingUser(String username);
//    void unBlockingUser(String username);

}
