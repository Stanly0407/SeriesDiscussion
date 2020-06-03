package repository;

import model.SeriesEntity;
import model.UserEntity;

import java.util.List;

public interface UserDao {
    void addUser(UserEntity user);

    void updateUser(UserEntity user);

    void removeUser(long idUser);

    UserEntity getUserByID(long idUser);

    UserEntity getUserByEmail(String email);

    List<UserEntity> listUsers();

    boolean checkUserReg(String email);

    boolean checkUserAuthen(String email, String password);

    boolean checkAdminAuthen(UserEntity user);

    void blockingUser(long idUser);

    void unBlockingUser(long idUser);

    void evictUser(UserEntity user);

    boolean blockingUserCheck(UserEntity user);


}
