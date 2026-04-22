package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	private ArrayList<Maquina> Maquinas;
	
	public NegocioMejorado() {}

	public NegocioMejorado(ArrayList<Maquina> maquinas) {
		super();
		Maquinas = maquinas;
	}

	public ArrayList<Maquina> getMaquinas() {
		return Maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		Maquinas = maquinas;
	}
	
	public String generarCodigo() {
		int aleatorio = (int)(Math.random()*100)+1;
		return "M-"+aleatorio;
	}
	
}
