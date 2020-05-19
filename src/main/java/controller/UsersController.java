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


@Controller
public class UsersController {
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


    @GetMapping(value = "/")
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


    @PostMapping(value = "newRegistration", produces = MediaType.TEXT_PLAIN_VALUE + "; charset=utf-8")
    public String registrationOfUser(@ModelAttribute("user") UserEntity user) {
        if (userService.checkUserForm(user)) {
            return "userPages/registrationCheckForm";
        } else if (userService.checkUserReg(user.getEmail())) {
            userService.addUser(user);
            return "userPages/homePageSuccessfully";
        } else {
            return "userPages/authentication";
        }
    }

    @PostMapping(value = "authentication", produces = MediaType.TEXT_PLAIN_VALUE + "; charset=utf-8")
    public String authenticationOfUser(@ModelAttribute("user") UserEntity user) {
        if (userService.checkUserAuthenForm(user)) {
            return "userPages/authentication";
        }
        else if (userService.checkAdminAuthen(user)) {
            return "adminPages/adminMainPage";
      }
        else if (userService.checkUserAuthen(user.getEmail(), user.getPassword())) {
            return "userPages/homePageSuccessfully";
        } else {
            return "userPages/authentication";
        }
    }

    @GetMapping(value = "adminUsersInfoList")
 //   public ModelAndView listUsers() {
    // return new ModelAndView("redirect: /adminPages/adminMainPage", "listUsers", userService.listUsers());

        public String listUsers(Model model) {         // button "Список пользователей"
        System.out.println(userService.listUsers());
        model.addAttribute("user", new UserEntity());
        model.addAttribute("listUsers", userService.listUsers());
        return "adminPages/adminUsersInfo";

       }


    @RequestMapping("/remove/{idUser}")
    public String removeUser(@PathVariable("idUser") long idUser, Model model) {
        userService.removeUser(idUser);
        model.addAttribute("user", new UserEntity());
        model.addAttribute("listUsers", userService.listUsers());
        return "adminPages/adminUsersInfo";
    }

    @GetMapping("/blockingUser/{idUser}")
     public String blockingUser (@PathVariable("idUser") long idUser, Model model) {
        userService.blockingUser(idUser);
        model.addAttribute("user", new UserEntity());
        model.addAttribute("listUsers", userService.listUsers());
        return "adminPages/adminUsersInfo";
    }
    @GetMapping("/unBlockingUser/{idUser}")
    public String unBlockingUser(@PathVariable("idUser") long idUser, Model model) {
        userService.unBlockingUser(idUser);
        model.addAttribute("user", new UserEntity());
        model.addAttribute("listUsers", userService.listUsers());
        return "adminPages/adminUsersInfo";
    }

}
