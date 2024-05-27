package de.htwberlin.webtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class WebtechbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtechbackendApplication.class, args);
	}

}
