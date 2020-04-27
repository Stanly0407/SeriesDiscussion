package service;

import model.SeriesEntity;

import java.util.List;

public interface SeriesService {
    public void addSeries(SeriesEntity series);
    public void updateSeries(SeriesEntity series);
    public void removeSeries(long idSeries);
    public SeriesEntity getSeriesByID(long idSeries);
    public List<SeriesEntity> listSeries();
}
