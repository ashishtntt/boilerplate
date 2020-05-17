package com.nttdata.boilerplate;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nttdata.boilerplate.builder.MuleBaseArchetypeBuilderConfiguration;

@ComponentScan(basePackages = { "com.nttdata.boilerplate" })
@SpringBootApplication
@EnableConfigurationProperties
public class BoilerplatePlatformCreatorApplication {

	public static void main(String[] args) {
		SpringApplication springApp = new SpringApplication(BoilerplatePlatformCreatorApplication.class);
//		ApplicationContext ctxt = SpringApplication.run(, args);
		springApp.setDefaultProperties(Collections
				.singletonMap("server.port", "8090"));
		springApp.run(args);
		
	}

}
