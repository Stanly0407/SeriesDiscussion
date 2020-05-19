package repository;


import model.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import utilHibernate.HibConfig;

import java.util.List;


@Repository
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

    @Override
    public void updateUser(UserEntity user) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUser(long idUser) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity user = session.load(UserEntity.class, idUser);
        if (user != null) {
            session.delete((user));
        }
        transaction.commit();
        session.close();
    }

    @Override
    public UserEntity getUserByID(long idUser) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity user = session.load(UserEntity.class, idUser);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserEntity> listUsers() {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

//        for (SeriesEntity series: seriesList){
//             logger.info("Series list: " + series);}
        return (List<UserEntity>) session.createQuery("from UserEntity").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean checkUserReg(String email) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM UserEntity u where u.email = :paramEmail";
        Query query = session.createQuery(hql).setParameter("paramEmail", email);
        List<UserEntity> list = query.list();
        return list.isEmpty();
    }


    @Override
    @SuppressWarnings("unchecked")
    public boolean checkUserAuthen(String email, String password) {
        Session session = HibConfig.getSessionFactory().openSession();
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
        String hql = "FROM UserEntity u where u.email  like 'admin@sdisc.com' and  u.password  like 'admin123'";
        List<UserEntity> list = session.createQuery(hql).list();
        UserEntity user1 = list.get(0);
        return user1.getEmail().equals(user.getEmail()) && user1.getPassword().equals(user.getPassword());
    }

    @Override
    public void blockingUser(long idUser) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity user = session.load(UserEntity.class, idUser);
        String passwordBlocked = Integer.toString((int) (Math.random() * 5));
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

}


