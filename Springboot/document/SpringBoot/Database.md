# Spring Database

Spring can set up kind of many data base and connect each others.

Typically, introduce how to set up h2 that memory data base at Spring.


First add dependency two setting as below at build.gradle. 
~~~groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-jdbc'
    compile group: 'com.h2database', name: 'h2', version: '1.4.200'
}
~~~

Second, write coed as like below for check database statement at browser.

~~~properties
spring.h2.console.enabled=true
~~~



~~~java
@Component
public class H2Runner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try(Connection connection = dataSource.getConnection()){
            connection.getMetaData().getURL();
            connection.getMetaData().getUserName();

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE USER(ID INTEGER NOT NUll, name VARCHAR(255))";
            statement.executeUpdate(sql);
        }

        jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'ewan')");
    }
}
~~~