package com.cloudunicollege.controller;

import com.cloudunicollege.entities.po.User;
import com.cloudunicollege.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by celine on 2015/6/28.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User rstUser =userService.findUserByNameAndPassword(user);
        if(rstUser!=null){
            request.getSession().setAttribute("user", rstUser);
            modelAndView.setViewName("redirect:/home/index");
            modelAndView.addObject(rstUser);

        }else{
            modelAndView.setViewName("redirect:/home/index");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/loginAjax",method = RequestMethod.POST)
    public @ResponseBody String loginAjax(
            User user,
            HttpServletRequest request
    ){
/*        User user = new User();
        user.setUsername(username);
        user.setPassword(password);*/
        User rstUser =userService.findUserByNameAndPassword(user);
        request.getSession().setAttribute("user",rstUser);
        return rstUser.getName();
    }
    @RequestMapping(value = "/logoutAjax",method = RequestMethod.POST)
    public @ResponseBody String logoutAjax(
            HttpServletRequest request
    ){
/*        User user = new User();
        user.setUsername(username);
        user.setPassword(password);*/
        request.getSession().removeAttribute("user");
        return "true";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/home/index";
    }
    @RequestMapping("/register")
    public String register(){
        return "/account/register";
    }
    @RequestMapping(value = "/register.do", method =RequestMethod.POST)
    public ModelAndView registerDo(
            @RequestParam(value = "nickname",required = false)String nickname,
            @RequestParam(value = "username",required = false)String username,
            @RequestParam(value = "password",required = false)String password,
            @RequestParam(value = "autoLogin",required = false)String autoLogin,
            HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView();
        String test = request.getParameter("nickname");
        if (nickname!=null&&username!=null&&password!=null){
            User user = new User();
            user.setName(nickname);
            user.setPassword(password);
            user.setUsername(username);
            userService.saveUser(user);
            if (autoLogin!=null){
                request.getSession().setAttribute("user",user);
            }
            modelAndView.setViewName("redirect:/home/index");
            modelAndView.addObject(user);
        }
        else {
            modelAndView.setViewName("/account/register");
            modelAndView.addObject("message","输入有误");
        }
        return modelAndView;
    }
}
