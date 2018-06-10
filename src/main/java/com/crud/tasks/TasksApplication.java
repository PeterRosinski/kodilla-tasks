package com.crud.tasks;

import com.crud.tasks.repository.TaskRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.stereotype.Controller;

@SpringBootApplication
@EntityScan("com.crud.tasks.domain")
//@EnableJpaRepositories(basePackageClasses = TaskRepository.class)
//public class TasksApplication extends SpringBootServletInitializer {
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

	//@Override
	//protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	//	return application.sources(TasksApplication.class);
	//}
}
