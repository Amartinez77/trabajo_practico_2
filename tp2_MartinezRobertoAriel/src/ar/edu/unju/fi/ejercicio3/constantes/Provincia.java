package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	
	JUJUY, SALTA, TUCUMAN, CATAMARCA, LA_RIOJA, SANTIAGO_DEL_ESTERO;
	
	int cantidadPoblacion;
	Double superficie;
	
	private Provincia() {
		// TODO Auto-generated constructor stub
	}
	
	private Provincia(int cantidadPoblacion, Double superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}


	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}


	public void setCantidadPoblacion(int cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}


	public Double getSuperficie() {
		return superficie;
	}


	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}
	
	 // Método para calcular la densidad poblacional
    public double densidadPoblacional() {
        return (double) cantidadPoblacion / superficie;
    }
	
	

}
