package com.interview.demo.billmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class BillManagerSwaggerConfig {
	
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.interview.demo.billmanager"))
	                .paths(PathSelectors.regex("/api.*"))                     
	                .build().apiInfo(this.apiInfo());         
	    }
	 
	 private ApiInfo apiInfo() {
	        return new ApiInfoBuilder().title("Bill Manager API").version("1.0.0").build();
	    }
	 
	 

	

}
