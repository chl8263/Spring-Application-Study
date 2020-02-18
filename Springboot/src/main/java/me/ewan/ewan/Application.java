package me.ewan.ewan;

import org.apache.catalina.LifecycleException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableConfigurationProperties(EwanProperties.class)
public class Application {

    public static void main(String[] args) throws LifecycleException {
        SpringApplication app = new SpringApplication(Application.class);
        //app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
//        new SpringApplicationBuilder()
//                .sources(Application.class)
//                .run(args);
        //SpringApplication.run(Application.class, args);
    }
}
