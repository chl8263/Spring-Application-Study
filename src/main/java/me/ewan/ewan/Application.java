package me.ewan.ewan;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws LifecycleException {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
        //SpringApplication.run(Application.class, args);
    }
}
