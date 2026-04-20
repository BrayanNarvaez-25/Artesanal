package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestConsumoCliente {
	
	@Test
	public void probarConsumo() {
		Maquina m1 = new Maquina("Pilsener","Rubia",0.002,8000,"C1B2");
		Negocio n1 = new Negocio("Bar de Moe",m1);
		Cliente c1 = new Cliente("Brayan","1727392035");
		
		n1.cargarMaquinaA();
		n1.consumirCervezaMaquinaA(c1, 100);
		
		assertEquals(7700,m1.getCantidadActual());
		assertEquals(0.2,c1.getTotalConsumido(),0.001);
		
		n1.consumirCervezaMaquinaA(c1, 200);
		assertEquals(7500,m1.getCantidadActual());
		assertEquals(0.6,c1.getTotalConsumido(),0.001);
	}
	
}
