package me.ewan.ewan.externalSetting;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("ewan")
public class EwanProperties {

    private String name;

    private int ageNumber;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeNumber() {
        return ageNumber;
    }

    public void setAgeNumber(int ageNumber) {
        this.ageNumber = ageNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
