package me.ewan.security.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginOutController {

    @GetMapping("/login")
    public String loginForm(){
        System.out.println("!!!!!!!!!!!");
        return "login";
    }

    @GetMapping("/logout")
        public String logoutForm(){
        return "logout";
    }
}
