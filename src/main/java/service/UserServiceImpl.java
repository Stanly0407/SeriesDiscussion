package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import repository.UserDao;
import repository.UserDaoImpl;

import java.util.List;

@Service //чтобы объявить, что этот класс представляет сервис – компонент сервис-слоя. Сервис является подтипом класса @Component. Использование данной аннотации позволит искать бины-сервисы автоматически (смотрите далее в root-context.xml).
public class UserServiceImpl implements UserService {

    @Autowired
    private Validator validator;

    @Autowired
    private UserDao userDao = new UserDaoImpl();

    @Override
    @Transactional //Перед исполнением метода помеченного данной аннотацией начинается транзакция, после выполнения метода транзакция коммитится, при выбрасывании RuntimeException откатывается.
    public void addUser(User user) {
        if (user != null) {
            userDao.addUser(user);
        }
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(String username) {
        userDao.removeUser(username);
    }


    @Override
    @Transactional
    public void evictUser(User user){
         userDao.evictUser(user);
    }

    @Override
    public boolean blockingUserCheck(User user) {
        return userDao.blockingUserCheck(user);
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional
    public boolean checkUserReg(String username) {
        return userDao.checkUserReg(username);
    }

    @Override
    public boolean checkUserAuthen(String username, String password) {
        return userDao.checkUserAuthen(username, password); }

    @Override
    public boolean checkAdminAuthen(User user) {
        return userDao.checkAdminAuthen(user);
    }

    @Override
    public void blockingUser(String username) {
         userDao.blockingUser(username);
    }

    @Override
    public void unBlockingUser(String username) {
        userDao.unBlockingUser(username);
    }

}




//@Override
//    public boolean checkUserForm(UserEntity user) {
//        return user.getEmail() == null || user.getSurname() == null ||
//                user.getForename() == null || user.getPassword() == null ||
//                user.getBirthdate() == null;
//    }
//
//    @Override
//    public boolean checkUserAuthenForm(UserEntity user){
//        return user.getEmail() == null || user.getPassword() == null;
//    }