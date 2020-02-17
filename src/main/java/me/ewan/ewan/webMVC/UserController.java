package me.ewan.ewan.webMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return "hello";
    }

    @PostMapping("/user/create")
    public User create(@RequestBody User user){
        return user;
    }
}
