# Spring Application


### The way for start application
There are few ways start Spring Boot Application in main method.

1. Using static method.

~~~java
SpringApplication.run(Application.class, args);
~~~

2. Using instance (Able to customizing). 

~~~java
SpringApplication app = new SpringApplication(Application.class);
app.run(args);
~~~

3. using SpringApplicationBuilder.

If want generate hierarchical Application Context, use SpringApplicationBuilder.
~~~java
new SpringApplicationBuilder()
        .sources(Application.class)
        .run(args);
~~~

### Applcation type
Where are few application type.

1. SERVLET

Can execute based on Servlet as write below code.

~~~java
SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
~~~

2. No web

Can execute based on just Java application as write below code.

~~~java
SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
~~~

3. Spring webflux

Can execute based on Spring webflux as write below code.

~~~java
SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.REACTIVE);
        app.run(args);
~~~

### Argument value

If you try to use an argument value and the value is `--bar`, can get this way as like below.

~~~java
@Component
public class SimpleListener2 {

    public SimpleListener2(ApplicationArguments arguments){
        System.out.println("bar: " + arguments.containsOption("bar"));
    }
}
~~~

The result like below.

~~~
2020-02-16 14:41:57.272  INFO 2452 --- [           main] me.ewan.ewan.Application                 : Starting Application on always with PID 2452 (C:\Users\gyun\IdeaProjects\SpringStudy+\build\classes\java\main started by gyun in C:\Users\gyun\IdeaProjects\SpringStudy+)
2020-02-16 14:41:57.277  INFO 2452 --- [           main] me.ewan.ewan.Application                 : No active profile set, falling back to default profiles: default
bar: true
~~~

### Application Listener

Can get be imported at application startup and end point.

1. ApplicationStartingEvent (When application starts)

~~~java
@Component
public class SimpleListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("=======================");
        System.out.println("Application is starting");
        System.out.println("=======================");
    }
}
~~~

But in this case, ApplicationStartingEvent create more faster than Application Context.

So need additional task that add Listener at Main method.

~~~java
 SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new SimpleListener());
        app.run(args);
~~~

2. ApplicationStartedEvent  (After application starts)

In this case, ApplicationStartedEvent created later than Application Context, so do not need any additional task.
~~~java
@Component
public class SimpleListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("=======================");
        System.out.println("Application is started");
        System.out.println("=======================");
    }
}
~~~