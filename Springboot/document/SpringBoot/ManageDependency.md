# Spring Boot Dependency manage

### How configure spring dependency?

Spring boot is managed dependency base on __spring-boot-starter-parent__ in pom.xml if using maven.

~~~
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.0.M1</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.example</groupId>
    <artifactId>demo</artifactId>
    
    .........
~~~

When click __spring-boot-dependencies__, can see real managed dependency configure.

~~~
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.3.0.M1</version>
  </parent>
  <artifactId>spring-boot-starter-parent</artifactId>
  <packaging>pom</packaging>
  <description>Parent pom providing dependency and plugin management for applications built with Maven</description>
  <properties>
    
    .........
~~~

~~~
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <modelVersion>4.0.0</modelVersion>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-dependencies</artifactId>
  <version>2.3.0.M1</version>
  <packaging>pom</packaging>
  <description>Spring Boot Dependencies</description>
  <url>https://projects.spring.io/spring-boot/#</url>
  <organization>
    <name>Pivotal Software, Inc.</name>
    <url>https://spring.io</url>
  </organization>
  <licenses>
    <license>
      <name>Apache License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0</url>
    </license>
  </licenses>
  <developers>
    <developer>
      <name>Pivotal</name>
      <email>info@pivotal.io</email>
      <organization>Pivotal Software, Inc.</organization>
      <organizationUrl>https://www.spring.io</organizationUrl>
    </developer>
  </developers>
  <scm>
    <connection>scm:git:git://github.com/spring-projects/spring-boot.git</connection>
    <developerConnection>scm:git:ssh://git@github.com/spring-projects/spring-boot.git</developerConnection>
    <url>https://github.com/spring-projects/spring-boot</url>
  </scm>
  <issueManagement>
    <system>GitHub</system>
    <url>https://github.com/spring-projects/spring-boot/issues</url>
  </issueManagement>
  <properties>
    <activemq.version>5.15.11</activemq.version>
    <antlr2.version>2.7.7</antlr2.version>
    <appengine-sdk.version>1.9.77</appengine-sdk.version>
    <artemis.version>2.10.1</artemis.version>
    <aspectj.version>1.9.5</aspectj.version>
    <assertj.version>3.14.0</assertj.version>
    <atomikos.version>4.0.6</atomikos.version>
    <awaitility.version>4.0.1</awaitility.version>
    <bitronix.version>2.1.4</bitronix.version>
    <build-helper-maven-plugin.version>3.0.0</build-helper-maven-plugin.version>
    <byte-buddy.version>1.10.4</byte-buddy.version>
    <caffeine.version>2.8.0</caffeine.version>
    
    .........
~~~

`<parent>` in pom.xml takes care of dependency management super well and Spring Boot recommend use `<parent>`.

If want custom own dependency configure without `<parent>` tag, can use `<dependencyManagement>` like below coed.   

~~~
<dependencyManagement>
    <dependencies>
        <dependency>
            <!-- Import dependency management from Spring Boot -->
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>2.2.4.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
~~~


If want add other dependency, just write dependency code in `<dependencies>` at pom.xml.

~~~
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.0.M1</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    
       .........
       
       
    <dependencies>
        <!-- modelmapper -->
        <dependency>
            <groupId>org.modelmapper</groupId>
            <artifactId>modelmapper</artifactId>
            <version>2.3.6</version>
        </dependency>
~~~


~~~
gyun@always MINGW64 ~/IdeaProjects/Spring-exe (master)
$ ls
document/  HELP.md  mvnw*  mvnw.cmd  pom.xml  README.md  Spring-exe.iml  src/  target/  tomcat.8080/  tomcat.9090/

gyun@always MINGW64 ~/IdeaProjects/Spring-exe (master)
$ keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 4000
Enter keystore password:
Re-enter new password:
What is your first and last name?
  [Unknown]:  Ewan choi
What is the name of your organizational unit?
  [Unknown]:  Ewan
What is the name of your organization?
  [Unknown]:  CEO
What is the name of your City or Locality?
  [Unknown]:  SEATTLE
What is the name of your State or Province?
  [Unknown]:  WA
What is the two-letter country code for this unit?
  [Unknown]:  yes
Is CN=Ewan choi, OU=Ewan, O=CEO, L=SEATTLE, ST=WA, C=yes correct?
  [no]:  yes


gyun@always MINGW64 ~/IdeaProjects/Spring-exe (master)
$ ls
document/  HELP.md  keystore.p12  mvnw*  mvnw.cmd  pom.xml  README.md  Spring-exe.iml  src/  target/  tomcat.8080/  tomcat.9090/

gyun@always MINGW64 ~/IdeaProjects/Spring-exe (master)
$ curl - I --http http://localhost:8080
curl: option -: is unknown
curl: try 'curl --help' or 'curl --manual' for more information

gyun@always MINGW64 ~/IdeaProjects/Spring-exe (master)
$ curl -I --http http://localhost:8080
curl: option --http: is ambiguous
curl: try 'curl --help' or 'curl --manual' for more information

gyun@always MINGW64 ~/IdeaProjects/Spring-exe (master)
$ curl -I --http2 http://localhost:8080
HTTP/1.1 404
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 13 Feb 2020 07:05:09 GMT


~~~