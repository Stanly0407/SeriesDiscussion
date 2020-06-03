package repository;


import model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utilHibernate.HibConfig;

import java.util.List;


@Repository //Аннотация показывает, что класс функционирует как репозиторий и требует наличия прозрачной трансляции исключений. Преимуществом трансляции исключений является то, что слой сервиса будет иметь дело с общей иерархией исключений от Спринга (DataAccessException) вне зависимости от используемых технологий доступа к данным в DAO слое.
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }

    @Override
    public void addUser(UserEntity user) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
      transaction.commit();
       session.close();
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
    public void updateUser(UserEntity user) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }


    @Override
    public void evictUser(UserEntity user) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.evict(user);
    }


    @Override
    public UserEntity getUserByID(long idUser) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        return session.load(UserEntity.class, idUser);
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        return session.load(UserEntity.class, email);
    }


    // Пока в данном методе нет нужды, т.к. приведет к удалению всех связанных записей в БД.
    // В крайнем случае можно удалять конкретные записи "недобросовестного" пользователя
    // и его заблокировать на определнное время или навсегда.
    @Override
    public void removeUser(long idUser) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity user = session.load(UserEntity.class, idUser);
        if (user != null) {
            session.delete((user));}
        transaction.commit();
        session.close();}


    @Override
    @SuppressWarnings("unchecked")
    public List<UserEntity> listUsers() {
        Session session = HibConfig.getSessionFactory().openSession();
       Transaction transaction = session.beginTransaction();
//        for (SeriesEntity series: seriesList){
//             logger.info("Series list: " + series);}
        return (List<UserEntity>) session.createQuery("from UserEntity").list();}

    @Override
    @SuppressWarnings("unchecked")
    public boolean checkUserReg(String email) {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM UserEntity u where u.email = :paramEmail";
        Query query = session.createQuery(hql).setParameter("paramEmail", email);
        List<UserEntity> list = query.list();
        return list.isEmpty();
    }


    @Override
    @SuppressWarnings("unchecked")
    public boolean checkUserAuthen(String email, String password) {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM UserEntity u where u.email = :paramEmail and  u.password = :paramPassword";
        Query query = session.createQuery(hql).setParameter("paramEmail", email).setParameter("paramPassword", password);
        List<UserEntity> list = query.list();
        return !list.isEmpty();
    }



    @Override
    @SuppressWarnings("unchecked")
    public boolean checkAdminAuthen(UserEntity user) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM UserEntity u where u.email  like 'admin@sdisc.com' and  u.password  like '123'";
        List<UserEntity> list = session.createQuery(hql).list();
        UserEntity user1 = list.get(0);
        return user1.getEmail().equals(user.getEmail()) && user1.getPassword().equals(user.getPassword());
    }

    @Override
    public void blockingUser(long idUser) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity user = session.load(UserEntity.class, idUser);
        String passwordBlocked = Integer.toString((int) (Math.random() * 9999 + 9999));
        user.setPassword(String.join(" blocked ", user.getPassword(), passwordBlocked));
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void unBlockingUser(long idUser) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity user = session.load(UserEntity.class, idUser);
        String[] unblockingPassword = user.getPassword().split(" blocked ");
        user.setPassword(unblockingPassword[0]);
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean blockingUserCheck(UserEntity user) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM UserEntity u where u.email = :paramEmail";
        Query query = session.createQuery(hql).setParameter("paramEmail", user.getEmail());
        List<UserEntity> list = query.list();
        UserEntity userBlockingCheck = list.get(0);
        return userBlockingCheck.getPassword().contains(" blocked ");
        }


    }




