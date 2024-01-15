package com.metrica.worst.services;

import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jayway.restassured.path.json.JsonPath;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;


public class EstadisticasPartidaService {
		/*  WEB CLIENT ATRIBUTE */
	Client cliente;
	WebTarget target;
	
		/*  REQUEST ATRIBUTES 	*/
	private String PUUID_REQUEST;
	private String MATCH_HISTORY_REQUEST;
	private String MATCH_DATA_REQUEST;
	private final String apiKey;
		
		/* 	SUMMONER DATA 		*/
	private String tagLine;
	private String gameName;
	private String PUUID;
	private String matchId;
	
		/* 	GAME DATA 			*/
	private int spell1Casts;
	private int spell2Casts;
	private int spell3Casts;
	private int spell4Casts;
	
		/* TIME STAMPS		    */
	private long startHistoryTime;
	private long endHistoryTime;
	
		/* 	CONSTRUCTOR			*/
	public EstadisticasPartidaService(
			String tagLine, 
			String gameName,
			String apiKey) {
		this.tagLine 			   = tagLine;
		this.gameName			   = gameName;
		this.apiKey				   = apiKey;
		
		this.cliente 			   = ClientBuilder.newClient();
		
		this.setStartHistoryTime();
		this.setEndHistoryTime();
		this.setPUUID_REQUEST(gameName, tagLine);
		this.setPUUID();
		this.setMATCH_HISTORY_REQUEST(getPUUID());
		this.setMatchId(apiKey);
		this.setMATCH_DATA_REQUEST(getMatchId());
		this.setSpell1Casts();
		this.setSpell2Casts();
		this.setSpell3Casts();
		this.setSpell4Casts();
	}

		/* METHODS 				*/
	
	public String estadisticasPartida() {
		return "Has usado la Q: " + spell1Casts + " veces, \nHas usado la W: " + spell2Casts + " veces, \nHas usado la E: " + spell3Casts + " veces, \nHas usado la R: " + spell4Casts + " veces."; 
	}
	
		/* GETTERS & SETTERS 	*/
	public String getPUUID_REQUEST() {
		return PUUID_REQUEST;
	}


	public void setPUUID_REQUEST(String gameNameSet, String tagLineSet) {
		PUUID_REQUEST = "https://europe.api.riotgames.com/riot/account/v1/accounts/by-riot-id/" + gameNameSet + "/" + tagLineSet + "?api_key=" + apiKey;
	}


	public String getMATCH_HISTORY_REQUEST() {
		return MATCH_HISTORY_REQUEST;
	}


	public void setMATCH_HISTORY_REQUEST(String puuid) {
		MATCH_HISTORY_REQUEST = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/" + getPUUID() 
							  + "/ids?startTime=" + endHistoryTime  + "&endTime=" + startHistoryTime + "&type=&start=0&count=1&api_key=" + apiKey;
		
	}


	public String getMATCH_DATA_REQUEST() {
		return MATCH_DATA_REQUEST;
	}


	public void setMATCH_DATA_REQUEST(String mATCH_DATA_REQUEST) {
		MATCH_DATA_REQUEST = "https://europe.api.riotgames.com/lol/match/v5/matches/" + getMatchId() + "?api_key=" + apiKey;
	}


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


	public long getStartHistoryTime() {
		return startHistoryTime;
	}

	public void setStartHistoryTime() {
		this.startHistoryTime = System.currentTimeMillis() / 1000;
	}

	public long getEndHistoryTime() {
		return endHistoryTime;
	}

	public void setEndHistoryTime() {
		this.endHistoryTime = (System.currentTimeMillis() - 722604800) / 1000;
	}

	public String getPUUID() {
		return PUUID;
	}


	public void setPUUID() {
		String accountJson = cliente.target(getPUUID_REQUEST()).request(MediaType.APPLICATION_JSON).get(String.class);
		JsonObject objJson = new Gson().fromJson(accountJson, JsonObject.class);
		this.PUUID = objJson.get("puuid").toString().replace("\"", "");
	}


	public String getMatchId() {
		return matchId;
	}


	public void setMatchId(String matchId) {
		String accountJson = cliente.target(getMATCH_HISTORY_REQUEST()).request(MediaType.APPLICATION_JSON).get(String.class);
		JsonElement elmJson = new Gson().fromJson(accountJson, JsonElement.class);
		this.matchId = elmJson.toString().replaceAll("[\\[\\]\"]", "");
	}


	public int getSpell1Casts() {
		return spell1Casts;
	}


	public void setSpell1Casts() {
		this.spell1Casts = getCasts(1); 
	}


	public int getSpell2Casts() {
		return spell2Casts;
	}


	public void setSpell2Casts() {
		this.spell2Casts = getCasts(2);
	}


	public int getSpell3Casts() {
		return spell3Casts;
	}


	public void setSpell3Casts() {
		this.spell3Casts = getCasts(3);
	}


	public int getSpell4Casts() {
		return spell4Casts;
	}


	public void setSpell4Casts() {
		this.spell4Casts = getCasts(4);
	}


	public String getApiKey() {
		return apiKey;
	}
	
	private int getCasts(int spell) {
		String dataJson = cliente.target(getMATCH_DATA_REQUEST()).request(MediaType.APPLICATION_JSON).get(String.class);
		int partsPosition = 0;
		
		//Sacando posicion participante
		JsonObject metadataJson = new Gson().fromJson(dataJson, JsonObject.class);
		JsonElement dataJson1 = metadataJson.get("metadata");
		String metadata = dataJson1.toString();
		
		JsonObject metadataJson2 = new Gson().fromJson(metadata, JsonObject.class);
		JsonArray arrayParts = metadataJson2.getAsJsonArray("participants");
		
		for(JsonElement elemento : arrayParts) {
			if(elemento.toString().replace("\"", "").equals(getPUUID())) { break; }
			partsPosition++;
		}
		
		//Sacando habilidades
		JsonObject objJson = new Gson().fromJson(dataJson, JsonObject.class);
		JsonElement infoJson = objJson.get("info");
		String info = infoJson.toString();
		
		JsonObject objJson2 = new Gson().fromJson(info, JsonObject.class);
		JsonArray participants = objJson2.getAsJsonArray("participants");
		
		String container = participants.toString();
		
		int contador = 0;
		String spellCasts = "";
		for(JsonElement elemento : participants) {
			if(contador == partsPosition) {
				spellCasts = elemento.toString();
				break;
			}
			contador++;
		}
		
		JsonObject objJson3 = new Gson().fromJson(spellCasts, JsonObject.class);
		JsonElement spellCastsJson = objJson3.get("spell" + Integer.toString(spell) + "Casts");
		
		return Integer.parseInt(spellCastsJson.toString()); 
	}
	
}
