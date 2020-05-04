package service;

import model.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserDao;
import repository.UserDaoImpl;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    @Transactional
    public void addUser(UserEntity user) {
        if (user != null) {
            userDao.addUser(user);} }

    @Override
    @Transactional
    public void updateUser(UserEntity user) {
        userDao.updateUser(user);}

    @Override
    @Transactional
    public void removeUser(long idUser) {
        userDao.removeUser(idUser);}

    @Override
    @Transactional
    public UserEntity getUserByID(long idUser) {
        return userDao.getUserByID(idUser);}

    @Override
    @Transactional
    public List<UserEntity> listUsers() {
        return userDao.listUsers(); }

    @Override
    @Transactional
    public boolean checkUser(String email) {
        return userDao.checkUser(email);}
}
