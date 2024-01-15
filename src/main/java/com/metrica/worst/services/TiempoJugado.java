package com.metrica.worst.services;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@Service
public class TiempoJugado {
	private String puuid;
	private final String apiKey = "";
	
	public TiempoJugado(String puuid) {
		this.puuid=puuid;

	}
	public TiempoJugado() {
		
	}
	public String get(String puuid) {
		this.puuid=puuid;
		String url = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/"+this.puuid+"/ids?start=0&count=20&api_key="+this.apiKey;
		
		Client cliente = ClientBuilder.newClient();
    	WebTarget servicio;
    	
    	servicio=cliente.target(url);
    	String crudo= servicio.request(MediaType.APPLICATION_JSON).get(String.class);
    	String partida = new JsonParser()
    			.parse(crudo)
    			.getAsJsonArray()
    			.get(0)
    			.toString();
    	return tempJuego(partida);
	}
	private String tempJuego(String partida) {
		partida = partida.replace("\"", "");
		String url= "https://europe.api.riotgames.com/lol/match/v5/matches/"+partida+"?api_key="+this.apiKey;
		Client cliente = ClientBuilder.newClient();
    	WebTarget servicio;

    	servicio=cliente.target(url);
    	String crudo= servicio.request(MediaType.APPLICATION_JSON).get(String.class);
    	int tiempo = new JsonParser()
    			.parse(crudo)
    			.getAsJsonObject()
    			.getAsJsonObject("info")
    			.get("gameDuration")
    			.getAsInt();
    	return "la partida ha durado "+tiempo/60+" min";
    	
	}
}
