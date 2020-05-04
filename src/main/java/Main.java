
import model.CommentSeriesEntity;
import model.SeriesEntity;
import service.SeriesService;
import service.SeriesServiceImpl;

public class Main {

    public static void main(final String[] args) {
        SeriesServiceImpl seriesService = new SeriesServiceImpl();
        SeriesEntity series = new SeriesEntity ("Тест - наименование",
                "Тест - содержание",
                "Тест - страна", "Тест - жанр 1", "Тест - жанр 1",
                2020,
                1, 1, 1);
        seriesService.addSeries(series);
        System.out.println(series + "\n");

        seriesService.removeSeries(16);

        System.out.println(seriesService.getSeriesByID(1));





    }
}