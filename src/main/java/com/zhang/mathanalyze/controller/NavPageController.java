package com.zhang.mathanalyze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavPageController {


    @RequestMapping("/algorithm1")
    public String test() {
        return "index";
    }

    @RequestMapping("/algorithm2")
    public String test2(){
        return "MathAnalyze/algorithm";
    }


    @RequestMapping("/algorithm3")
    public String test3(){
        return "MathAnalyze/algorithm1";
    }

    @RequestMapping("/algorithm4")
    public String test4(){
        return "MathAnalyze/algorithm2";
    }

    @RequestMapping("/algorithm5")
    public String test5(){
        return "MathAnalyze/algorithm3";
    }

    @RequestMapping("/algorithm6")
    public String test6(){
        return "MathAnalyze/algorithm4";
    }
}
