package com.habuma.spitter.mvc.restless;

import com.habuma.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ShowSpitterController {
    @Autowired
    SpitterService spitterService;

    @RequestMapping(value = "/showSpitter",        //<co id="co_verbyUrl"/>
            method = RequestMethod.GET)
    public String showSpitter(@RequestParam String username, //<co id="co_usernameParam"/>
                              Map<String, Object> model) {
        model.put("spitter", spitterService.getSpitter(username));
        return "spitter";
    }
}
