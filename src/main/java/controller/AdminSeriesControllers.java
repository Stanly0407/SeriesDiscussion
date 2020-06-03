package controller;


import model.SeriesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.SeriesService;
import service.SeriesServiceImpl;


@Controller
public class AdminSeriesControllers {
    SeriesServiceImpl seriesService = new SeriesServiceImpl();

    @Autowired(required = true)
    @Qualifier(value = "seriesServiceImpl")
    public void setUserService(SeriesService seriesService) {
        this.seriesService = (SeriesServiceImpl) seriesService;
    }

    @GetMapping(value = "adminSeriesInfoList")
    public String listSeries(Model model) {         // button "Список сериалов"
        System.out.println(seriesService.listSeries());
        model.addAttribute("series", new SeriesEntity());
        model.addAttribute("listSeries", seriesService.listSeries());
        return "adminPages/adminSeriesInfo";
    }

    @RequestMapping("editSeries/{idSeries}")
    public String editSeries(@PathVariable("idSeries") int idSeries, Model model) {
        SeriesEntity series = seriesService.getSeriesByID(idSeries);
        System.out.println(series);
        seriesService.evictSeries(series);
        System.out.println(series);
        model.addAttribute("command", series);
        System.out.println(series);
        return "adminPages/adminSeriesEditFormPage";
    }

    @PostMapping(value="editSaveSeries")
    public String editSaveSeries(@ModelAttribute("series") SeriesEntity series, Model model){
        model.addAttribute("series", series);
        System.out.println(series);
        seriesService.updateSeries(series);
        model.addAttribute("series", new SeriesEntity());
        model.addAttribute("listSeries", seriesService.listSeries());
        return "adminPages/adminSeriesInfo";
    }


    @RequestMapping("/removeSeries/{idSeries}")
    public String removeSeries(@PathVariable("idSeries") long idSeries, Model model) {
        seriesService.removeSeries(idSeries);
        model.addAttribute("series", new SeriesEntity());
        model.addAttribute("listSeries", seriesService.listSeries());
        return "adminPages/adminSeriesInfo";
    }

    @GetMapping(value = "addingNewSeriesButton")
    public String addingNewSeriesButton (@ModelAttribute("series") SeriesEntity series, Model model){
        model.addAttribute("command", series);
        return "adminPages/adminSeriesAddingFormPage";
    }

    @PostMapping(value = "addingNewSeries")
    public String addingNewSeries (@ModelAttribute("series") SeriesEntity series, Model model) {
            seriesService.addSeries(series);
        model.addAttribute("series", new SeriesEntity());
        model.addAttribute("listSeries", seriesService.listSeries());
            return "adminPages/adminSeriesInfo";}



}
