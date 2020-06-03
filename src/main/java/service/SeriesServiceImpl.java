package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import repository.SeriesDao;
import repository.SeriesDaoImpl;
import model.SeriesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService {

    @Qualifier("seriesDaoImpl")
    @Autowired
     private SeriesDao seriesDao = new SeriesDaoImpl();

    @Override
    @Transactional
    public void addSeries(SeriesEntity series) {
        if(series!=null) { seriesDao.addSeries(series);}
    }


    @Override
    @Transactional
    public void updateSeries(SeriesEntity series) {
      seriesDao.updateSeries(series);
    }

    @Override
    @Transactional
    public void removeSeries(long idSeries) {
        seriesDao.removeSeries(idSeries);
    }

    @Override
    @Transactional
    public SeriesEntity getSeriesByID(long idSeries) {
        return seriesDao.getSeriesByID(idSeries);
    }

    @Override
    @Transactional
    public List<SeriesEntity> listSeries() {
        return seriesDao.listSeries();
    }

    @Override
    public void evictSeries(SeriesEntity series) {
        seriesDao.evictSeries(series);
    }


    public SeriesDao getSeriesDao() {
        return seriesDao;
    }

    public void setSeriesDao(SeriesDao seriesDao) {
        this.seriesDao = seriesDao;
    }
}
