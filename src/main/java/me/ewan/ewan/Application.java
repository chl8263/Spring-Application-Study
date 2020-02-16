package me.ewan.ewan;

import me.ewan.ewan.bootApplication.SimpleListener;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws LifecycleException {
        SpringApplication app = new SpringApplication(Application.class);
//        app.setBanner(new Banner() {
//            @Override
//            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//                out.println("===========");
//                out.println("Spring +");
//                out.println("===========");
//            }
//        });
        //app.addListeners(new SimpleListener());
        app.setWebApplicationType(WebApplicationType.REACTIVE);
        app.run(args);
//        new SpringApplicationBuilder()
//                .sources(Application.class)
//                .run(args);
        //SpringApplication.run(Application.class, args);
    }
}
