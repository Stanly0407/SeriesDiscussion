package service;

import model.Authorities;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import repository.UserDao;
import repository.UserDaoImpl;

import java.util.Collections;
import java.util.List;

@Service //чтобы объявить, что этот класс представляет сервис – компонент сервис-слоя. Сервис является подтипом класса @Component. Использование данной аннотации позволит искать бины-сервисы автоматически (смотрите далее в root-context.xml).
public class UserServiceImpl implements UserService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private Validator validator;

    @Autowired
    private UserDao userDao = new UserDaoImpl();

    @Override
    @Transactional //Перед исполнением метода помеченного данной аннотацией начинается транзакция, после выполнения метода транзакция коммитится, при выбрасывании RuntimeException откатывается.
    public void addUser(User user) {
        if (user != null) {
            user.setAuthorities(Collections.singleton(new Authorities("ROLE_USER", user)));
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
             userDao.addUser(user);
        }
    }
    //    public boolean saveUser(User user) {
//        User userFromDB = userRepository.findByUsername(user.getUsername());
//
//        if (userFromDB != null) {
//            return false;
//        }
//
//        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return true;
//    }
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