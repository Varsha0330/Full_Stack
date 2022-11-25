package com.example.demo2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo2.dao.UserDAO;
import com.example.demo2.model.User;

@RestController
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

    @GetMapping("/User")
    @CrossOrigin(origins = "http://localhost:4200/")
    public List<User> getuser() {
        return userdao.findAll();
    }

    @PostMapping("/User")
    @CrossOrigin(origins = "http://localhost:4200/")
    public User creatUser(@RequestBody User user) {
        return userdao.save(user);
    }

    @GetMapping("User/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public User getUserById(@PathVariable Integer id) {
        User user = userdao.findById(id).orElse(new User());
        return user;
    }

    // update the rest api
    @PutMapping("User/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public User updateUserById(@PathVariable Integer id, @RequestBody User userDetails) {
        User user = userdao.findById(id).orElse(new User());
        user.setId(userDetails.getId());
        user.setName(userDetails.getName());
        user.setTech(userDetails.getTech());
        User updateUser = userdao.save(user);
        return updateUser;
    }

    // delete the rest api
    @DeleteMapping("User/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public User deleteUser(@PathVariable Integer id) {
        User user = userdao.findById(id).orElse(new User());
        userdao.delete(user);
        return user;
    }

}
