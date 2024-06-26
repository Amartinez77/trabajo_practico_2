package ar.edu.unju.fi.ejercicio6.main;

import java.io.ObjectInputStream.GetField;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		// Desarrollo
		
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		
		//definición de expresión lambda que define el convertidor de FelinoDomestico a 
		//FelinoSalvaje.
		
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
		
		//se realiza la conversión
		
		FelinoSalvaje felino1 = converter.convert(gato);
		
		//mostramos los datos del objeto felino salvaje felino1
		
		converter.mostrarObjeto(felino1);
		
		FelinoSalvaje gatoSalvaje = new FelinoSalvaje("Tanner", (byte) 20, 186f);
		
		Converter<FelinoSalvaje, FelinoDomestico> converter2 = y -> new FelinoDomestico(y.getNombre(), y.getEdad(), y.getPeso());
		
		
		// verificamos que el objeto no sea nulo
		
		if (Converter.isNotNull(gatoSalvaje)) {
            FelinoDomestico felino2 = converter2.convert(gatoSalvaje);
            converter2.mostrarObjeto(felino2);
        } else {
            System.out.println("El objeto a convertir es nulo");
        }
		

	}

}
