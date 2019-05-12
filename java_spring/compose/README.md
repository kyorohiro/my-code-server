
## HOW TO USE

(1)

```
$ docker-compose up -d
$ docker-compose build
```

(2) open browser http://127.0.0.1:8443


(3)  Create App

```
$ gradle init --type java-application
$ gradle build
```

(4) modify build.gradle 

```
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.5.RELEASE")
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'idea'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

bootJar {
    baseName = 'gs-rest-service'
    version =  '0.1.0'
}

repositories {
    mavenCentral()
}

sourceCompatibility = 11
targetCompatibility = 11

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    testCompile('org.springframework.boot:spring-boot-starter-test')
    implementation('org.springframework.boot:spring-boot-starter-thymeleaf:2.1.4.RELEASE')
    implementation('org.mybatis:mybatis-spring:2.0.1')
    implementation('org.mybatis:mybatis:3.5.1')
    implementation('org.springframework.boot:spring-boot-starter-jdbc:2.1.4.RELEASE')
    implementation('org.mariadb.jdbc:mariadb-java-client:2.4.1')
}

```

(5) src/main/resources/application.properties 

```
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://mysql/hello
spring.datasource.username=root
spring.datasource.password=passwd
```

(6) mybatis-config.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC 
        "-//mybatis.org//DTD Config 3.0//EN" 
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true" />
    </settings>
</configuration>

```

(7) src/main/java/helloworld/App.java 

```
package helloworld;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // MyBatisの設定
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));
        return sessionFactory.getObject();
    }
}
```

(8) src/main/java/helloworld/GreetingController.java 

```
package helloworld;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public String greeting() {
        System.out.print(">> greeting");
        return "/hello";
    }
}
```

(9) src/main/resources/templates/hello.html 
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8" />
    <title>hello.html</title>
  </head>
  <body>
    Hello!!
  </body>
</html>

```

(10) run
```
gradle bootRun
```
