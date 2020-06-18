package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.SeriesService;
import service.SeriesServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import java.security.Principal;


@Controller
public class UsersEntryPointControllers {
    SeriesServiceImpl seriesService = new SeriesServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @GetMapping("/")
   public String getHomePage(Model model, Principal principal) {
        model.addAttribute("message", "Hello " + principal.getName());
        return "userPages/homePageSuccessfully";
    }

    @GetMapping(value = "/registration")
    public String getRegistrationPage() {
        return "userPages/registration";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "adminAccount")
    public String getAdminAccount (@ModelAttribute("user") User user, Model model, Principal principal) {
        return "adminPages/adminMainPage"; }


    @GetMapping(value = "authentication_button")
    public String getAuthenticationPage() {
        return "userPages/authentication";
    }

    @PostMapping(value = "/newRegistration")
    public String registrationOfUser(@ModelAttribute("user") User user, Principal principal) {  //Аннотация, связывающая параметр метода или возвращаемое значение метода с атрибутом модели, которая будет использоваться при выводе jsp-страницы.
        if (userService.checkUserReg(user.getUsername())) {
            userService.addUser(user);
            return "userPages/homePageSuccessfully";
        } else {
            return "userPages/authentication"; }
    }

    @GetMapping(value = "personalAccount")
    public String getPersonalAccount (@ModelAttribute("user") User user, Model model, Principal principal
    //SecurityContextHolderAwareRequestWrapper request
    ) {
        //if (request.isUserInRole("ADMIN")) {
        return "/userPages/homePageSuccessfully"; }


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

