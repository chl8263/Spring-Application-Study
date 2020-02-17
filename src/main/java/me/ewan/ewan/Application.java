package me.ewan.ewan;

import me.ewan.ewan.externalSetting.EwanProperties;
import org.apache.catalina.LifecycleException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties(EwanProperties.class)
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
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
//        new SpringApplicationBuilder()
//                .sources(Application.class)
//                .run(args);
        //SpringApplication.run(Application.class, args);
    }
}
