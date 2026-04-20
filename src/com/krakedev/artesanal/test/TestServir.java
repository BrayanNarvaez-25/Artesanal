package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maquina rubia = new Maquina("Pilsener", "Cerveza fría", 0.02, 8000);
		
		System.out.println("--------ESTADO INICIAL--------");
		rubia.imprimir();
		
		System.out.println("--------LLENANDO MÁQUINA--------");
		rubia.llenarMaquina();
		rubia.imprimir();
		
		System.out.println("--------SERVIR 1000 ML--------");
		double valor = rubia.servirCerveza(1000);;
		System.out.println("Valor a pagar: "+valor);
		
		System.out.println("--------SERVIR 2000 ML--------");
		valor = rubia.servirCerveza(2000);;
		System.out.println("Valor a pagar: "+valor);
		
		rubia.imprimir();
		
		System.out.println("--------SERVIR 6000 ML--------");
		valor = rubia.servirCerveza(6000);;
		System.out.println("Valor a pagar: "+valor);
	}

}
