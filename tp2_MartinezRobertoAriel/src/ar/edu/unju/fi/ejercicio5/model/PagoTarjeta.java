package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	
	private String numeroTarjeta;
    private LocalDate fechaPago;
    private double montoPagado;
    
    
    public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}
	
	

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}



	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}



	public LocalDate getFechaPago() {
		return fechaPago;
	}



	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}



	public double getMontoPagado() {
		return montoPagado;
	}



	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}



	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		
		montoPagado = monto * 1.15;		

	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub		
		
		System.out.println("Numero de tarjeta: "+numeroTarjeta );
		System.out.println("Fecha de pago:  "+fechaPago );
		System.out.println("Monto pagado: $ "+montoPagado );
		System.out.println("");

	}

}
