package com.metrica.worst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrica.worst.services.CampeonService;

@RestController
@RequestMapping("/worst/campeon")
public class CampeonController {
	
	/* ATRIBUTES */
	@Autowired
	CampeonService campeonService;
	
	public CampeonController() {
	}
	
	/* METHOD */
	
	@GetMapping("/{gameName}/{tagLine}/{championId}")
	public String getMastery(@PathVariable String gameName, @PathVariable String tagLine, @PathVariable String championId) {
		try {
			campeonService = new CampeonService(tagLine, gameName,championId);
			return campeonService.DatosCampeon();
		}
		catch(RuntimeException e) {
			return "No Champion Data";
		}
	}
}