package com.metrica.worst.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	
	@Test
	public void testSetters() {
		assertEquals("Aatrox", campeon.getNombre());
		assertEquals(47, campeon.getWinRate());
		assertEquals("147", campeon.getChampionId());
		assertEquals(comparar, campeon.getMaestria());
		
		campeon.setNombre("Frederick");
		campeon.setWinRate(53.45);
		campeon.setChampionId("200");
		campeon.setMaestria(nuevaMaestria);
		
		assertEquals("Frederick", campeon.getNombre());
		assertEquals(53.45, campeon.getWinRate());
		assertEquals("200", campeon.getChampionId());
		assertEquals(nuevaMaestriaComparar, campeon.getMaestria());
	}
}
