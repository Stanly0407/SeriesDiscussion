package service;

import model.SeriesEntity;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface SeriesService {
    @Secured("ADMIN")
    void addSeries(SeriesEntity series);

    void updateSeries(SeriesEntity series);

    void removeSeries(long idSeries);

    SeriesEntity getSeriesByID(long idSeries);

    List<SeriesEntity> listSeries();

    void evictSeries(SeriesEntity series);
}
