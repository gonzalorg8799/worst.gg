package com.metrica.worst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.metrica.worst.services.EstadisticasPartidaService;

@SpringBootApplication
public class WorstApplication {

	public static void main(String[] args) {
//		SpringApplication.run(WorstApplication.class, args);
		EstadisticasPartidaService c1 = new EstadisticasPartidaService("3590", "Karkinos", "RGAPI-751483ca-8277-40ed-811f-d267cf6d5da9");
		c1.estadisticasPartida();
	}
	
	
}
