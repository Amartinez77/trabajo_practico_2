package ar.edu.unju.fi.ejercicio2.main;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	
	static Scanner scanner;

	public static void main(String[] args) {
		// desarrollo
		
		ArrayList<Efemeride> listaEfemerides = new ArrayList<>();
		
		
		scanner = new Scanner(System.in);
		
		int opc=0;
		
		
		
		
		do {
			
			opc = menu();
			
			switch (opc) {
			
			case 1: crearEfemeride(listaEfemerides);  
					break;
					
			case 2: mostrarEfemerides(listaEfemerides);
					break;
			
			case 3: eliminarEfemeride(listaEfemerides);
					break;
					
			case 4: modificarEfemeride(listaEfemerides);
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
		
		System.out.println("*********   MENU PRINCIPAL           **********");
		System.out.println("*********   1 - Crear Efeméride       **********");
		System.out.println("*********   2 - Mostrar efemérides    **********");
		System.out.println("*********   3 - Eliminar efeméride    **********");
		System.out.println("*********   4 - Modificar efeméride   **********");
		System.out.println("*********   5 - Salir                **********");
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
	 procedimiento de creacion de efemeride
	 verifica que el usuario ingrese un valor válido de mes (1-12) y ademas mediante el uso de una funcion verifica
	 que el dia del mes sea válido
	 */
	
	public static void crearEfemeride(ArrayList<Efemeride> listaEfemerides) {
		
		System.out.println("********  Crear Efemeride   ********");
		
		Efemeride efemeride = new Efemeride();
		
		
		int mes = 0;
		int dia = 0;
		boolean band = true;
		
		do {
			
			
			System.out.println("Ingrese un nro correspondiente al mes (1-12): ");
			
			band = false;
			
			try {
				
				mes = scanner.nextInt();
				
				if (mes < 1 || mes > 12) {
					
					throw new InputMismatchException();
					
				}
				
				
			} catch (InputMismatchException e) {
				
				System.out.println("Debe ingresar un valor numérico válido (1-12)");
				System.out.println("Ingrese nuevamente");
				System.out.println("");
				scanner.nextLine();
			}
			
			
			
		}while(band);
		
		
		
		efemeride.setMes(Mes.values()[mes-1]);
		
		band = true;
		
		do {
			
			System.out.println("ingrese el dia: ");
			
			try {
				
				dia = scanner.nextInt();
				
				int diasMes = obtenerDiasDelMes(mes);
				
				if (dia < 1 || dia > diasMes) {
					
					throw new Exception();
					
				}
				
				band = false;
				
			} catch (InputMismatchException e) {
				
				System.out.println("debe ingresar un numero entero correspondiente a un dia >>");
				System.out.println("intente nuevamente");
				System.out.println("");
				scanner.next();
				
			}catch (Exception ex) {
				
				System.out.println("debe ingresar un dia válido para el mes ingresado >>" + efemeride.getMes());
				System.out.println("intente nuevamente");
				System.out.println("");
				scanner.next();
				
			} 
			
			
			
		} while (band);
		
		
		efemeride.setDia(dia);
		
		band = true;
		
		do {
			
			try {
				
				System.out.println("Ingrese un codigo de efemeride: ");
				int codigo = scanner.nextInt();
				band = false;
				efemeride.setCodigo(codigo);
				
			} catch (InputMismatchException e) {
				
				System.out.println("debe ingresar un valor numerico");
				System.out.println("vuelva a intentarlo");
				System.out.println("");
				scanner.next();
				
			}
			
		} while (band);
		
		
		
		System.out.println("Ingrese una descripcion de la efeméride");
		String descripcion = scanner.next();
		
		
		
		efemeride.setDetalle(descripcion);
		
		
		listaEfemerides.add(efemeride);
		
	}
	
	
	
	/*
	 * funcion que recibe un nro de mes (1-12) y devuelve la cantidad de dias que tiene ese mes ingresado
	 * se utiliza el metodo Month.of de java.time
	 * isLeapYeay determina si el año es bisiesto es un metodo de localDate
	 */	
	
	public static int obtenerDiasDelMes(int mes) {
        return Month.of(mes).length(LocalDate.now().isLeapYear());
    }
	
	
	/*
	 * procedimiento simple de muestra - recibe un arrayList
	 * utiliza un for mejorado 
	 */
	
	public static void mostrarEfemerides(ArrayList<Efemeride> listaEfemerides) {
		
		
		System.out.println("*****    muestra de efemerides  *****");
		System.out.println("");
		
		
		for(Efemeride efemerides : listaEfemerides) {
			
			System.out.println("Codigo: " +efemerides.getCodigo());
			System.out.println("mes: " +efemerides.getMes());
			System.out.println("dia: " +efemerides.getDia());
			System.out.println("detalle: " + efemerides.getDetalle());
			System.err.println("");
			System.out.println("--------------------------------------");
			
		}
		
		
	}
	
	
	/*
	 * procedimiento que elimina una efemeride
	 * verifica si el codigo ingresado es numerico
	 * luego se recorre el Arraylist y mediante el for comun se obtiene el indice de cada objeto
	 * de esa forma mediante el metodo get se verifica que sea igual al valor ingresado
	 * si es encontrado con el metodo remove() se elimina el objeto de la lista
	 * 
	 */
	
    public static void eliminarEfemeride(ArrayList<Efemeride> listaEfemerides) {
    	
    	System.out.println("***********  Eliminar efemerides  *******************");
    	System.out.println("");

        System.out.println("Ingrese el código de la efeméride a eliminar: ");
        
        int nro = 0;
        
        int codigoEliminar;
        
        do {
        	
        	try {
        		
				codigoEliminar = scanner.nextInt();
				nro = 0;
			} catch (InputMismatchException e) {
				
				System.out.println("debe ngresar un valor numerico");
				scanner.next();
				return;
				
				
			}
			
		} while (nro != 0);
        
        

        boolean encontrado = false;

        for (int i = 0; i < listaEfemerides.size(); i++) {
        	
            if (listaEfemerides.get(i).getCodigo() == codigoEliminar) {
            	
                listaEfemerides.remove(i);
                encontrado = true;
                System.out.println("Efeméride eliminada exitosamente.");
                break;
                
            }
            
        }

        if (!encontrado) {
        	
            System.out.println("No se encontró ninguna efeméride con el código ingresado.");
            System.out.println("vuelva a ingresar");
            System.out.println("");
            
        }
        
    }
    
    
    /*
     * procedimiento de modificacion, realiza la busqueda a traves del codigo, el cual se maneja el caso
     * de que se ingrese un valor no numerico. Mediante un for mejorado se recorre la lista buscando la coincidencia 
     * del codigo ingresado con los codigos de los objetos en la lista.
     * luego se modifica todo menos el codigo, para la modificacion se utiliza la funcion obtenerDiaMes() que se uso para el alta
     * 
     */
    
    public static void modificarEfemeride(ArrayList<Efemeride> listaEfemerides) {
    	
    	int nro = 0;
    	int codigoModificar = 0;
    	
    	do {
    		
    		try {
    		
    			System.out.println("Ingrese el código de la efeméride a modificar: ");
    			codigoModificar = scanner.nextInt();
    			nro = 0;
			 
    		} catch (InputMismatchException e) {
			
    			System.out.println("ingrese un valor numerico");
    			scanner.next();
    			return;
    		}
			
		} while (nro!=0);
    	
    	
    	

       

        boolean encontrado = false;

        for (Efemeride efemeride : listaEfemerides) {
        	
            if (efemeride.getCodigo() == codigoModificar) {
            	
                System.out.println("Ingrese la nueva descripción: ");
                
                String nuevaDescripcion = scanner.next();
                
                efemeride.setDetalle(nuevaDescripcion);
                
                
                int mes = 0;
        		int dia = 0;
        		boolean band = true;
        		
        		do {
        			
        			
        			System.out.println("Ingrese un nro correspondiente al mes (1-12): ");
        			
        			band = false;
        			
        			try {
        				
        				mes = scanner.nextInt();
        				
        				if (mes < 1 || mes > 12) {
        					
        					throw new InputMismatchException();
        					
        				}
        				
        				
        			} catch (InputMismatchException e) {
        				
        				System.out.println("Debe ingresar un valor numérico válido (1-12)");
        				System.out.println("Ingrese nuevamente");
        				System.out.println("");
        				scanner.nextLine();
        			}
        			
        			
        			
        		}while(band);
        		
        		
        		
        		efemeride.setMes(Mes.values()[mes-1]);
        		
        		
        		band = true;
        		
        		do {
        			
        			System.out.println("ingrese el dia: ");
        			
        			try {
        				
        				dia = scanner.nextInt();
        				
        				int diasMes = obtenerDiasDelMes(mes);
        				
        				if (dia < 1 || dia > diasMes) {
        					
        					throw new Exception();
        					
        				}
        				
        				band = false;
        				
        			} catch (InputMismatchException e) {
        				
        				System.out.println("debe ingresar un numero entero correspondiente a un dia >>");
        				System.out.println("intente nuevamente");
        				System.out.println("");
        				scanner.next();
        				
        			}catch (Exception ex) {
        				
        				System.out.println("debe ingresar un dia válido para el mes ingresado >>" + efemeride.getMes());
        				System.out.println("intente nuevamente");
        				System.out.println("");
        				scanner.next();
        				
        			} 
        			
        			
        			
        		} while (band);
        		
        		
        		efemeride.setDia(dia);
                
                
                
                
                System.out.println("Efeméride modificada exitosamente.");
                
                encontrado = true;
                
                break;
                
            }
            
        }

        if (!encontrado) {
            System.out.println("No se encontró ninguna efeméride con el código ingresado.");
        }
    }

	

}
	
	


