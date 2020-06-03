package controller;

import model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.SeriesService;
import service.SeriesServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import java.security.Principal;


@Controller
public class UsersEntryPointControllers {
    SeriesServiceImpl seriesService = new SeriesServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();


    @Autowired(required = true)
    @Qualifier(value = "seriesServiceImpl")
    public void setSeriesService(SeriesService seriesService) {
        this.seriesService = (SeriesServiceImpl) seriesService;
    }

    @Autowired(required = true)
    @Qualifier(value = "userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = (UserServiceImpl) userService;
    }


    @GetMapping("/") //Аннотация используется для маппинга урл-адреса запроса на указанный метод или класс. Запрос можно маппить как на метод класса, так и на целый класс. Допускается указывать конкретный HTTP-метод, который будет обрабатываться (GET/POST), передавать параметры запроса.
    public String getHomePage() {

        return "userPages/homePage";
    }

    @GetMapping(value = "authentication")
    public String getAuthenticationPage() {
        return "userPages/authentication";
    }

    @GetMapping(value = "registration")
    public String getRegistrationPage() {
        return "userPages/registration";
    }


    @PostMapping(value = "newRegistration")
    public String registrationOfUser(@ModelAttribute("user") UserEntity user, Principal principal) {  //Аннотация, связывающая параметр метода или возвращаемое значение метода с атрибутом модели, которая будет использоваться при выводе jsp-страницы.
        if (userService.checkUserReg(user.getEmail())) {
            userService.addUser(user);
            return "userPages/homePageSuccessfully";
        } else {
            return "userPages/authentication";
        }
    }

    @PostMapping(value = "authentication", produces = MediaType.TEXT_PLAIN_VALUE + "; charset=utf-8")
    public String authenticationOfUser(@ModelAttribute("user") UserEntity user, Principal principal) {
     if (userService.checkAdminAuthen(user)) {
            return "adminPages/adminMainPage";
        } else if (userService.blockingUserCheck(user)){
            return "userPages/userBlockedInfoPage";
        }
        else if (userService.checkUserAuthen(user.getEmail(), user.getPassword())) {
            return "userPages/homePageSuccessfully";
        } else {
            return "userPages/authentication";
        }
    }

}






