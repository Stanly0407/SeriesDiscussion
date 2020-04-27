package dao;

import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SeriesDaoImpl implements SeriesDao {

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
        Transaction transaction = session.beginTransaction();
        SeriesEntity series = session.load(SeriesEntity.class, idSeries);
        return series;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SeriesEntity> listSeries() {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<SeriesEntity> seriesList = session.createQuery("from series").list();

//        for (SeriesEntity series: seriesList){
//             logger.info("Series list: " + series);
//        }
        return seriesList;
    }
}

