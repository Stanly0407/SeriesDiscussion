package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.SeriesService;
import service.SeriesServiceImpl;


@Controller
public class SeriesController {
     SeriesServiceImpl seriesService = new SeriesServiceImpl();

    @Autowired(required = true)
    @Qualifier(value = "seriesServiceImpl")
    public void setSeriesService(SeriesService seriesService) {
        this.seriesService = (SeriesServiceImpl) seriesService;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String getHomePage() {
        return "homePage";}

    //@RequestMapping(value = "")
}
