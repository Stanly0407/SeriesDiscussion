package controller;


import model.User;
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


    @GetMapping(value = "admin/UsersInfoList")
    public String listUsers(Model model) {         // button "Список пользователей"
        System.out.println(userService.listUsers());
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());
        return "adminPages/adminUsersInfo";
    }


    @RequestMapping("/removeUser/{idUser}")
    public String removeUser(@PathVariable("idUser") String username, Model model) {
        userService.removeUser(username);
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());
        return "adminPages/adminUsersInfo";
    }

    @GetMapping("/blockingUser/{email}")
    public String blockingUser(@PathVariable("email") String username, Model model) {
        userService.blockingUser(username);
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());
        return "adminPages/adminUsersInfo";
    }

    @GetMapping("/unBlockingUser/{idUser}")
    public String unBlockingUser(@PathVariable("idUser") String username, Model model) {
        userService.unBlockingUser(username);
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());
        return "adminPages/adminUsersInfo";
    }

    @RequestMapping("editUser/{idUser}")
    public String editUser(@PathVariable("idUser") String username, Model model) { // Аннотация, которая показывает, что параметр метода должен быть связан с переменной из урл-адреса.
        User user = userService.getUserByUsername(username);
        System.out.println(user);
        userService.evictUser(user);
        System.out.println(user);
        model.addAttribute("command", user);
        System.out.println(user);
        return "adminPages/adminUsersEditFormPage";
    }

    @PostMapping(value="editSaveUser")
    public String editSaveUser(@ModelAttribute("user") User user, Model model){ //Аннотация, связывающая параметр метода или возвращаемое значение метода с атрибутом модели, которая будет использоваться при выводе jsp-страницы.
        model.addAttribute("user", user);
        System.out.println(user);
        userService.updateUser(user);
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());
        return "adminPages/adminUsersInfo";
    }
}
