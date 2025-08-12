package com.ss.spring.finalex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SameehaIte5435FinalExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SameehaIte5435FinalExamApplication.class, args);
	}
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
