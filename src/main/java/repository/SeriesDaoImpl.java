package repository;

import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import utilHibernate.HibConfig;

import java.util.List;

@Repository
public class SeriesDaoImpl implements SeriesDao {
//private static final Logger logger = LoggerFactory.getLogger(SeriesDaoImpl);

    public SeriesDaoImpl() {
    }

    @Override
    public void addSeries(SeriesEntity series) {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.persist(series);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateSeries(SeriesEntity series) {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(series);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeSeries(long idSeries) {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        SeriesEntity series = session.load(SeriesEntity.class, idSeries);
        if (series != null) {
            session.delete((series));
        }
        transaction.commit();
        session.close();
    }

    @Override
    public SeriesEntity getSeriesByID(long idSeries) {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        return session.load(SeriesEntity.class, idSeries);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SeriesEntity> listSeries() {
        Session session = HibConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

//        for (SeriesEntity series: seriesList){
//             logger.info("Series list: " + series);
//        }
        return (List<SeriesEntity>) session.createQuery("from SeriesEntity").list();
    }
}

