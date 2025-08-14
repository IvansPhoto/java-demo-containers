package com.example.demo_containers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoContainersApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoContainersApplication.class, args);
    }

//    https://spring.io/quickstart
//    @GetMapping("/hello")
//    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return String.format("Hello %s!", name);
//    }


//    https://learn.microsoft.com/en-us/azure/developer/java/spring-framework/configure-spring-data-jdbc-with-azure-postgresql?tabs=passwordless%2Cservice-connector&pivots=postgresql-passwordless-flexible-server
    @Bean
    ApplicationListener<ApplicationReadyEvent> basicsApplicationListener(TodoRepository repository) {
        return event -> repository
                .saveAll(Stream
                        .of("A", "B", "C")
                        .map(name -> new Todo("configuration", "congratulations, you have set up correctly!", true))
                        .toList()
                )
                .forEach(System.out::println);
    }

}

interface TodoRepository extends CrudRepository<Todo, Long> {

}