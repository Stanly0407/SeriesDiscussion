package controller;

import model.Authorities;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.SeriesService;
import service.SeriesServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import java.security.Principal;
import java.util.Set;


@Controller
public class UsersEntryPointControllers {

    SeriesServiceImpl seriesService = new SeriesServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

//    @PreAuthorize("hasAuthority('USER')")
    @PostMapping(value = "authentication")
    public String authenticationOfUser(@ModelAttribute("user") User user, Model model, Principal principal) {

//model.addAttribute("message", "You are logged in as " + principal.getName());
     //       return "adminPages/adminMainPage";
//        } else if (userService.blockingUserCheck(user)){
//            return "userPages/userBlockedInfoPage";
//        }
//        else if (userService.checkUserAuthen(user.getEmail(), user.getPassword())) {
//            return "userPages/homePageSuccessfully";
//        } else {
//            return "userPages/authentication";
            return "/userPages/homePageSuccessfully";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "adminAccount")
    public String getAdminAccount (@ModelAttribute("user") User user, Model model, Principal principal
                                      //SecurityContextHolderAwareRequestWrapper request
    ) {
        //if (request.isUserInRole("ADMIN")) {
        return "adminPages/adminMainPage"; }

    @GetMapping(value = "personalAccount")
    public String getPersonalAccount (@ModelAttribute("user") User user, Model model, Principal principal
    //SecurityContextHolderAwareRequestWrapper request
    ) {
        //if (request.isUserInRole("ADMIN")) {
        return "/userPages/homePageSuccessfully"; }

//  //  @PreAuthorize("hasAuthority('USER')")
//    @GetMapping("/") //Аннотация используется для маппинга урл-адреса запроса на указанный метод или класс. Запрос можно маппить как на метод класса, так и на целый класс. Допускается указывать конкретный HTTP-метод, который будет обрабатываться (GET/POST), передавать параметры запроса.
//    public String getHomePage() {
//        return "userPages/homePage";
//    }
//
    @GetMapping(value = "authentication_button")
    public String getAuthenticationPage() {
        return "userPages/authentication";
    }

//    @GetMapping(value = "registration")
//    public String getRegistrationPage() {
//        return "userPages/registration";
//    }
//
//
//    @PostMapping(value = "newRegistration")
//    public String registrationOfUser(@ModelAttribute("user") UserEntity user, Principal principal) {  //Аннотация, связывающая параметр метода или возвращаемое значение метода с атрибутом модели, которая будет использоваться при выводе jsp-страницы.
//        if (userService.checkUserReg(user.getEmail())) {
//            userService.addUser(user);
//            return "userPages/homePageSuccessfully";
//        } else {
//            return "userPages/authentication";
//        }
//    }
//




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
}






