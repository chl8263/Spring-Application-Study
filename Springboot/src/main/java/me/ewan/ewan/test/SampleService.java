package me.ewan.ewan.test;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private String name = "hello";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
