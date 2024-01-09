package com.metrica.worst.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvocadorTest {

    private Invocador invocador;

    @BeforeEach
    public void setUp() {
        // Configuración inicial para cada prueba
        List<Partida> partidas = Arrays.asList(new Partida("2882930"));
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

    // Repite este patrón para los demás atributos y sus respectivos getters y setters

    @Test
    public void testNotNull() {
        assertNotNull(invocador);
    }
}
