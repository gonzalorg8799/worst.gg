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
        assertEquals(1, invocador.getPartidas().size());
        assertEquals("PartidaId", invocador.getPartidas().get(0).getPartidaId());
    }


    @Test
    public void testNotNull() {
        assertNotNull(invocador);
    }

    @Test
    public void testWinrateCampeon() {
        assertNotNull(invocador.getWinrateCampeon());
        assertEquals(3, invocador.getWinrateCampeon().size()); 

        assertTrue(invocador.getWinrateCampeon().contains(60.0));
        assertTrue(invocador.getWinrateCampeon().contains(70.0));
        assertTrue(invocador.getWinrateCampeon().contains(80.0));
    }
    @Test
    public void testSetPartidas() {
        List<Partida> nuevasPartidas = Arrays.asList(new Partida("123456"), new Partida("789012"));
        invocador.setPartidas(nuevasPartidas);

        assertEquals(nuevasPartidas, invocador.getPartidas());
    }

    @Test
    public void testSetCampeones() {
        List<Campeon> nuevosCampeones = Arrays.asList(new Campeon("nombreCampeon", 50.0, "championId",new Maestria(7,5000)));
        invocador.setCampeones(nuevosCampeones);

        assertEquals(nuevosCampeones, invocador.getCampeones());
    }

    @Test
    public void testSetWinrateSoloQ() {
        double nuevoWinrateSoloQ = 70.0;
        invocador.setWinrateSoloQ(nuevoWinrateSoloQ);

        assertEquals(nuevoWinrateSoloQ, invocador.getWinrateSoloQ());
    }

    @Test
    public void testSetWinrateFlex() {
        double nuevoWinrateFlex = 75.0;
        invocador.setWinrateFlex(nuevoWinrateFlex);

        assertEquals(nuevoWinrateFlex, invocador.getWinrateFlex());
    }

    @Test
    public void testSetWinrateNormal() {
        double nuevoWinrateNormal = 80.0;
        invocador.setWinrateNormal(nuevoWinrateNormal);

        assertEquals(nuevoWinrateNormal, invocador.getWinrateNormal());
    }
    @Test
    public void testSetWinrateCampeon() {
        List<Double> nuevoWinrateCampeon = Arrays.asList(70.0, 75.0, 85.0);
        invocador.setWinrateCampeon(nuevoWinrateCampeon);

        assertEquals(nuevoWinrateCampeon, invocador.getWinrateCampeon());
    }
}