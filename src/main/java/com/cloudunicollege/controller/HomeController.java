package com.cloudunicollege.controller;

import com.cloudunicollege.entities.po.Session;
import com.cloudunicollege.entities.po.User;
import com.cloudunicollege.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by u6031313 on 6/23/2015.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(HttpServletRequest request,ModelMap modelMap){
        Object user = request.getSession().getAttribute("user");
        if (user!=null){
            modelMap.addAttribute(user);
        }
        return "/home/index";
    }
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession httpSession)
    {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User rstUser =userService.findUserByNameAndPassword(user);
        if(rstUser!=null){
            httpSession.setAttribute("user", user);
            modelAndView.addObject(rstUser);
        }else{

        }
        modelAndView.setViewName("/home/index");
        return modelAndView;
    }
}
