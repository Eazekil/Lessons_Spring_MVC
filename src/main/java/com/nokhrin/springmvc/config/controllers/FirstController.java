package com.nokhrin.springmvc.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "firstName", required = false) String firstName,
                            @RequestParam(value = "lastName", required = false) String lastName,
                            Model model){
        //System.out.println("Hello, "+firstName+" "+lastName);
        model.addAttribute("message","Hello, "+firstName+" "+lastName);
        return "first/hello";
    }
    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model){

        double result=0;
        if(action.equals("multiplication"))result=a*b;
        else if(action.equals("addition"))result=a+b;
        else if(action.equals("subtraction"))result=a-b;
        else if(action.equals("division"))result=(double)a/b;
        /*switch (action){
            case "multiplication":
                result=a*b;
                break;
            case "addition":
                result=a+b;
                break;
            case "subtraction":
                result=a-b;
                break;
            case "division":
                result=a/b;
                break;
        }*/


        model.addAttribute("action","Result = "+result);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}
