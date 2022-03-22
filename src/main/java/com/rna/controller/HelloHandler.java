package com.rna.controller;

import com.rna.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloHandler {
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name","张三");
        return modelAndView;
    }

    @RequestMapping("/score")
    public ModelAndView score(){
        ModelAndView modelAndView = new ModelAndView("score");
        modelAndView.addObject("score",90);
        return modelAndView;
    }

    @RequestMapping("/switch")
    public ModelAndView switch_(@RequestParam("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("switch");
        modelAndView.addObject("studentId",id);
        return modelAndView;
    }

    @GetMapping("/test")
    public ModelAndView each(){
        List<User> list = Arrays.asList(new User(1,"zhangsan"),
                new User(2,"lisi"));
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

}
