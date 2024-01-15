package com.metrica.worst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrica.worst.services.ConseguirPuuid;
import com.metrica.worst.services.TiempoJugado;

@RestController
@RequestMapping("worst/gameTime")
public class TiempoJuegoController {

//	<<--FIELDS-->>
	private TiempoJugado tiempoService;
	private String puuid;

//  <<--CONSTRUCTOR-->>
	@Autowired
	public TiempoJuegoController(TiempoJugado tiempoService) {
		this.tiempoService=tiempoService;
	}
	
//	<<--METHODS-->>
	@GetMapping("/{tagLine}/{gameName}")
	public String getByPuuid(@PathVariable String tagLine, @PathVariable String gameName) {
		try {
			ConseguirPuuid conseguir = new ConseguirPuuid(tagLine, gameName);
			this.puuid=conseguir.getPUUID();
			String resultado= tiempoService.get(this.puuid);
			return resultado;
		}
		catch(RuntimeException e) {
			return "no se encontro ninguna partida";
		}
	}
}
