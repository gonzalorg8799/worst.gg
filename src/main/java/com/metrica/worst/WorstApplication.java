package com.metrica.worst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.metrica.worst.services.EstadisticasPartidaService;

@SpringBootApplication
public class WorstApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorstApplication.class, args);
	}
}
