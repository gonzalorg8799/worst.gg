package com.metrica.worst.entities;

public class Campeon {

//	<<--ATRIBUTES-->>	
	private String nombre;
	private double winRate;
	private String championId;
	private Maestria maestria;
	
//	<<--CONSTRUCTOR-->>
	public Campeon(String nombre, double winRate, String championId, Maestria maestria) {
		this.nombre = nombre;
		this.winRate = winRate;
		this.championId = championId;
		this.maestria = maestria;
	}

//	<<--GETTERS & SETTERS-->>
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getWinRate() {
		return winRate;
	}

	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}

	public String getChampionId() {
		return championId;
	}

	public void setChampionId(String championId) {
		this.championId = championId;
	}

	public Maestria getMaestria() {
		return maestria;
	}

	public void setMaestria(Maestria maestria) {
		this.maestria = maestria;
	}
}
