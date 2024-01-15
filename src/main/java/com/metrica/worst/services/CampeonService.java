package com.metrica.worst.services;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.metrica.worst.entities.ApiKey;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@Service
public class CampeonService {
	/*  WEB CLIENT ATRIBUTE */
	Client cliente;
	WebTarget target;
	
		/*  REQUEST ATRIBUTES 	*/
	ConseguirPuuid conseguirPuuid;
	
	private String CHAMPION_MASTERY_REQUEST;
	
	/* 	SUMMONER DATA 		*/
	private String tagLine;
	private String gameName;
	private String PUUID;
	private String championId;
	
	/*  CHAMPION DATA		*/
	private int championLevel;
	private int championPoints;
	private long championPointsUntilNextLvl;
	private long championPointsSinceLastLvl;
	private boolean chestGranted;
	private int tokensEarned;
	
	
	/*  CONSTRUCTOR  		*/
	public CampeonService(
			String tagLine, 
			String gameName,
			String championId) {
		this.tagLine = tagLine;
		this.gameName = gameName;
		this.championId = championId;
		
		this.cliente 			   = ClientBuilder.newClient();
		this.conseguirPuuid = new ConseguirPuuid(tagLine, gameName);
		
		
		this.setPUUID(conseguirPuuid.getPUUID());
		
		setCHAMPION_MASTERY_REQUEST();
		getMastery();
		
	}

	public CampeonService() {
	}
	
	public String DatosCampeon() {
		return "Con el campeon de ID: " + getChampionId() 
			+ "\nTienes nivel de maestría: " + getChampionLevel() 
			+ "\nTienes "+ getChampionPoints() +" puntos de maestría, te quedan " + getChampionPointsUntilNextLvl() + " puntos de maestría para subir de nivel y has ganado " + getChampionPointsSinceLastLvl() + " puntos en este nivel"
			+ "\nTienes " + getTokensEarned() + " tokens de maestría"
			+ "\nHas ganado cofre con el campeón: " + isChestGranted();
	}

	
	
	public String getCHAMPION_MASTERY_REQUEST() {
		return CHAMPION_MASTERY_REQUEST;
	}

	public void setCHAMPION_MASTERY_REQUEST() {
		CHAMPION_MASTERY_REQUEST ="https://euw1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-puuid/" + this.PUUID
																														  + "/by-champion/" + this.championId
																														  + "?api_key=" + ApiKey.getApikey();
	}

	public String getPUUID() {
		return PUUID;
	}


	public void setPUUID(String pUUID) {
		PUUID = pUUID;
	}


	public String getChampionId() {
		return championId;
	}

	public void setChampionId(String championId) {
		this.championId = championId;
	}

	public int getChampionLevel() {
		return championLevel;
	}


	public void setChampionLevel(int championLevel) {
		this.championLevel = championLevel;
	}


	public int getChampionPoints() {
		return championPoints;
	}


	public void setChampionPoints(int championPoints) {
		this.championPoints = championPoints;
	}


	public long getChampionPointsUntilNextLvl() {
		return championPointsUntilNextLvl;
	}


	public void setChampionPointsUntilNextLvl(long championPointsUntilNextLvl) {
		this.championPointsUntilNextLvl = championPointsUntilNextLvl;
	}


	public long getChampionPointsSinceLastLvl() {
		return championPointsSinceLastLvl;
	}


	public void setChampionPointsSinceLastLvl(long championPointsSinceLastLvl) {
		this.championPointsSinceLastLvl = championPointsSinceLastLvl;
	}


	public String isChestGranted() {
		if (chestGranted) return "Si";
		return "No";
	}


	public void setChestGranted(boolean chestGranted) {
		this.chestGranted = chestGranted;
	}


	public int getTokensEarned() {
		return tokensEarned;
	}


	public void setTokensEarned(int tokensEarned) {
		this.tokensEarned = tokensEarned;
	}
	
	public void getMastery() {
		String response = cliente.target(CHAMPION_MASTERY_REQUEST).request(MediaType.APPLICATION_JSON).get(String.class);
		JsonObject data = new Gson().fromJson(response, JsonObject.class);
		
		championId = data.get("championId").getAsString();
		championLevel = data.get("championLevel").getAsInt();
		championPoints = data.get("championPoints").getAsInt();
		championPointsUntilNextLvl = data.get("championPointsUntilNextLevel").getAsLong();
		championPointsSinceLastLvl = data.get("championPointsSinceLastLevel").getAsLong();
		chestGranted = data.get("chestGranted").getAsBoolean();
		tokensEarned = data.get("tokensEarned").getAsInt();
		
		
	}
	
	public String getApiKey() {
		return ApiKey.getApikey();
	}

}
