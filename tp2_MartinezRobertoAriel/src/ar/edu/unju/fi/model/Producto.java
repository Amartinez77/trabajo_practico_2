package ar.edu.unju.fi.model;

public class Producto {
	
	int codigo;
	String descripcion;
	Double precioUnitario;
	
	enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}
	
	

}
