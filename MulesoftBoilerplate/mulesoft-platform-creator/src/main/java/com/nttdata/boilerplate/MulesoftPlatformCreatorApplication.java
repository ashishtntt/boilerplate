package com.nttdata.boilerplate;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.nttdata.boilerplate", "com.nttdata.boilerplate.plugin"})
@EnableConfigurationProperties
public class MulesoftPlatformCreatorApplication {

	public static void main(String[] args) {
		
		SpringApplication springApp = new SpringApplication(MulesoftPlatformCreatorApplication.class);
	    //		ApplicationContext ctxt = SpringApplication.run(, args);
	    springApp.setDefaultProperties(Collections
	        .singletonMap("server.port", "8090"));
	    springApp.run(args);
	}

}
