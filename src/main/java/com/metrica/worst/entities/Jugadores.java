package com.metrica.worst.entities;

import java.util.List;

public class Jugadores {
	private List<Jugador> jugadores;

	public Jugadores(List<Jugador> jugadores) {
		super();
		this.jugadores = jugadores;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
}
