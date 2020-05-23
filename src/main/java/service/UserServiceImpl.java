package service;

import model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import repository.UserDao;
import repository.UserDaoImpl;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Validator validator;

    private UserDao userDao = new UserDaoImpl();

    @Override
    @Transactional
    public void addUser(UserEntity user) {
        if (user != null) {
            userDao.addUser(user);
        }
    }

    @Override
    @Transactional
    public void updateUser(UserEntity user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(long idUser) {
        userDao.removeUser(idUser);
    }


    @Override
    @Transactional
    public void evictUser(UserEntity user){
         userDao.evictUser(user);
    }

    @Override
    public boolean blockingUserCheck(UserEntity user) {
        return userDao.blockingUserCheck(user);
    }


    @Override
    @Transactional
    public UserEntity getUserByID(long idUser) {
        return userDao.getUserByID(idUser);
    }

    @Override
    @Transactional
    public List<UserEntity> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional
    public boolean checkUserReg(String email) {
        return userDao.checkUserReg(email);
    }

    @Override
    public boolean checkUserAuthen(String email, String password) {
        return userDao.checkUserAuthen(email, password);
    }

    @Override
    public boolean checkUserForm(UserEntity user) {
        return user.getEmail() == null || user.getSurname() == null ||
                user.getForename() == null || user.getPassword() == null ||
                user.getBirthdate() == null;
    }

    @Override
    public boolean checkUserAuthenForm(UserEntity user){
        return user.getEmail() == null || user.getPassword() == null;
    }

    @Override
    public boolean checkAdminAuthen(UserEntity user) {
        return userDao.checkAdminAuthen(user);
    }

    @Override
    public void blockingUser(long idUser) {
         userDao.blockingUser(idUser);
    }

    @Override
    public void unBlockingUser(long idUser) {
        userDao.unBlockingUser(idUser);
    }


}

