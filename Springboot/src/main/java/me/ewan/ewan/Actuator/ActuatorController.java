package me.ewan.ewan.Actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorController {

    @GetMapping("/actuator")
    public String actuator() {
        return "actuator";
    }
}
