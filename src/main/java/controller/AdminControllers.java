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
public class AdminControllers {
    UserServiceImpl userService = new UserServiceImpl();


    @Autowired(required = true)
    @Qualifier(value = "userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = (UserServiceImpl) userService;
    }



    @GetMapping(value = "adminUsersInfoList")
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
    public String blockingUser(@PathVariable("idUser") long idUser, Model model) {
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

    @RequestMapping("edit/{idUser}")
    public String editUser(@PathVariable("idUser") int idUser, Model model) {
        UserEntity user = userService.getUserByID(idUser);
        System.out.println(user);
        userService.evictUser(user);
        System.out.println(user);
        model.addAttribute("command", user);
        System.out.println(user);
        return "adminPages/adminUserEditFormPage";

    }

    @PostMapping(value="editSave")
    public String editSave(@ModelAttribute("user") UserEntity user, Model model){
        model.addAttribute("user", user);
        System.out.println(user);
        userService.updateUser(user);
        model.addAttribute("user", new UserEntity());
        model.addAttribute("listUsers", userService.listUsers());
        return "adminPages/adminUsersInfo";
    }
}
