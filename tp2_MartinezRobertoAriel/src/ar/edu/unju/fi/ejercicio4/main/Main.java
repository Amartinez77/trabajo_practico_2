package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	
	static Scanner scanner;

	public static void main(String[] args) {
		// desarollo
		
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		
		
		scanner = new Scanner(System.in);
		
		int opc=0;
		
		
		
		
		do {
			
			opc = menu();
			
			switch (opc) {
			
			case 1: altaJugador(listaJugadores);  
					break;
					
			case 2: mostrarJugadores(listaJugadores);
					break;
			
			case 3: modificarPosicion(listaJugadores);
					break;
					
			case 4: eliminarJugador(listaJugadores);
			break;
				
				
			case 5: System.out.println("Hasta luego");
					break;
			
			default:
				System.out.println("intente nuevamente");;
			}
			
			
			
			
			
		}while(opc!= 5);
		
		
		

	}
	
	
	/*
	 * menu simple con manejo de errores
	 */
	
	public static int menu() {
		
		System.out.println("**********                 MENU PRINCIPAL              **********");
		System.out.println("");
		System.out.println("*********     1 - Alta de Jugador                      **********");
		System.out.println("*********     2 - Mostrar Todos los Jugadores          **********");
		System.out.println("*********     3 - Modificar la posicion de un jugador  **********");
		System.out.println("*********     4 - Eliminar Jugador                     **********");
		System.out.println("*********     5 - Salir                                **********");
		System.out.println("");
		
		System.out.println("ingrese opcion: ");
		int opc = 0;
		
		try {
			
			opc = scanner.nextInt(); 
			
			
		} catch (Exception e) {
			
			System.out.println("error, ingrese opcion correcta");
			scanner.next();
			
		}
		
		return opc;
		
	}	
		
		
	/*
	 * procedimiento de alta de jugadores
	 * se formatean fechas con formater y luego se guarda en una variable de tipo localDate
	 * se manejan errores de ingrese en fecha, peso, altura
	 * para la posicion primero se muestra la lista del enum y luego se selecciona la opcion
	 */
	
	public static void altaJugador(ArrayList<Jugador> listaJugadores) {
		
		System.out.println("ingrese el nombre:");
		String nombre = scanner.next();
		System.out.println("ingrese el apellido:");
		String apellido = scanner.next();
		
		LocalDate fechaNac = null;
		
		while (fechaNac == null) {
			
			System.out.println("ingrese la fecha de nacimiento en formato dd/mm/aaaa:");
			String fecNac = scanner.next();
			
			try {
				
				//formateo de la fecha dd/mm/aaaa
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				fechaNac = LocalDate.parse(fecNac, formatter);
				
			} catch (DateTimeParseException e) {
				
				System.out.println("Error al ingresar la fecha: debe ingresar la fecha de esta forma dd/mm/aaaa");
				scanner.next();
			}
			
		}		
		
		
		System.out.println("ingrese nacionalidad:");
		String nacionalidad = scanner.next();
		
		
		Double peso = 0.;
		//boolean pesoValido = false;
		
		 while (peso <= 0) {
		        try {
		            System.out.println("Ingrese el peso:");
		            peso = scanner.nextDouble();
		            if (peso <= 0) {
		                System.out.println("Error: El peso debe ser mayor que cero. Inténtelo de nuevo.");
		            }
		        } catch (InputMismatchException e) {
		            System.out.println("Error: Formato de peso incorrecto. Inténtelo de nuevo.");
		            scanner.next(); 
		        }
		    }
		 
		 
		 Float altura = (float) 0;
			//boolean pesoValido = false;
			
			 while (altura <= 0) {
			        try {
			            System.out.println("Ingrese la altura:");
			            altura = scanner.nextFloat();
			            if (altura <= 0) {
			                System.out.println("Error: La altura debe ser mayor que cero. Inténtelo de nuevo.");
			            }
			        } catch (InputMismatchException e) {
			            System.out.println("Error: Formato de peso incorrecto. Inténtelo de nuevo.");
			            scanner.next(); 
			        }
			    }
		
		
		
		
		Jugador jugador = new Jugador();
		
		jugador.setNombre(nombre);
		jugador.setApellido(apellido);
		jugador.setFechaNacimiento(fechaNac);
		jugador.setNacionalidad(nacionalidad);
		jugador.setEstatura(altura);
		jugador.setPeso(peso);
		
		System.out.println("--- Posiciones  ---");
		System.out.println("");
		
		for(Posicion posiciones : Posicion.values()) {
			
			System.out.println(posiciones.ordinal()+1 + " - "+posiciones);
			
		}
		
		int opcPosicion;
		
		System.out.println("elija posicion: ");
		
		opcPosicion = scanner.nextInt();
		
		
		jugador.setPosicion(Posicion.values()[opcPosicion-1]);
		
		listaJugadores.add(jugador);		
		
		
	}
	
	
	/*
	 * procedimiento de muestra simple dentro de un for mejorado	
	 */
	
	public static void mostrarJugadores(ArrayList<Jugador> listaJugadores) {
		
		System.out.println("//////       Lista de Jugadores    //////");
		System.out.println("");
		
		for(Jugador jugadores : listaJugadores){
			
			System.out.println("Nombre: " +jugadores.getNombre());
			System.out.println("Apellido: " +jugadores.getApellido());
			System.out.println("Fecha de Nacimiento: " +jugadores.getFechaNacimiento());
			System.out.println("Nacionalidad:  " +jugadores.getNacionalidad());
			System.out.println("Estatura: " +jugadores.getEstatura());
			System.out.println("Peso: " +jugadores.getPeso());
			System.out.println("");
			System.out.println("POSICION: " +jugadores.getPosicion());
			System.out.println("---------------");
		}
		
		
	}
	
	
	/*
	 * procedimiento que realiza solo la modificacion de la posicion de un jugador
	 * para esto se debe ingresar nombre y apellido 
	 * se utiliza el metodo equalsIgnoreCase para ignorar mayusculas y minusculas en la comparacion
	 * se maneja errores con throw para controlar el rango de ingreso
	 */
	
	public static void modificarPosicion(ArrayList<Jugador> listaJugadores) {
		
        scanner.nextLine(); // Limpia el buffer
        System.out.println("Ingrese el nombre del jugador a modificar:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del jugador a modificar:");
        String apellido = scanner.nextLine();

        boolean encontrado = false;

        for (Jugador jugador : listaJugadores) {
        	
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
            	
                try {
                	
                    System.out.println("Ingrese la nueva posición para el jugador " + nombre + " " + apellido + ":");
                    
                    for (Posicion posicion : Posicion.values()) {
                    	
                        System.out.println((posicion.ordinal() + 1) + " - " + posicion);
                        
                    }
                    
                    int opcPosicion = scanner.nextInt();
                    
                    if (opcPosicion < 1 || opcPosicion > Posicion.values().length) {
                    	
                        throw new InputMismatchException("Opción inválida");
                        
                    }
                    
                    
                    jugador.setPosicion(Posicion.values()[opcPosicion - 1]);
                    encontrado = true;
                    
                    System.out.println("Posición modificada con éxito.");
                    
                    
                } catch (InputMismatchException e) {
                	
                    System.out.println("Error: Debe ingresar un número válido para la posición.");
                    scanner.next(); // Limpiar el buffer de entrada
                    
                }
                
                break;
            }
            
        }
        

        if (!encontrado) {
        	
            System.out.println("No se encontró al jugador con nombre " + nombre + " y apellido " + apellido);
            
        }
    }
	
	
	/*
	 * procedimiento para eliminar un jugador en base al nombre y apellido ingresado
	 * se crea un iterator para recorrer el array
	 * se utiliza el metodo iterator.remove para eliminar el elemento buscado
	 * se maneja el caso en el que sucesa algun error al intentar eliminar
	 */
	
    public static void eliminarJugador(ArrayList<Jugador> listaJugadores) {

        System.out.println("************* Eliminar Jugador   **************");
        System.out.println("");

        System.out.println("Ingrese el nombre");
        String nombre = scanner.next();

        System.out.println("Ingrese el apellido");
        String apellido = scanner.next();

        Iterator<Jugador> iterator = listaJugadores.iterator();

        try {

            while (iterator.hasNext()) {

                Jugador jugador = iterator.next();

                if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {

                    iterator.remove();

                    System.out.println("el jugador ha sido eliminado");

                    return;

                }

            }

            System.out.println("No se encontró ningún jugador con ese nombre y apellido");

        } catch (Exception e) {
            System.out.println("Error al eliminar el jugador.");

        }
   
    }

}
