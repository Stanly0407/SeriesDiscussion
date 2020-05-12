package repository;

import model.SeriesEntity;
import model.UserEntity;

import java.util.List;

public interface UserDao {
    public void addUser(UserEntity user);
    public void updateUser(UserEntity user);
    public void removeUser(long idUser);
    public UserEntity getUserByID(long idUser);
    public List<UserEntity> listUsers();
    public boolean checkUser (String email);


}
