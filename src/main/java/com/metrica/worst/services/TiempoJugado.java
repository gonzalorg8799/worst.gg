package com.metrica.worst.services;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@Service
public class TiempoJugado {
	private String puuid;
	private String apiKey;
	
	public TiempoJugado(String puuid, String apiKey) {
		this.puuid=puuid;
		this.apiKey=apiKey;
	}
	public TiempoJugado() {
		
	}
	public String get(String puuid, String apiKey) {
		this.puuid=puuid;
		this.apiKey=apiKey;
		String url = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/"+puuid+"/ids?start=0&count=20&api_key="+apiKey;
		
		Client cliente = ClientBuilder.newClient();
    	WebTarget servicio;
    	
    	servicio=cliente.target(url);
    	String crudo= servicio.request(MediaType.APPLICATION_JSON).get(String.class);
    	JsonArray jsonArray = new JsonParser().parse(crudo).getAsJsonArray();
    	String partida = jsonArray.get(0).toString();
    	return partida;
	}
}
