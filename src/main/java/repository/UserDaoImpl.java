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
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(UserEntity user) {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUser(long idUser) {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
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
        List<UserEntity> userList = session.createQuery("from UserEntity").list();

//        for (SeriesEntity series: seriesList){
//             logger.info("Series list: " + series);}
        return userList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean checkUser(String email) {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM UserEntity u where u.email = :paramEmail";
        Query query = session.createQuery(hql);
        query.setParameter("paramEmail", email);
        List<UserEntity> list = query.list();

        if (list == null) {
            return true;
        } else {
            return false;}
    }


}