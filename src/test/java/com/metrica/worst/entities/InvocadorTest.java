package com.metrica.worst.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvocadorTest {

    private Invocador invocador;

    @BeforeEach
    public void setUp() {
        // Configuración inicial para cada prueba
        List<Partida> partidas = Arrays.asList(new Partida("PartidaId"));
        List<Campeon> campeones = Arrays.asList(new Campeon("nombreCampeon", 50.0, "championId",new Maestria(7,5000)));
        List<Double> winrateCampeon = Arrays.asList(60.0, 70.0, 80.0);

        invocador = new Invocador("Nombre", "Tag", partidas, campeones, 55.0, 60.0, 65.0, winrateCampeon);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Nombre", invocador.getNombre()); 
    }

    @Test
    public void testSetNombre() {
        invocador.setNombre("NuevoNombre");
        assertEquals("NuevoNombre", invocador.getNombre());
    }

    @Test
    public void testGetTag() {
        assertEquals("Tag", invocador.getTag());
    }

    @Test
    public void testSetTag() {
        invocador.setTag("NuevoTag");
        assertEquals("NuevoTag", invocador.getTag());
    }

    @Test
    public void testGetPartidas() {
        assertNotNull(invocador.getPartidas());
        assertEquals(1, invocador.getPartidas().size()); // Verifica que haya una partida en la lista
        assertEquals("PartidaId", invocador.getPartidas().get(0).getPartidaId()); // Ajusta según la estructura de tu Partida
    }

    // Repite este patrón para los demás atributos y sus respectivos getters y setters

    @Test
    public void testNotNull() {
        assertNotNull(invocador);
    }

    @Test
    public void testWinrateCampeon() {
        assertNotNull(invocador.getWinrateCampeon());
        assertEquals(3, invocador.getWinrateCampeon().size()); // Verifica que haya tres valores en la lista

        // Verifica algunos valores específicos
        assertTrue(invocador.getWinrateCampeon().contains(60.0));
        assertTrue(invocador.getWinrateCampeon().contains(70.0));
        assertTrue(invocador.getWinrateCampeon().contains(80.0));
    }
}