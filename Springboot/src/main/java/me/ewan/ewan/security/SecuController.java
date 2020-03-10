package me.ewan.ewan.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecuController {

    @GetMapping("/secu")
    public String secu() {
        return "hello";
    }

    @GetMapping("/secuMy")
    public String my() {
        return "my";
    }

}
