package com.srhheidelberg.sad.taskmanager.swagger;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class DAPSwaggerConfig {
	
	public Docket allDAPControllerAPI() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.srhheidelberg.sad.taskmanager.restcontroller"))
				.paths(PathSelectors.regex("/JIRA-lite/TaskManager/*")).build();
	}

}
