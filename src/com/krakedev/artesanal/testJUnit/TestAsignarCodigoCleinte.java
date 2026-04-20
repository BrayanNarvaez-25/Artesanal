package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsignarCodigoCleinte {
	
	@Test
	public void asignarCodigo() {
		
		Negocio n1 = new Negocio();
		
		Cliente c1 = new Cliente("Mario","1727392035");
		Cliente c2 = new Cliente("Andres","1234567890");
		
		n1.asignarCodigoCliente(c1);
		n1.asignarCodigoCliente(c2);
		
		assertEquals(100, c1.getCodigo());
		assertEquals(101, c2.getCodigo());
	}
}
