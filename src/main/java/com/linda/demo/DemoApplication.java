package com.linda.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
//@ComponentScan(basePackages = "com.linda.demo.detail")
@EnableAutoConfiguration
@ComponentScan

//@EnableJpaRepositories(basePackages = "com.linda.demo.detail.Repo")
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }
}
