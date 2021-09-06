package com.example.demoapp;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoappApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoappApplication.class, args);
		// Beans
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}

		System.out.println(context.getBeanDefinitionCount());
	}

}
