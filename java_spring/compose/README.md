
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

(5) 
