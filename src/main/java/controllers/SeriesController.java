package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.SeriesService;
import service.SeriesServiceImpl;


@Controller
public class SeriesController {
    public SeriesService seriesService = new SeriesServiceImpl();

//    @Autowired(required = true)
//    @Qualifier(value = "seriesService")
//    public void setSeriesService(SeriesService seriesService) {
//        this.seriesService = seriesService;
//    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String getHomePage() {
        return "homePage";}

    //@RequestMapping(value = "")
}
