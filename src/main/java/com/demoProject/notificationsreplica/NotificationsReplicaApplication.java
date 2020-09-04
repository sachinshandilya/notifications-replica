package com.demoProject.notificationsreplica;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;





//It's same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations
@SpringBootApplication
public class NotificationsReplicaApplication {

	public static void main(String[] args) {  //its main method runs automatically when app runs
		System.out.println("notifications-replica");
		//lets try another logging method , using SLF4J api interface which uses Logback behind the scenes
		//both Logger and LoggerFactory are used from SLF4J api 
		Logger logger = LoggerFactory.getLogger(NotificationsReplicaApplication.class);
		logger.info("applied logger");
		SpringApplication.run(NotificationsReplicaApplication.class, args);
	}
	
	    @Bean  //this can be auto wired in other classes to use in connecting with other micro-services
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	    

}
