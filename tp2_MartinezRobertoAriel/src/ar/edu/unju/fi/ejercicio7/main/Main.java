package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class Main {
	
	static Scanner scanner;
	static List<Producto> listaProductos;
	static List<Producto> productosIncrementados;

	public static void main(String[] args) {
		// desarrollo

scanner = new Scanner(System.in);
		
		listaProductos = new ArrayList<>();
		
		cargaProductos();
		

		int opc=0;
		
		
		
		
		do {
			
			opc = menu();
			
			switch (opc) {
			
			case 1: mostrarProductos(listaProductos);  
					break;
					
			case 2: mostrarProductosFaltantes(listaProductos);
					break;
					
			case 3: incrementarPrecio(listaProductos, productosIncrementados);
					break;
					
			case 4: mostrarElectrohogar(listaProductos);
					break;
			
			case 5: ordenarPorPrecioDescendente(listaProductos);
					break;
					
			case 6: mostrarEnMayusc(listaProductos);
					break;
				
				
			case 7: System.out.println("Hasta luego");
					break;
			
			default:
				System.out.println("intente nuevamente");;
			}			
			
			
		}while(opc!= 7);
		
		
		

	}
	
	/*
	 * procedimiento que precarga unos productos al arrayList de productos
	 */
	
	public static void cargaProductos() {
		if (listaProductos.isEmpty()) {
			
			listaProductos.add(new Producto(1000, "Notebook HP", 850000d, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
			listaProductos.add(new Producto(1010, "Monitor LG24", 120000d, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
			listaProductos.add(new Producto(2101, "Heladera Gafa 540l", 980000d, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
			listaProductos.add(new Producto(2105, "Cocina Orbis", 430000d, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, false));
			listaProductos.add(new Producto(2110, "Microondas Lg 27", 89000d, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
			listaProductos.add(new Producto(3001, "Taladro black and decker", 72000d, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, false));
			listaProductos.add(new Producto(3007, "Sierra Caladora B&D", 55000d, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, true));
			listaProductos.add(new Producto(4000, "Telefono inalambrico Panasonic", 73000d, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
			listaProductos.add(new Producto(4110, "Telefono Samsung A54 5g", 390000d, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
			listaProductos.add(new Producto(4115, "Telefono Motorola N8", 270000d, OrigenFabricacion.CHINA, Categoria.TELEFONIA, false));
			listaProductos.add(new Producto(2241, "Lavarropas Coventry 6,5 kg inverter", 490000d, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
			listaProductos.add(new Producto(3365, "Atornillador electrico Einhell Brushless", 99000d, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, true));
			listaProductos.add(new Producto(1718, "Teclado Redragon kit", 55000d, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false));
			listaProductos.add(new Producto(1888, "Pendrive Noga 128gb", 22000d, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
			listaProductos.add(new Producto(4461, "Telefono OPPO A58 5G", 850000d, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true));
			
		}else {
			System.out.println("Lista Cargada");
		}
		
		
	}
	
	/*
	 * funcion que muestra el menu y maneja errores
	 * retorna la opcion ingresada para usarla en el switch
	 */
	
	public static int menu() {
		
		System.out.println("");
		
		System.out.println("*********   MENU PRINCIPAL           **********");
		System.out.println("");
		System.out.println("*********   1 – Mostrar productos (solo se muestran los productos con estado true)       **********");
		System.out.println("*********   2 – Mostrar los productos faltantes (muestra productos con estado false)    **********");
		System.out.println("*********   3 -  Incrementar los precios de los productos en un 20%                **********");
		System.out.println("*********   4 – Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta");
		System.out.println("*********   5- Ordenar los productos por precio de forma descendente");
		System.out.println("*********   6- Mostrar los productos con los nombres en mayúsculas");
		System.out.println("*********   7 - salir");
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
	 * se utilizo Consumer
	 */
	public static void mostrarProductos(List<Producto> listaProductos) {
		
		Consumer<Producto> printConsumer = c -> {
			if(c.isDisponible()) {
				System.out.println(c);
			}
		};
		
		listaProductos.forEach(printConsumer);
		
	}
	
	
	/*
	 * se utilizo Predicate y consumer
	 */
	public static void mostrarProductosFaltantes(List<Producto> listaProductos) {
		
		Predicate<Producto> prodfaltantesPredicate = c -> !c.isDisponible();
		
		Consumer<Producto> printConsumer = c -> System.out.println(c);
		
		listaProductos.stream().filter(prodfaltantesPredicate).forEach(printConsumer);
		
	}
	
	
	
	/*
	 * se utilizo Function y map()
	 */
	public static void incrementarPrecio(List<Producto> listaProductos, List<Producto> productosIncrementados) {
		
		Function<Producto, Producto> funcionIncrementar = c ->{
			
			c.setPrecioUnitario(c.getPrecioUnitario()*1.20);
			return c;
		};
		
		
		productosIncrementados = new ArrayList<>();
		
		productosIncrementados = listaProductos.stream().map(funcionIncrementar).collect(Collectors.toList());
		productosIncrementados.forEach(System.out::println);
		
	}
	
	
	/*
	 * Se utilizo  Predicate y filter()
	 */
	public static void mostrarElectrohogar(List<Producto> listaProductos) {
		
		Predicate<Producto> electrohogarPredicate = c -> c.getCategoria() == Categoria.ELECTROHOGAR;
		
		Consumer<Producto> printConsumer = c -> System.out.println(c);
		
		listaProductos.stream().filter(electrohogarPredicate).forEach(printConsumer);
		
	}
	
	/*
	 * se utilizo sort() de la interface List y Comparator.comparing()
	 */
	
	public static void ordenarPorPrecioDescendente(List<Producto> listaProductos) {
		
		Comparator c = Comparator.comparing(Producto::getPrecioUnitario).reversed();
		
		listaProductos.sort(c);
		
		listaProductos.forEach(System.out::println);
		
	}
	
	/*
	 * Se utilizo funtion y map
	 */
	public static void mostrarEnMayusc(List<Producto> listaProductos) {
		
		Function<Producto, Producto> funcionConvertirMayuscula = c ->{
			
			String nombreMayuscula = c.getDescripcion().toUpperCase();
			c.setDescripcion(nombreMayuscula);
			return c;
		};
		
				
		List<Producto> productosMayuscula = listaProductos.stream()
											.map(funcionConvertirMayuscula)
											.collect(Collectors.toList());
		
		System.out.println("** Productos con nombres en mayusculas");
		productosMayuscula.forEach(System.out::println);
		
		
	}

}
