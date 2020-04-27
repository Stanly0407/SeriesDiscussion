import dao.SeriesDaoImpl;
import model.SeriesEntity;

public class Main {

    public static void main(final String[] args) {
        SeriesDaoImpl seriesDaoImpl = new SeriesDaoImpl();
        SeriesEntity series = new SeriesEntity ("Тест - наименование",
                "Тест - содержание",
                "Тест - страна", "Тест - жанр 1", "Тест - жанр 1",
                2020,
                1, 1, 1);
        seriesDaoImpl.addSeries(series);
        System.out.println(series + "\n");

       seriesDaoImpl.removeSeries(13);

        System.out.println(seriesDaoImpl.getSeriesByID(1));

    }
}