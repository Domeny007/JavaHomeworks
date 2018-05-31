package ru.kpfu.itis.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.model.Calculate;
import ru.kpfu.itis.model.Result;

@Controller
public class CalculatorViewController {

    @RequestMapping("/calculator")
    public String onCalculatorView() {
        return "index";
    }

    @MessageMapping("/calculate")
    @SendTo("/calculator")
    public Result calculate(Calculate calc) {
        return new Result(calc);
    }

}
