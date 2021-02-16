package com.nokhrin.springmvc.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SecondController {

    @GetMapping("/exit")
    public String exit(){System.out.println();

        return "second/exit";
    }


}
