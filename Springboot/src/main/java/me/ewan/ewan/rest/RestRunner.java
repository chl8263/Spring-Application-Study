package me.ewan.ewan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Component
public class RestRunner implements ApplicationRunner {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        RestTemplate restTemplate = restTemplateBuilder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String helloReslut = restTemplate.getForObject("http://localhost:8080/rest", String.class);
        System.out.println(helloReslut);

        String worldReslut = restTemplate.getForObject("http://localhost:8080/word", String.class);
        System.out.println(worldReslut);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
