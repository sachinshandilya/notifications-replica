package com.demoProject.notificationsreplica.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//please note that application.properties file is automatically loaded in spring application so u dont need to add @PropertySource , if u want
//to add another properties file then u need to include it using @PropertySource annotation
@Configuration  //it is a configuration class ,so get loaded automatically when application starts 
@EnableSwagger2  //enable swagger in our app
public class SwaggerConfig {
	
	
	    @Value("${info.app.name}")  //@Value injets values from properties filr
	    private String serviceName;
	    
	    @Value("${info.app.desc}")
	    private String serviceDesc;

	    
	    
	    @Bean  //Create a bean of Docket
	    public Docket postsApi() {  //Docket instance used to customize swagger 
	        return new Docket(DocumentationType.SWAGGER_2) //tells Docket instance that customize Swagger2
	                .apiInfo(apiInfo())  //customize tile and description
	                .select()  //select following things for configuration
	                .apis(RequestHandlerSelectors.basePackage("com.demoProject.notificationsreplica.controllers")) //only show apis of this package
	                .build() //build the Docket instance
	        ;
	    }
	    
	    private ApiInfo apiInfo() {   //apiInfo is a methood which takes a function which returns customized headers of swagger like title, description
	        return new ApiInfoBuilder().title(serviceName).description(serviceDesc).build();
	    }

}
