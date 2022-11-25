package com.example.demo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo2.dao.UserDAO;
import com.example.demo2.model.User;

@Controller
public class Hello {

    @Autowired
    UserDAO userdao;

    @RequestMapping("/")
    public String hello() {
        return "index";
    }

    @RequestMapping("/addUser")
    public String adduser(User user) {
        userdao.save(user);
        return null;
    }

    @RequestMapping("/getUser")
    public ModelAndView getuser(@RequestParam int id) {

        ModelAndView mav = new ModelAndView("showUser");
        User user = userdao.findById(id).orElse(new User());
        System.out.println(userdao.findByName("varsha"));
        System.out.println(userdao.findByIdGreaterThan(2));
        /* System.out.println(userdao.findByNameSorted("varsha")); */
        mav.addObject(user);
        return mav;
    }

    @RequestMapping("/deleteUser")
    public ModelAndView deleteuser(@RequestParam int id) {

        ModelAndView mav = new ModelAndView("deleteUser");
        User user = userdao.findById(id).orElse(new User());
        userdao.deleteById(id);
        mav.addObject(user);
        return mav;
    }

    @RequestMapping("/updateUser")
    public ModelAndView updateuser(User user) {

        ModelAndView mav = new ModelAndView("updateUser");
        user = userdao.findById(user.getId()).orElse(new User());
        userdao.deleteById(user.getId());
        mav.addObject(user);
        return mav;
    }

}
