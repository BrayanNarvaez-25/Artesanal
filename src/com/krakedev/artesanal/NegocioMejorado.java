package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private int ultimoCodigo = 100;
	
	
	public NegocioMejorado() {}

	public NegocioMejorado(ArrayList<Maquina> maquinas) {
		super();
		this.maquinas = maquinas;
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
	
	public void registrarCliente(String nombre, String cedula) {
		Cliente cliente = new Cliente(nombre,cedula);
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo ++;
		clientes.add(cliente);
	}
	
	public Cliente buscarClientePorCedula(String Cedula) {
		for(int i = 0; i < clientes.size();i++) {
			if(clientes.get(i).getCedula().equals(Cedula)) {
				return clientes.get(i);
			}
		}
		return null;
	}
	
	public Cliente buscarClientePorCodigo(int codigo) {
		for(int i = 0; i < clientes.size();i++) {
			if(clientes.get(i).getCodigo() == codigo) {
				return clientes.get(i);
			}
		}
		return null;
	}
	
	public void consumirCerveza(int codCliente,String codMaquina,double cantidad) {
		Maquina maquina = recuperarMaquina(codMaquina);
		Cliente cliente = buscarClientePorCodigo(codCliente);
		
		if(maquina == null || cliente == null ) {
			return;
		}
		
		double valor = maquina.servirCerveza(cantidad);	
		
		registrarConsumo(codCliente,valor);
	}
	
	public void registrarConsumo(int codigo, double valor) {
		Cliente cliente = buscarClientePorCodigo(codigo);
		cliente.setTotalConsumido(valor + cliente.getTotalConsumido());
		
	}
	
	
}
