package com.metrica.worst.services;

import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.metrica.worst.entities.ApiKey;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@Service
public class EstadisticasPartidaService {
		/*  WEB CLIENT ATRIBUTE */
	Client cliente;
	WebTarget target;
	
		/*  REQUEST ATRIBUTES 	*/
	ConseguirPuuid conseguirPuuid;
	
	private String MATCH_HISTORY_REQUEST;
	private String MATCH_DATA_REQUEST;
		
		/* 	SUMMONER DATA 		*/
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
			String gameName) {
		
		this.cliente 			   = ClientBuilder.newClient();
		this.conseguirPuuid = new ConseguirPuuid(tagLine, gameName);
		
		this.setStartHistoryTime();
		this.setEndHistoryTime();
		
		this.setPUUID(conseguirPuuid.getPUUID());
		this.setMATCH_HISTORY_REQUEST(getPUUID());
		this.setMatchId();
		this.setMATCH_DATA_REQUEST(getMatchId());
		
		this.setSpell1Casts();
		this.setSpell2Casts();
		this.setSpell3Casts();
		this.setSpell4Casts();
	}
	
	public EstadisticasPartidaService() {
	}

		/* METHODS 				*/
	public String estadisticasPartida() {
		return "Has usado la Q: " + spell1Casts + " veces, \nHas usado la W: " + spell2Casts + " veces, \nHas usado la E: " + spell3Casts + " veces, \nHas usado la R: " + spell4Casts + " veces."; 
	}
	
		/* GETTERS & SETTERS 	*/
	public String getMATCH_HISTORY_REQUEST() {
		return MATCH_HISTORY_REQUEST;
	}


	public void setMATCH_HISTORY_REQUEST(String puuid) {
		MATCH_HISTORY_REQUEST = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/" + getPUUID() 
							  + "/ids?startTime=" + endHistoryTime  + "&endTime=" + startHistoryTime + "&type=&start=0&count=1&api_key=" + ApiKey.getApikey();
		
	}


	public String getMATCH_DATA_REQUEST() {
		return MATCH_DATA_REQUEST;
	}


	public void setMATCH_DATA_REQUEST(String mATCH_DATA_REQUEST) {
		MATCH_DATA_REQUEST = "https://europe.api.riotgames.com/lol/match/v5/matches/" + getMatchId() + "?api_key=" + ApiKey.getApikey();
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


	public void setPUUID(String puuid) {
		this.PUUID = conseguirPuuid.getPUUID();
	}


	public String getMatchId() {
		return matchId;
	}


	public void setMatchId() {
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
		return ApiKey.getApikey();
	}
	
	private int getCasts(int spell) {
		String dataJson = cliente.target(getMATCH_DATA_REQUEST()).request(MediaType.APPLICATION_JSON).get(String.class);
		
		//Getting participant position
		int partsPosition = getSummonerPosition(dataJson);
		
		//Sacando habilidades
		JsonObject matchDataJson = new Gson().fromJson(dataJson, JsonObject.class);
		JsonElement spellCasts = matchDataJson.get("participants").getAsJsonArray().get(partsPosition).getAsJsonObject().get("info")
				  .getAsJsonArray().getAsJsonObject().get("spell" + spell + "Casts");
		
		return Integer.parseInt(spellCasts.toString()); 
	}
	
	private int getSummonerPosition(String dataJson) {
		JsonObject metadataJson = new Gson().fromJson(dataJson, JsonObject.class);
		JsonArray participantsArray = metadataJson.get("metadata").getAsJsonArray().getAsJsonObject()
												  .get("participants").getAsJsonArray();
		
		for(JsonElement elemento : participantsArray) {
			if(elemento.toString().replace("\"", "").equals(getPUUID())) { return elemento.getAsInt(); }
		} return 0;
	}
	
}
