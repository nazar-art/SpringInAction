package com.habuma.spitter.mvc;

import com.habuma.spitter.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Map;

@Controller
public class HomeController {

    //<start id="spittlesPerPage"/>
    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
    private SpitterService spitterService;
    private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;


    @Inject
    public HomeController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String showHomePage(Map<String, Object> model) {
        model.put("spittles",
                spitterService.getRecentSpittles(spittlesPerPage));
        return "home";
    }

    public int getSpittlesPerPage() {
        return spittlesPerPage;
    }

    public void setSpittlesPerPage(int spittlesPerPage) {
        this.spittlesPerPage = spittlesPerPage;
    }
    //<end id="spittlesPerPage"/>
}
