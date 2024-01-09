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
	
}
