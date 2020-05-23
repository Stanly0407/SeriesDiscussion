package service;

import model.SeriesEntity;
import model.UserEntity;

import java.util.List;

public interface UserService {
    void addUser(UserEntity user);

    void updateUser(UserEntity user);

    void removeUser(long idUser);

    UserEntity getUserByID(long idUser);

    List<UserEntity> listUsers();

    boolean checkUserReg(String email);

    boolean checkUserAuthen(String email, String password);

    boolean checkUserForm(UserEntity user);

    boolean checkUserAuthenForm(UserEntity user);

    boolean checkAdminAuthen(UserEntity user);

    void blockingUser(long idUser);

    void unBlockingUser(long idUser);

    void evictUser(UserEntity user);

    boolean blockingUserCheck(UserEntity user);
}
