package ar.edu.unju.fi.ejercicio2.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {
	
	int codigo;
	int dia;
	Mes mes;
	String detalle;
	
	
	public Efemeride() {
		// TODO Auto-generated constructor stub
	}


	public Efemeride(int codigo, int dia, Mes mes, String detalle) {
		super();
		this.codigo = codigo;
		this.dia = dia;
		this.mes = mes;
		this.detalle = detalle;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getDia() {
		return dia;
	}


	public void setDia(int dia) {
		this.dia = dia;
	}


	public Mes getMes() {
		return mes;
	}


	public void setMes(Mes mes) {
		this.mes = mes;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	@Override
	public String toString() {
		return "Efemeride [codigo=" + codigo + ", dia=" + dia + ", mes=" + mes + ", detalle=" + detalle + "]";
	}
	
	

}
