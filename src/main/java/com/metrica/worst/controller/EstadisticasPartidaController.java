package com.metrica.worst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrica.worst.services.ConseguirPuuid;
import com.metrica.worst.services.EstadisticasPartidaService;

@RestController
@RequestMapping("worst/gameStats")
public class EstadisticasPartidaController {
	/* ATRIBUTES */
	EstadisticasPartidaService estadisticasPartida;
	ConseguirPuuid conseguirPuuid;

	@Autowired
	public EstadisticasPartidaController(EstadisticasPartidaService estadisticasPartida) {
		this.estadisticasPartida = estadisticasPartida;
	}
	
	/* METHOD */
	
	@GetMapping("{gameName}/{tagLine}")
	public String getSpells(@PathVariable String gameName, String tagLine) {
		try {
			conseguirPuuid = new ConseguirPuuid(gameName, tagLine);
			return estadisticasPartida.estadisticasPartida();
		}
		catch(RuntimeException e) {
			return "No games played in the last 7 days";
		}
	}
}
