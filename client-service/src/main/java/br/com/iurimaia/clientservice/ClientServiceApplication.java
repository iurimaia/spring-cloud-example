package br.com.iurimaia.clientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableEurekaClient
@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedMethods("GET", "POST", "PATCH", "DELETE", "HEAD").allowedOrigins("*");
				registry.addMapping("/*/*").allowedMethods("GET", "POST", "PATCH", "DELETE", "HEAD").allowedOrigins("*");
				registry.addMapping("/*/*/*").allowedMethods("GET", "POST", "PATCH", "DELETE", "HEAD").allowedOrigins("*");
			}
		};
	}
}
