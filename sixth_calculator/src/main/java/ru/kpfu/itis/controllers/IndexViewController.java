package ru.kpfu.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexViewController {
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String onIndexPage() {
    return "redirect:/calculator";
  }
  
}
