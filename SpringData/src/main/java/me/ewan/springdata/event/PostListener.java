package me.ewan.springdata.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class PostListener implements ApplicationListener<PostPublishedEvent> {

    @Override
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("------------");
        System.out.println(event.getPost());
        System.out.println("------------");
    }
}
