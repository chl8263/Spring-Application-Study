package com.example.springmvc.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Event {

    @NotBlank
    private String name;

    @Min(0)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
