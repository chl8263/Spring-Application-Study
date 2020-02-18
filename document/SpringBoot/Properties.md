# Properties

Spring can get Properties value from external properties file.

First, make `application.properties` file in resources file.

And write like this.

~~~
ewan.name = ewan
ewan.ageNumber = 26
ewan.age = ${ewan.ageNumber}
ewan.sessionTimeout = 25
~~~ 

Then, use like below code at Class file.

~~~java
@Component
public class ExternalSettingRunner implements ApplicationRunner {

    @Value("${Ewan.name}")
    private String name;

    @Value("${Ewan.age}")
    private String name2;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===================");
        System.out.println(properties.name);
        System.out.println(properties.name2);
        System.out.println("===================");
    }
}
~~~

Also mapping Class file.

First register Bean in Spring, second add annotation `@ConfigurationProperties` and also adapt validation as using `@Validated`

~~~java
@Component
@ConfigurationProperties("ewan")
@Validated
public class EwanProperties {

    @NotEmpty
    private String name;

    private int ageNumber;

    private String age;

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration sessionTimeout = Duration.ofSeconds(30);

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

    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
}
~~~
