package com.metrica.worst.entities;

import org.junit.jupiter.api.BeforeEach;

public class CampeonTest {

	private Campeon campeon;
	private Maestria maestria;
	private Maestria comparar;
	private Maestria nuevaMaestria;
	private Maestria nuevaMaestriaComparar;
	
	@BeforeEach
	public void setUp() {
		maestria = new Maestria(7, 147231);
		comparar = new Maestria(7, 147231);
		nuevaMaestria = new Maestria(5, 17000);
		nuevaMaestriaComparar = new Maestria(5, 17000);
		campeon = new Campeon("Aatrox", 47, "147", maestria);
	}
}
