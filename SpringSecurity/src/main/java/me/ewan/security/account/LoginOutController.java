package me.ewan.security.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginOutController {

    @GetMapping("/login")
    public String loginForm(){
        System.out.println("Login Controller");
        return "login";
    }

    @GetMapping("/logout")
        public String logoutForm(){
        return "logout";
    }
}
