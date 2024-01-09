package com.metrica.worst.entities;

import java.util.List;

public class Invocador {
//	<<--ATTRIBUTES-->
	private String nombre;
	private String tag;
	private List <Partida> partidas;
	private List <Campeon> campeones;
	private double winrateSoloQ;
	private double winrateFlex;
	private double winrateNormal;
	private List<Double> winrateCampeon;
	
//	<<--CONSTRUCTOR-->>
	public Invocador(String nombre, String tag, List<Partida> partidas, List<Campeon> campeones, double winrateSoloQ,
			double winrateFlex, double winrateNormal, List<Double> winrateCampeon) {
		super();
		this.nombre = nombre;
		this.tag = tag;
		this.partidas = partidas;
		this.campeones = campeones;
		this.winrateSoloQ = winrateSoloQ;
		this.winrateFlex = winrateFlex;
		this.winrateNormal = winrateNormal;
		this.winrateCampeon = winrateCampeon;
	}
	
//	<<--GETTERS & SETTERS-->>
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public List<String> getPartidas() {
		return partidas;
	}
	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}
	public List<Campeon> getCampeones() {
		return campeones;
	}
	public void setCampeones(List<Campeon> campeones) {
		this.campeones = campeones;
	}
	public double getWinrateSoloQ() {
		return winrateSoloQ;
	}
	public void setWinrateSoloQ(double winrateSoloQ) {
		this.winrateSoloQ = winrateSoloQ;
	}
	public double getWinrateFlex() {
		return winrateFlex;
	}
	public void setWinrateFlex(double winrateFlex) {
		this.winrateFlex = winrateFlex;
	}
	public double getWinrateNormal() {
		return winrateNormal;
	}
	public void setWinrateNormal(double winrateNormal) {
		this.winrateNormal = winrateNormal;
	}
	public List<Double> getWinrateCampeon() {
		return winrateCampeon;
	}
	public void setWinrateCampeon(List<Double> winrateCampeon) {
		this.winrateCampeon = winrateCampeon;
	}
	
}
