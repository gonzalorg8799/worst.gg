package com.metrica.worst.entities;

public class Maestria {

	// <<----FIELDS--->

	private Integer   championLevel;
	private Integer championPoints;

	// <<----CONSTRUCTOR--->

	public Maestria(Integer championLevel, Integer championPoints) {
		super();
		this.championLevel = championLevel;
		this.championPoints = championPoints;
	}

	// <<----GETTERS & SETTERS--->

	public Integer getChampionLevel() {
		return championLevel;
	}

	public void setChampionLevel(Integer championLevel) {
		this.championLevel = championLevel;
	}

	public Integer getChampionPoints() {
		return championPoints;
	}

	public void setChampionPoints(Integer championPoints) {
		this.championPoints = championPoints;
	}

}
