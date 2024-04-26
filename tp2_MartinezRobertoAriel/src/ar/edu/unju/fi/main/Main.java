package ar.edu.unju.fi.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
			
			opc = menu();
			
			switch (opc) {
			
			case 1: crearProducto(listaProductos);  
					break;
					
			case 2: mostrarProductos(listaProductos);
					break;
			
			case 3: modificar(listaProductos);
					break;
				
				
			case 4: System.out.println("Hasta luego");
					break;
			
			default:
				System.out.println("intente nuevamente");;
			}
			
			
			
			
			
		}while(opc!= 4);
		
		
		

	}
	
	/*
	 * funcion que muestra el menu y maneja errores
	 * retorna la opcion ingresada para usarla en el switch
	 */
	
	public static int menu() {
		
		System.out.println("*********   MENU PRINCIPAL           **********");
		System.out.println("*********   1 - Crear Producto       **********");
		System.out.println("*********   2 - Mostrar Productos    **********");
		System.out.println("*********   3 - Modificar Producto   **********");
		System.out.println("*********   4 - Salir                **********");
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
	 * funcion que recibe la lista de productos, para crear y agregar productos
	 * se manejan excepciones de tipo de dato y del ingreso fuera de rango
	 */
	
	public static void crearProducto(ArrayList<Producto> listaProductos) {
		
		Producto producto = new Producto();
		
		System.out.println("-------  Origen de Fabricacion  --------");
		System.out.println("");
		
		int opcOrigen = 0;
		int opcCategoria = 0;
		boolean band = true;
		
		do {
			
			try {
				
				//band = false;
			
				for(Producto.OrigenFabricacion origen : Producto.OrigenFabricacion.values()) {
					System.out.println(origen.ordinal()+1 +" - "+origen);
				}
		
				System.out.println("");
				System.out.print("elija la opcion del origen: ");
		
				opcOrigen= scanner.nextInt();	
				
				if(opcOrigen < 1 || opcOrigen > Producto.OrigenFabricacion.values().length) {
					
					throw new InputMismatchException("opcion fuera de rango");
					
				}
				
				System.out.println("");
		
				for(Producto.Categoria categoria : Producto.Categoria.values()) {
					System.out.println(categoria.ordinal()+1 +" - "+categoria);
				}
		
				System.out.print("seleccione la categoria: ");
				opcCategoria = scanner.nextInt();
				
				if (opcCategoria < 1 || opcCategoria > Producto.Categoria.values().length) {
		            throw new InputMismatchException("Opción fuera de rango.");
		        }
				
				System.out.println("");
				
				band = false;
			
			} catch (InputMismatchException e) {
			
				System.out.println("Debe ingresar un nro / intente nuevamente");
				scanner.next();			
			
			} catch (Exception e) {
				
				System.out.println("Error: " + e.getMessage());
				scanner.next();
				
			}
			
		
			
		} while (band);
		
		band = true;
		
		do {
	
			
			try {
				
				System.out.println("ingrese el codigo");
				int codigo = scanner.nextInt();
				producto.setCodigo(codigo);
		
				System.out.println("ingrese descripcion: ");
				String descripcion = scanner.next();
				producto.setDescripcion(descripcion);
		
				System.out.println("ingrese el precio: ");
				double precio = scanner.nextDouble();
				producto.setPrecioUnitario(precio);
				
				band = false;
				
			} catch (InputMismatchException e) {
				
				System.out.println("tiene que ingresar una opcion valida / intente nuevamente");
				scanner.next();
				
			} catch (Exception e) {
				
				System.out.println("error: "+ e.getMessage());
				
			}
			
		} while (band);
		
		
		
		
		if(opcOrigen >= 1 && opcOrigen <= Producto.OrigenFabricacion.values().length) {
			producto.setOrigen(Producto.OrigenFabricacion.values()[opcOrigen-1]);
		}else {
			System.out.println("opcion invalida");
		}
		
		
		if(opcCategoria >= 1 && opcCategoria <= Producto.Categoria.values().length) {
			producto.setCategoria(Producto.Categoria.values()[opcCategoria-1]);
		}else {
			System.out.println("opcion invalida");
		}
		
		
		
		
		
		listaProductos.add(producto);
		
		System.out.println("producto agregado");
		
		
	}
	
	
	/*
	 * funcion que recibe una lista de productos y realiza la muestra, para ello se utiliza un for mejorado
	 * verifica que la lista no esté vacia
	 */
	
	public static void mostrarProductos(ArrayList<Producto> listaProductos) {
		
		if (listaProductos.isEmpty()) {
			
			System.out.println(" ** La lista está vacia, debe ingresar productos");
			System.out.println("");
			
		}else {
			
			System.out.println("**********      listado de productos   *************");
			System.out.println("");
		
			for(Producto producto : listaProductos) {
			
				System.out.println("Codigo: " + producto.getCodigo() );
				System.out.println("Descripcion: " + producto.getDescripcion() );
				System.out.println("Categoria: " + producto.getCategoria().name() );
				System.out.println("Origen: " + producto.getOrigen().name() );
				System.out.println("Precio $ " + producto.getPrecioUnitario() );
				System.out.println("----------------------------------------");
				System.out.println("");
			
			}
		
		}
		
		
		
	}
	

	/*
	 * funciona para modificar productos, recibe la lista de productos
	 * maneja la excepcion del ingreso erroneo del codigo de producto, esto no permitiria continuar
	 * con la modificacion
	 * el codigo es el unico atributo que no se puede modificar
	 */
	
	public static void modificar(ArrayList<Producto> listaProductos) {
	    int codigo = 0;
	    
	    System.out.println("************  Modificar Productos  **************");
	    System.out.println("");
	    
	    System.out.println("Ingrese el código del producto a modificar: ");
	    
	    boolean codigoValido = false;
	    while (!codigoValido) {
	        try {
	        	
	            codigo = scanner.nextInt();
	            codigoValido = true;
	            
	        } catch (InputMismatchException e) {
	        	
	            System.out.println("Debe ingresar un código válido");
	            scanner.next(); 
	            
	        }
	    }
	    
	    for (int i = 0; i < listaProductos.size(); i++) {
	        Producto producto = listaProductos.get(i);
	        
	        if (producto.getCodigo() == codigo) {
	            System.out.println("**  Producto encontrado  **");
	            System.out.println("");
	            
	            System.out.println("-------  Origen de Fabricacion  --------");
	            for (Producto.OrigenFabricacion origen : Producto.OrigenFabricacion.values()) {
	                System.out.println(origen.ordinal()+1 +" - "+origen);
	            }
	            
	            int opcOrigen;
	            System.out.println("Seleccione una opción para el origen: ");
	            opcOrigen = scanner.nextInt();
	            
	            System.out.println("");
	            
	            System.out.println("-------  Categoría  --------");
	            for (Producto.Categoria categoria : Producto.Categoria.values()) {
	                System.out.println(categoria.ordinal()+1 +" - "+categoria);
	            }
	            
	            int opcCategoria;
	            System.out.println("Seleccione una opción para la categoría: ");
	            opcCategoria = scanner.nextInt();
	            
	            System.out.println("");
	            
	            String descripcion;
	            System.out.println("Ingrese la nueva descripción: ");
	            descripcion = scanner.next();
	            
	            double precio;
	            System.out.println("Ingrese el nuevo precio: ");
	            precio = scanner.nextDouble();
	            
	            if (opcOrigen >= 1 && opcOrigen <= Producto.OrigenFabricacion.values().length) {
	                producto.setOrigen(Producto.OrigenFabricacion.values()[opcOrigen - 1]);
	            } else {
	                System.out.println("Opción de origen inválida");
	            }
	            
	            if (opcCategoria >= 1 && opcCategoria <= Producto.Categoria.values().length) {
	                producto.setCategoria(Producto.Categoria.values()[opcCategoria - 1]);
	            } else {
	                System.out.println("Opción de categoría inválida");
	            }
	            
	            producto.setDescripcion(descripcion);
	            producto.setPrecioUnitario(precio);
	            
	            System.out.println("Producto modificado");
	            return;
	        }
	    }
	    
	    System.out.println("No se encontró producto");
	    System.out.println("");
	}

}
