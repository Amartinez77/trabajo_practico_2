package ar.edu.unju.fi.ejercicio3.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {
	
	static Scanner scanner;

	public static void main(String[] args) {
		// desarrollo
		
		scanner = new Scanner(System.in);

       
        Provincia[] provincias = Provincia.values();

       
        for (Provincia provincia : provincias) {
        	
            System.out.println("Ingrese la cantidad de población para " + provincia + ":");
            int poblacion = ingresarNumero();
            provincia.setCantidadPoblacion(poblacion);

            System.out.println("Ingrese la superficie en km² para " + provincia + ":");
            double superficie = ingresarNumeroDouble();
            provincia.setSuperficie(superficie);
            System.out.println("----------------------------------");
            
        }

        
        for (Provincia provincia : provincias) {
        	
            System.out.println("Provincia: " + provincia);
            System.out.println("Cantidad de población: " + provincia.getCantidadPoblacion());
            System.out.println("Superficie: " + provincia.getSuperficie() + " km²");
            System.out.println("Densidad poblacional: " + provincia.densidadPoblacional() + " hab/km²");
            System.out.println("----------------------------------");
            
        }

        scanner.close();
    }
	
	

    /*
     *  Método para ingresar números enteros con manejo de excepciones
     */
	
    public static int ingresarNumero() {
        int numero = 0;
        boolean band = true;
        
        
        do {
        	
            try {
            	
                numero = scanner.nextInt();
                band = false;
                
            } catch (InputMismatchException e) {
            	
                System.out.println("Debe ingresar un valor numérico. Intente nuevamente.");
                scanner.next();
                
            }
            
        } while (band);
        
        
        return numero;
    }
    
    

    /*
     * Método para ingresar números decimales con manejo de excepciones
     */
    
    public static double ingresarNumeroDouble() {
        double numero = 0;
        boolean band = true;
        
        
        do {
        	
            try {
            	
                numero = scanner.nextDouble();
                band = false;
                
            } catch (InputMismatchException e) {
            	
                System.out.println("Debe ingresar un valor numérico. Intente nuevamente.");
                scanner.next();
                
            }
            
        } while (band);
        
        
        return numero;
		 
	}
		

	

}
