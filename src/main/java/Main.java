
import model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import service.SeriesServiceImpl;
import service.UserServiceImpl;

public class Main {

    public static void main(final String[] args) {
        SeriesServiceImpl seriesService = new SeriesServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        User user = userService.getUserByUsername("admin");
        System.out.println(user);

//       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = (String) authentication.getDetails();
//        System.out.println(currentPrincipalName);

        System.out.println(userService.listUsers());

    }
}