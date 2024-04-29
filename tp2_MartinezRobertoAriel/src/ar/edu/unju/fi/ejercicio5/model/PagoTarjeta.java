package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	
	private String numeroTarjeta;
    private LocalDate fechaPago;
    private double montoPagado;


	@Override
	public void realizarPago(Double monto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub

	}

}
