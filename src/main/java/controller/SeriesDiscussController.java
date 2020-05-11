package controller;

import model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.SeriesService;
import service.SeriesServiceImpl;
import service.UserServiceImpl;

import java.time.LocalDate;


@Controller
public class SeriesDiscussController {
     SeriesServiceImpl seriesService = new SeriesServiceImpl();
     UserServiceImpl userService = new UserServiceImpl();

    @Autowired(required = true)
    @Qualifier(value = "seriesServiceImpl")
    public void setSeriesService(SeriesService seriesService) {
        this.seriesService = (SeriesServiceImpl) seriesService;
    }

    @GetMapping(value="/")
    public String getHomePage() {
        return "homePage";}

    @GetMapping(value = "authentication")
    public String getAuthenticationPage() {
        return "authentication";}

    @GetMapping(value = "registration")
    public String getRegistrationPage() {
        return "registration";}

    @PostMapping(value = "newRegistration", produces = MediaType.TEXT_PLAIN_VALUE +"; charset=utf8")
    public String registrationOfUser(@ModelAttribute("user") UserEntity user
         //   ,
         //      @RequestParam("start")
         //  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
         //        LocalDate date
    ){   if (user.getIdUser() == 0){
        userService.addUser(user);
        return "homePageSuccessfully";
    }else {
        return "authentication"; }}

}
