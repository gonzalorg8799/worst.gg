package com.metrica.worst.entities;

public class Jugador {
	private double winrateSoloQ;
	private int cantidadPartidas;
	private int puntos;
	public Jugador(double winrateSoloQ, int cantidadPartidas, int puntos) {
		super();
		this.winrateSoloQ = winrateSoloQ;
		this.cantidadPartidas = cantidadPartidas;
		this.puntos = puntos;
	}
	public double getWinrateSoloQ() {
		return winrateSoloQ;
	}
	public void setWinrateSoloQ(double winrateSoloQ) {
		this.winrateSoloQ = winrateSoloQ;
	}
	public int getCantidadPartidas() {
		return cantidadPartidas;
	}
	public void setCantidadPartidas(int cantidadPartidas) {
		this.cantidadPartidas = cantidadPartidas;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
}
