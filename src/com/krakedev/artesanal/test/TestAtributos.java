package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		
		Maquina rubia = new Maquina("Pilsener","Cerveza Rubia",0.02,1000,"COD001");
		rubia.imprimir();
		rubia.setNombreCerveza("Golden All");
		rubia.setDescripcion("Cerveza con aroma más fresco");
		rubia.imprimir();
	}
}