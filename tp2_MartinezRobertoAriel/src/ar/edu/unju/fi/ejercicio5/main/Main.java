package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;


import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;



public class Main {
	
	static Scanner scanner;
	static List<Producto> listaProductos;
	static List<Producto> listaVentas;

	public static void main(String[] args) {
		// desarrollo
		
		scanner = new Scanner(System.in);
		
		listaProductos = new ArrayList<>();
		listaVentas = new ArrayList<>();
		
		cargaProductos();
		

		int opc=0;
		
		
		
		
		do {
			
			opc = menu();
			
			switch (opc) {
			
			case 1: mostrarProductos(listaProductos);  
					break;
					
			case 2: realizarCompra(listaProductos);
					break;
				
				
			case 3: System.out.println("Hasta luego");
					break;
			
			default:
				System.out.println("intente nuevamente");;
			}
			
			
			
			
			
		}while(opc!= 3);
		
		
		

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
		
		System.out.println("*********   MENU PRINCIPAL           **********");
		System.out.println("");
		System.out.println("*********   1 - Mostrar Productos       **********");
		System.out.println("*********   2 - Realizar Compra    **********");
		System.out.println("*********   3 - Salir                **********");
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
	 * procedimiento que muestra los productos disponibles
	 * se utiliza una funcion lambda
	 */
	
	public static void mostrarProductos(List<Producto> listaProductos) {
	    if (listaProductos.isEmpty()) {
	        System.out.println(" ** La lista está vacía, debe ingresar productos");
	        System.out.println("");
	    } else {
	        System.out.println("**********      listado de productos   *************");
	        System.out.println("");
	        listaProductos.forEach(producto -> {
	            System.out.println("Codigo: " + producto.getCodigo());
	            System.out.println("Descripcion: " + producto.getDescripcion());
	            System.out.println("Categoria: " + producto.getCategoria().name());
	            System.out.println("Origen: " + producto.getOrigen().name());
	            System.out.println("Precio $ " + producto.getPrecioUnitario());
	            System.out.println("Disponible ? >>>> " + producto.isDisponible());
	            System.out.println("----------------------------------------");
	            System.out.println("");
	        });
	    }
	}
	
	
	/*
	 * procedimiento que realiza la compra
	 * utiliza un Consumer para mostrar la lista de productos, para agregar al carrito
	 * luego de elegir el producto este se agrega a otro arrayList de ventas y se pregunta al usuario si desea seguir agregando productos al carrito
	 * para esto se envuelven los ingresos en try catch para capturar posibles errores en los ingresos.
	 * mediante ciclos do-while se mantiene el flujo del programa
	 * finalmente se recorre el nuevo array para realizar la sumatoria de precios y llamar al metodo de la clase Producto que finaliza la compra
	 * lugo se solicita al usuario ingresar la foma de pago y de esta forma se llama a las funciones de pago con tarjeta o efectivo
	 * 
	 */
	
	public static void realizarCompra(List<Producto> listaProductos) {		
		
		int prod = 0;
		
		int resp = 0;		
		
		
		System.out.println("*********************************************");
		System.out.println("                  Compra");
		
		Consumer<Producto> printConsumer = p -> System.out.println(listaProductos.indexOf(p)+1 +" - "+p);
		
		
		
		boolean continua = true;
		
		do {			
			
			listaProductos.forEach(printConsumer);
			
			System.out.println("seleccione producto");
			
			try {
				
				prod = scanner.nextInt();
				Producto produ = listaProductos.get(prod-1);
			
				listaVentas.add(produ);
				
				do {
					
					System.out.println("desea seguir agregando productos? 1 - SI // 2 - NO");
			
					resp = scanner.nextInt();
				
					if(resp != 1 && resp != 2) {
						throw new InputMismatchException("Opción inválida");
					}else {
						if (resp==1) {
							break;
						}else {
							continua = false;
						}
					}
					
					
				} while (continua);
			
				
				
				
				
			} catch (InputMismatchException e) {
				
				System.out.println("debe ingresar un valor numerico");
				scanner.next();
				
			} catch (IndexOutOfBoundsException ex) {
				
				System.out.println("debe ingresar un valor válido [1-15]");
				
			}
						
			
			
			if(resp == 2) {
				
				continua = false;
				
			}
			
		} while (continua);
		
		
		double monto = 0.;
		
		System.out.println("Producto agregado correctamente");
		
			
		for(Producto prod1 : listaVentas) {
		    monto += prod1.getPrecioUnitario();
		}

		System.out.println("");
		System.out.println("El subtotal es >>>>>>>>>>>>>>>>>>> " + monto);
		System.out.println("");
		
		
		do {
			
			continua = true;
			
			try {
			
				System.out.println("**********   Finalizar Compra    **********");
				System.out.println("");
				System.out.println("1- Pago en efectivo");
				System.out.println("2- Pago con tarjeta");
				System.out.println("");
				System.out.println("como desa pagar ? elija opcion");
				resp = scanner.nextInt();
				
				
				if(resp < 1 || resp > 2) {
					throw new IndexOutOfBoundsException();
				}
				
				continua = false;
				
			} catch (InputMismatchException e) {
			
				System.out.println("ingrese un valor numerico");
				
			
			}catch (IndexOutOfBoundsException ex) {
			
				System.out.println("opcion fuera de rango [1-2]");
				
			}
			
		} while (continua);
		
		
		
		
		
		
		if(resp==1) {
			pagoE(monto);
		}else {
			pagoT(monto);
		}
		
		
		System.out.println("gracias por su compra");
		System.out.println("");
		
		
	}
	
	
	
	/*
	 * procedimiento que recibe el monto total (sumatoria de precios del array de venta)
	 * se instancia la clase y se llama a los metodos que implementan la interfaz Pago (metodo abstracto) 
	 * finalmente muestran un detalle de la compra realizada
	 */
	
	public static void pagoT(double monto) {
		
		System.out.println("");
		System.out.println("  ***  pago realizado correctamente!");
		System.out.println("");
		System.out.println("detalle: ");
		System.out.println();
		
		PagoTarjeta pagoTarjeta = new PagoTarjeta();
		pagoTarjeta.realizarPago(monto);
		pagoTarjeta.setFechaPago(LocalDate.now());
		pagoTarjeta.setNumeroTarjeta("51515151511155");
		pagoTarjeta.imprimirRecibo();		
		
	}
	
	
	/*
	 * procedimiento que recibe el monto total (sumatoria de precios del array de venta)
	 * se instancia la clase y se llama a los metodos que implementan la interfaz Pago (metodo abstracto) 
	 * finalmente muestran un detalle de la compra realizada	 	
	 */
	
	public static void pagoE(double monto) {
		
		System.out.println("");
		System.out.println("  ***  pago realizado correctamente!");
		System.out.println("");
		System.out.println("detalle: ");
		System.out.println();
		
		PagoEfectivo pagoEftv = new PagoEfectivo();
		pagoEftv.realizarPago(monto);
		pagoEftv.setFechaPago(LocalDate.now());						
		pagoEftv.imprimirRecibo();
		
	}
	

}
