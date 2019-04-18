/**
 * 
 */
package com.srhheidelberg.sad.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author kaust
 *
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableAutoConfiguration
public class TaskManagerApplication {

	/**
	 * @param args
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TaskManagerApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
		
	}

}
