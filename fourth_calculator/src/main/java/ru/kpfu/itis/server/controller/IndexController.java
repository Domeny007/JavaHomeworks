package ru.kpfu.itis.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/calculator")
    public String getIndexPage(){
        return "calculator";
    }
}
