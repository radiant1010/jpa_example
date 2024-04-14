package com.jpa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA Repository 읽기 설정
public class JpaIdGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaIdGenApplication.class, args);
	}

}
