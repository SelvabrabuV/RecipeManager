package com.mansanto.mbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.mansanto.mbt")
public class SpringApp {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
SpringApplication.run(SpringApp.class,args);


System.out.println("finished");
	}

}
