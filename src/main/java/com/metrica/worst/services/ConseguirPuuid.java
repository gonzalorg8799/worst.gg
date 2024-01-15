package com.metrica.worst.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ConseguirPuuid {
	/* ATRIBUTES */
	Client cliente;
	WebTarget target;
	
	private String PUUID_REQUEST;
	
	private String tagLine;

	private String gameName;
	private String PUUID;
	private final String apiKey = "RGAPI-26d88b7e-412b-44b5-8cfd-e40e44ef056a";
	
	/* CONSTRUCTOR */
	public ConseguirPuuid(String tagLine, String gameName) {
		this.tagLine  = tagLine;
		this.gameName = gameName;
		
		this.cliente  = ClientBuilder.newClient(); 
		
		this.setPUUID_REQUEST(gameName, tagLine);
		this.setPUUID(this.gameName, this.tagLine);
	}
	
	/* GETTERS SETTERS */
	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getPUUID() {
		return PUUID;
	}

	public void setPUUID(String gameName, String tagLine) {
		String accountJson = cliente.target(getPUUID_REQUEST()).request(MediaType.APPLICATION_JSON).get(String.class);
		JsonObject objJson = new Gson().fromJson(accountJson, JsonObject.class);
		this.PUUID = objJson.get("puuid").toString().replace("\"", "");
	}

	public String getApiKey() {
		return apiKey;
	}
	
	public String getPUUID_REQUEST() {
		return PUUID_REQUEST;
	}
	
	public void setPUUID_REQUEST(String gameNameSet, String tagLineSet) {
		PUUID_REQUEST = "https://europe.api.riotgames.com/riot/account/v1/accounts/by-riot-id/"  
				+ gameNameSet + "/" + tagLineSet + "?api_key=" + apiKey;
	}
	
}
