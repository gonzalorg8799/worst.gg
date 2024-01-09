package com.metrica.worst.entities;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MaestriaTest {


		// <<----CONSTANTS---->>
		
		private static final Integer CHAMPIONLEVEL = 18;
		private static final Integer CHAMPIONPOINTS = 9000;
		
		@Test
		@Tag("Contructor")
		void constructorTest() {
			
			Maestria maestria = new Maestria(CHAMPIONLEVEL, CHAMPIONPOINTS);
			
			 assertEquals(CHAMPIONLEVEL, maestria.getChampionLevel());
			 assertEquals(CHAMPIONPOINTS, maestria.getChampionPoints());
		}
		
		@Test
		@Tag("GetterSetter")
		void setMaestriaTest() {
			
			Maestria maestria = new Maestria(0, 0);
			
			maestria.setChampionLevel(10);
			maestria.setChampionPoints(5000);
			
			 assertEquals(10, maestria.getChampionLevel());
			 assertEquals(5000, maestria.getChampionPoints());
			 
			 assertNotNull(maestria);
		}
		
		
	}
