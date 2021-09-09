package com.nagal.tokenizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.nagal.tokenizer")
@SpringBootApplication
public class TokenizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenizerApplication.class, args);
	}

}
