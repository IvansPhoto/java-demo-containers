package com.example.demo_containers;

import org.springframework.boot.SpringApplication;

public class TestDemoContainersApplication {

	public static void main(String[] args) {
		SpringApplication.from(DemoContainersApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
