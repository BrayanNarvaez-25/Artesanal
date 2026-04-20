package com.krakedev.test.negocio;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestNegocio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maquina mI = new Maquina ("Club","Cerveza Fría",0.02,8000,"C1B2");
		Negocio n1 = new Negocio("Mi negocio",mI);
		
		System.out.println("Nombre: "+n1.getNombre());
		System.out.println("Máquina: "+n1.getMaquinaA());
		
		Maquina m1 = n1.getMaquinaA();
		double capacidad = m1.getCapacidadMax();
	}

}
