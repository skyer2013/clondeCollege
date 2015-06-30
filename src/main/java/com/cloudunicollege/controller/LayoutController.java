package com.cloudunicollege.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by u6031313 on 6/23/2015.
 */
@Controller
@RequestMapping("/layout")
public class LayoutController {
    @RequestMapping("/footer")
    public String footer(){
        return "/layout/footer";
    }
    @RequestMapping("/header")
    public String header(){
        return "/layout/header";
    }
    @RequestMapping("/navbar")
    public String navbar(){
        return "/layout/navbar";
    }
    @RequestMapping("/template")
    public String template(){
        return "/layout/template";
    }
}
