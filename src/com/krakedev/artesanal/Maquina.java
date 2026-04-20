package com.krakedev.artesanal;

public class Maquina {

	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMax;
	private double cantidadActual;
	private String codigo;

	public Maquina(String nombreCerveza, String descripcion, double precioPorMl, double capacidadMax, String codigo) {

		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMax = capacidadMax;
		this.cantidadActual = 0;
		this.codigo = codigo;
	}

	public Maquina(String nombreCerveza, String descripcion, double precioPorMl, String codigo) {

		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMax = 10000;
		this.cantidadActual = 0;
		this.codigo = codigo;
	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCapacidadMax() {
		return capacidadMax;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	public String getCodigo() {
		return codigo;
	}

	public void imprimir() {
		String mensaje = "Nombre cerveza: " + nombreCerveza + "\nDescripción: " + descripcion
				+ "\nPrecio por mililitro (ml): " + precioPorMl + "\nCapacidad Máxima: " + capacidadMax
				+ "\nCantidad Actual: " + cantidadActual + "\nCódigo: " + codigo
				+ "\n-----------------------------------";

		System.out.println(mensaje);
	}

	public void llenarMaquina() {
		this.cantidadActual = this.capacidadMax - 100;
	}

	public boolean recargarCerveza(double cantidad) {

		double limitePermitido = capacidadMax - 100;

		if (cantidadActual + cantidad <= limitePermitido) {
			cantidadActual = cantidadActual + cantidad;
			return true;
		} else {
			return false;
		}
	}

	public double servirCerveza(double cantidad) {

		if (cantidadActual >= cantidad) {
			cantidadActual = cantidadActual - cantidad;

			double valor = cantidad * precioPorMl;
			return valor;
		} else {
			return 0;
		}

	}

}
