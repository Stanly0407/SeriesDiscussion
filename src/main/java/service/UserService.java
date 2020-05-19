package service;

import model.SeriesEntity;
import model.UserEntity;

import java.util.List;

public interface UserService {
    public void addUser(UserEntity user);
    public void updateUser(UserEntity user);
    public void removeUser(long idUser);
    public UserEntity getUserByID(long idUser);
    public List<UserEntity> listUsers();
    public boolean checkUserReg (String email);
    public boolean checkUserAuthen(String email, String password);
    public boolean checkUserForm(UserEntity user);
    public boolean checkUserAuthenForm(UserEntity user);
    public boolean checkAdminAuthen(UserEntity user);
    public void blockingUser(long idUser);
    public void unBlockingUser(long idUser);
}
