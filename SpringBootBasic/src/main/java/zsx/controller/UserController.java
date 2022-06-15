package zsx.controller;


import zsx.entity.User;
import zsx.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserById")
    public User getUser(@RequestParam("id") int id){
        return userService.getUserById(id);
    }

    @GetMapping("/getUserByAge")
    public List<User> getUserByAge(@RequestParam("age") int age){
        log.info("My log");
        return userService.getUserByAge(age);
    }
}
