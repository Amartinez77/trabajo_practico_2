package ar.edu.unju.fi.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.model.Producto;

public class Main {
	
	static Scanner scanner;

	public static void main(String[] args) {
		// desarrollo
		
		scanner = new Scanner(System.in);
				
		ArrayList<Producto> listaProductos = new ArrayList<>();
		
		
		
		int opc=0;
		
		
		
		
		do {
			
			menu(opc);
			
			switch (opc) {
			
			case 1: crearProducto(listaProductos);  
					break;
				
				
			case 4: System.out.println("Hasta luego");
					break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + opc);
			}
			
			
			
			
			
		}while(opc!= 4);
		
		
		

	}
	
	
	public static void menu(int opc) {
		
		System.out.println("*********   MENU PRINCIPAL           **********");
		System.out.println("*********   1 - Crear Producto       **********");
		System.out.println("*********   2 - Mostrar Productos    **********");
		System.out.println("*********   3 - Modificar Producto   **********");
		System.out.println("*********   4 - Salir                **********");
		System.out.println("");
		
		System.out.println(opc);		
		
	}
	
	
	public static void crearProducto(ArrayList<Producto> listaProductos) {
		
		Producto producto = new Producto();
		
		System.out.println("-------  Origen de Fabricacion  --------");
		
		for(Producto.OrigenFabricacion origen : Producto.OrigenFabricacion.values()) {}
		
		
	}

}
