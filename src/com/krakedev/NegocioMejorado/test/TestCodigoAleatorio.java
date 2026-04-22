package com.krakedev.NegocioMejorado.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestCodigoAleatorio {
	@Test
	public void testGenerarCodigo() {
		NegocioMejorado n = new NegocioMejorado();

		String codigo = n.generarCodigo();

		assertNotNull(codigo);
		assertTrue(codigo.startsWith("M-"));

		int numero = Integer.parseInt(codigo.split("-")[1]);
		assertTrue(numero >= 1 && numero <= 100);
		
		System.out.println(codigo);
	}
}
