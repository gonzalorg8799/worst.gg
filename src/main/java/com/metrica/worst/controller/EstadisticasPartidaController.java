package com.metrica.worst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrica.worst.services.ConseguirPuuid;
import com.metrica.worst.services.EstadisticasPartidaService;

@RestController
@RequestMapping("/worst/gameStats")
public class EstadisticasPartidaController {
	/* ATRIBUTES */
	@Autowired
	EstadisticasPartidaService estadisticasPartida;
	
	public EstadisticasPartidaController() {
	}
	
	/* METHOD */
	
	@GetMapping("/{gameName}/{tagLine}")
	public String getSpells(@PathVariable String gameName, @PathVariable String tagLine) {
		try {
			estadisticasPartida = new EstadisticasPartidaService(tagLine, gameName);
			return estadisticasPartida.estadisticasPartida();
		}
		catch(RuntimeException e) {
			return "No games played in the last 7 days";
		}
	}
}
