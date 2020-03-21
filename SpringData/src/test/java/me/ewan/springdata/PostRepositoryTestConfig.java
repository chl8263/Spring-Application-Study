package me.ewan.springdata;

import me.ewan.springdata.event.PostListener;
import me.ewan.springdata.event.PostPublishedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostRepositoryTestConfig {

    @Bean
    public PostListener postListener(){
        return new PostListener();
    }
}
