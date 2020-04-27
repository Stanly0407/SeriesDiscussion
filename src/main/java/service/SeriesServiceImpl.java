package service;

import dao.SeriesDao;
import model.SeriesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService {
    private SeriesDao seriesDao;

    public void setSeriesDao(SeriesDao seriesDao) {
        this.seriesDao = seriesDao;
    }

    @Override
    @Transactional
    public void addSeries(SeriesEntity series) {
        this.seriesDao.addSeries(series);
    }

    @Override
    @Transactional
    public void updateSeries(SeriesEntity series) {
        this.seriesDao.updateSeries(series);
    }

    @Override
    @Transactional
    public void removeSeries(long idSeries) {
        this.seriesDao.removeSeries(idSeries);
    }

    @Override
    @Transactional
    public SeriesEntity getSeriesByID(long idSeries) {
        return this.seriesDao.getSeriesByID(idSeries);
    }

    @Override
    @Transactional
    public List<SeriesEntity> listSeries() {
        return this.seriesDao.listSeries();
    }
}
