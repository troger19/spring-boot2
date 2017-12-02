package com.example;

//import com.example.springboot2.configuration.entity.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Spring Boot application for configuration and Spring-Data example
 */
@SpringBootApplication
@EnableConfigurationProperties
public class SpringBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2Application.class, args);
	}

	// read the property from application.yml

	// using value
	@Value("${configuration.projectName}")
	public void setProjectName(String projectName){
		System.out.println("The project name from value is : " + projectName);
	}

	//using Environment
	@Autowired
	public void setEnvironment(Environment environment){
		System.out.println("The project name from environment is " + environment.getProperty("configuration.projectName"));
	}

	//using Bean, which is injected
	@Autowired
	public void setConfigurationProjectProperties(ConfigurationProjectProperties configurationProjectProperties){
		System.out.println("The project name from configuration properties " + configurationProjectProperties.getProjectName());
	}

//	@Bean
//	CommandLineRunner exampleQuery(CarRepository repository){
//		return args->repository.findByMakeIgnoringCase("HONDA").forEach(System.out::println);
//	}

	// this Bean represent the configuration object as defined in application.yml
	@Component
	@ConfigurationProperties("configuration")
	class ConfigurationProjectProperties{
		private String projectName;

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
	}
}
