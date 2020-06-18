package service;

import model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(String username);

    User getUserByUsername(String username);

    List<User> listUsers();

    boolean checkUserReg(String username);


    void evictUser(User user);


}
