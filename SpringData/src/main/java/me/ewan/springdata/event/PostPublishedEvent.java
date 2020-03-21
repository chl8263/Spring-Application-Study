package me.ewan.springdata.event;

import me.ewan.springdata.domain.Post;
import me.ewan.springdata.domain.Post2;
import org.springframework.context.ApplicationEvent;

public class PostPublishedEvent<T> extends ApplicationEvent {

    private final T t;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PostPublishedEvent(Object source) {
        super(source);
        this.t = (T) source;
    }

    public T getPost(){
        return this.t;
    }

}
