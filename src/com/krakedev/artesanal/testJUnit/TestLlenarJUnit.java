package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {

	@Test
	public void testLlenarMaquina() {
		Maquina rubia = new Maquina("Pilsener", "Cerveza", 0.02, 8000, "COD006");

		rubia.llenarMaquina();

		// Antes era 7900 (8000 - 100)
		// Ahora debe ser 7800 (8000 - 200)
		assertEquals(7800, rubia.getCantidadActual(), 0.0001);
	}
}