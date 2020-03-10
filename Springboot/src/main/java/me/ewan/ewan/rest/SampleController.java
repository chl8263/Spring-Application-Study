package me.ewan.ewan.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/rest")
    public String hello() throws Exception {
        Thread.sleep(3000l);
        return "hello";
    }

    @GetMapping("/word")
    public String world() throws Exception {
        Thread.sleep(3000l);
        return "world";
    }
}
