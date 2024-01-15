package com.metrica.worst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.metrica.worst.services.EstadisticasPartidaService;

@SpringBootApplication
public class WorstApplication {

	public static void main(String[] args) {
//		SpringApplication.run(WorstApplication.class, args);
		EstadisticasPartidaService c1 = new EstadisticasPartidaService("top g", "Master G", "RGAPI-26d88b7e-412b-44b5-8cfd-e40e44ef056a");
		c1.estadisticasPartida();
	}
	
	
}
