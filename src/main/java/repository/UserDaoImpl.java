package repository;


import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;
import utilHibernate.HibConfig;

import java.util.List;


@Repository //Аннотация показывает, что класс функционирует как репозиторий и требует наличия прозрачной трансляции исключений. Преимуществом трансляции исключений является то, что слой сервиса будет иметь дело с общей иерархией исключений от Спринга (DataAccessException) вне зависимости от используемых технологий доступа к данным в DAO слое.
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }

    @Override
    public void addUser(User user) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(user);
      transaction.commit();
       session.close();
    }



    @Override
    public void updateUser(User user) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }


    @Override
    public void evictUser(User user) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.evict(user);
    }

    @Override
    public User getUserByUsername(String username) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        return session.load(User.class, username);
    }


    // Пока в данном методе нет нужды, т.к. приведет к удалению всех связанных записей в БД.
    // В крайнем случае можно удалять конкретные записи "недобросовестного" пользователя
    // и его заблокировать на определнное время или навсегда.
    @Override
    public void removeUser(String username) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.load(User.class, username);
        if (user != null) {
            session.delete((user));}
        transaction.commit();
        session.close();}

   @Secured(value = {"USER"})
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = HibConfig.getSessionFactory().openSession();
       Transaction transaction = session.beginTransaction();

        return (List<User>) session.createQuery("from User").list();}

    @Override
    @SuppressWarnings("unchecked")
    public boolean checkUserReg(String username) {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM User u where u.username = :paramUsername";
        Query query = session.createQuery(hql).setParameter("paramUsername", username);
        List<User> list = query.list();
        return list.isEmpty();
    }

}



//    @Override
//    @SuppressWarnings("unchecked")
//    public boolean checkUserAuthen(String username, String password) {
//        Session session = HibConfig.getSessionFactory().getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        String hql = "FROM User u where u.username = :paramUsername and  u.password = :paramPassword";
//        Query query = session.createQuery(hql).setParameter("paramUsername", username).setParameter("paramPassword", password);
//        List<User> list = query.list();
//        return !list.isEmpty();
//    }

//
//    @Override
//    @SuppressWarnings("unchecked")
//    public boolean checkAdminAuthen(User user) {
//        Session session = HibConfig.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        String hql = "FROM User u where u.email  like 'admin@sdisc.com' and  u.password  like '123'";
//        List<User> list = session.createQuery(hql).list();
//        User user1 = list.get(0);
//        return user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword());
//    }
//
//    @Override
//    public void blockingUser(String username) {
//        Session session = HibConfig.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        User user = session.load(User.class, username);
//        String passwordBlocked = Integer.toString((int) (Math.random() * 9999 + 9999));
//        user.setPassword(String.join(" blocked ", user.getPassword(), passwordBlocked));
//        session.update(user);
//        transaction.commit();
//        session.close();
//    }
//
//    @Override
//    public void unBlockingUser(String username) {
//        Session session = HibConfig.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        User user = session.load(User.class, username);
//        String[] unblockingPassword = user.getPassword().split(" blocked ");
//        user.setPassword(unblockingPassword[0]);
//        session.update(user);
//        transaction.commit();
//        session.close();
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public boolean blockingUserCheck(User user) {
//        Session session = HibConfig.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        String hql = "FROM User u where u.email = :paramEmail";
//        Query query = session.createQuery(hql).setParameter("paramEmail", user.getUsername());
//        List<User> list = query.list();
//        User userBlockingCheck = list.get(0);
//        return userBlockingCheck.getPassword().contains(" blocked ");
//        }







