package controller;


import model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import service.UserServiceImpl;


@Controller
public class AdminUsersControllers {
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


    @RequestMapping("/removeUser/{idUser}")
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

    @RequestMapping("editUser/{idUser}")
    public String editUser(@PathVariable("idUser") int idUser, Model model) { // Аннотация, которая показывает, что параметр метода должен быть связан с переменной из урл-адреса.
        UserEntity user = userService.getUserByID(idUser);
        System.out.println(user);
        userService.evictUser(user);
        System.out.println(user);
        model.addAttribute("command", user);
        System.out.println(user);
        return "adminPages/adminUsersEditFormPage";
    }

    @PostMapping(value="editSaveUser")
    public String editSaveUser(@ModelAttribute("user") UserEntity user, Model model){ //Аннотация, связывающая параметр метода или возвращаемое значение метода с атрибутом модели, которая будет использоваться при выводе jsp-страницы.
        model.addAttribute("user", user);
        System.out.println(user);
        userService.updateUser(user);
        model.addAttribute("user", new UserEntity());
        model.addAttribute("listUsers", userService.listUsers());
        return "adminPages/adminUsersInfo";
    }
}
