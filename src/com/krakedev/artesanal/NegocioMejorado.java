package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	private ArrayList<Maquina> maquinas;
	
	public NegocioMejorado() {}

	public NegocioMejorado(ArrayList<Maquina> maquinas) {
		super();
		maquinas = maquinas;
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	public String generarCodigo() {
		int aleatorio = (int)(Math.random()*100)+1;
		return "M-"+aleatorio;
	}
	
	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioMl) {
		String codigo = generarCodigo();
		Maquina maquinaRecuperada = recuperarMaquina(codigo);
		if(maquinaRecuperada == null ) {
			Maquina maquina = new Maquina(nombreCerveza,descripcion,precioMl,codigo);
			maquinas.add(maquina);
			return true;
		}
		return false;
	}
	
	public void cargarMaquinas() {
		for(int i = 0;i < maquinas.size();i++) {
			maquinas.get(i).llenarMaquina();;
		}
	}
	
	public Maquina recuperarMaquina(String codigo) {
		for(int i = 0;i < maquinas.size();i++) {
			if(maquinas.get(i).getCodigo().equals(codigo)) {
				return maquinas.get(i);
			}
		}
		return null;
	} 
	
}
