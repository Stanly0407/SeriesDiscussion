package repository;


import model.SeriesEntity;

import java.util.List;

public interface SeriesDao {
     void addSeries(SeriesEntity series);
     void updateSeries(SeriesEntity series);
     void removeSeries(long idSeries);
     SeriesEntity getSeriesByID(long idSeries);
     List<SeriesEntity> listSeries();
     void evictSeries (SeriesEntity series);







}
