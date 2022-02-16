package com.vigjoaopaulo.projeto_novo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan(basePackages = "com.vigjoaopaulo.projeto_novo.MODEL")
@SpringBootApplication
public class MyAplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAplicationApplication.class, args);
	}

}
