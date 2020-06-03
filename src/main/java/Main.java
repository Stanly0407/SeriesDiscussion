
import model.CommentSeriesEntity;
import model.SeriesEntity;
import model.UserEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import service.SeriesService;
import service.SeriesServiceImpl;
import service.UserServiceImpl;

import java.time.LocalDate;

public class Main {

    public static void main(final String[] args) {
        SeriesServiceImpl seriesService = new SeriesServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

//        SeriesEntity series = new SeriesEntity ("Тест - наименование",
//                "Тест - содержание",
//                "Тест - страна", "Тест - жанр 1", "Тест - жанр 1",
//                2020,
//                1, 1, 1);
//        seriesService.addSeries(series);
//        System.out.println(series + "\n");

 //seriesService.removeSeries(10);
//        seriesService.removeSeries(16);
//
   //    userService.removeUser(41);



//  UserEntity user = new UserEntity("Петр", "Ермошенко",
//          "DFGD@mail.ru", "gfdgjdfgfd",
//     LocalDate.parse("1989-12-11"));
//userService.addUser(user);
   //  System.out.println(user +"\n");



        System.out.println(seriesService.listSeries());

        System.out.println(userService.checkUserReg("TRRome@gmail.com"));

        System.out.println(userService.listUsers());

        System.out.println(seriesService.getSeriesByID(1));

        //  userService.blockingUser(53);
  //       userService.unBlockingUser(53);
      //  System.out.println(userService.getUserByID(53));
     UserEntity user = userService.getUserByID(1);
        System.out.println(user);
        System.out.println( userService.blockingUserCheck(user));

    }
}