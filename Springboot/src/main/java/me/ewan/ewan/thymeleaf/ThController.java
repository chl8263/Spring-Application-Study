package me.ewan.ewan.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThController {

    @GetMapping("/Ewan")
    public String hello(Model model){
        model.addAttribute("name", "ewan");

        return "hello";
    }
}
