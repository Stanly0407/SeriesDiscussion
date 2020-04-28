package service;

import repository.SeriesDao;
import repository.SeriesDaoImpl;
import model.SeriesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService {

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
}
