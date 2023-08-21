package Tienda;

import java.util.Scanner;

public class interraccion {

	public static void main(String[] args) {
	//Tienda m1 = new TiendaMixta("culiaca","centro",66672);
	Scanner scan = new Scanner(System.in);
	int tipoTienda = 0;
	boolean flagTerminar = true;
	do {
		System.out.println("Bienvenido a la gestion de Tiendas");
		System.out.println("Que operacion deseas realizar?");
		System.out.println("1.- Registrar Tienda");
		System.out.println("2.- Terminar");
		int n = scan.nextInt();
		switch(n) {
		case 1:
			tipoTienda = tipoTienda();
			flagTerminar = false;
			break;
		case 2:
			flagTerminar = false;
			break;
		default:
			System.out.println("Favor de seleccionar una opcion");
			break;
		
		}
	}while(flagTerminar);
	if(tipoTienda != 0) {
		
		tienda(tipoTienda);
	}
	
	
	
		

	}
	
	public static void tienda(int tipoTienda) {
		String nombre = "";
		String direccion = "";
		String telefono = "";
		String tipoPago = "";
		Tienda tienda = new TiendaEfectivo("","",0);
		switch(tipoTienda) {
		case 1:
			nombre = getDatos("nombre");
			direccion = getDatos("Direccion");
			telefono = getDatos("telefono");
			tipoPago = "efectivo";
			if(esNumerico(telefono)) {
				tienda = new TiendaEfectivo(nombre,direccion,Integer.parseInt(telefono)); 
			}else {
				return;
			}
			
			break;
		case 2:
			nombre = getDatos("nombre");
			direccion = getDatos("Direccion");
			telefono = getDatos("telefono");
			tipoPago = "tarjeta";
			if(esNumerico(telefono)) {
				tienda = new TiendaTarjeta(nombre,direccion,Integer.parseInt(telefono)); 
			}else {
				return;
			}
			break;
		case 3:
			nombre = getDatos("nombre");
			direccion = getDatos("Direccion");
			telefono = getDatos("telefono");
			tipoPago = "mixto";
			if(esNumerico(telefono)) {
				tienda = new TiendaMixta(nombre,direccion,Integer.parseInt(telefono)); 
			}else {
				return;
			}
			break;
			
		}
		boolean flagTerminar = true;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Bienvenido a la gestion de Tiendas");
			System.out.println("Que operacion deseas realizar?");
			System.out.println("1.- Agregar Producto");
			System.out.println("2.- Realizar Cobro");
			System.out.println("3.- Realizar Pago");
			System.out.println("4.- Ver inventario");
			System.out.println("5.- Terminar");
			int n = scan.nextInt();
			switch(n) {
			case 1:
				String nombreProducto = getDatos("nombre");
				String precio		  = getDatos("precio");
				String cantidad		  = getDatos("cantidad");
				tienda.agregarProducto(nombreProducto,Integer.parseInt(precio),Integer.parseInt(cantidad));
				break;
			case 2:
				String montoSaldo = getDatos("Monto");
				tienda.realizarCobro(Double.parseDouble(montoSaldo));
				break;
			case 3:
				String montoPago = getDatos("Realizar pago");
				
				tienda.realizarPago(Double.parseDouble(montoPago), tipoPago);
				break;
			case 4:
				tienda.verInventario();
				break;
			default:
				System.out.println("Favor de seleccionar una opcion");
				break;
			
			}
		}while(flagTerminar);
		
	}
	
	public static int tipoTienda() {
		Scanner scan = new Scanner(System.in);
		boolean flagTerminar = true;
		do {
			System.out.println("Seleccine tipo de tienda");
			System.out.println("1.- Tienda solo efectivo");
			System.out.println("2.- Tienda solo tarjeta");
			System.out.println("3.- Tienda Mixta");
			int n = scan.nextInt();
			switch(n) {
			case 1:
				return 1;
				
			case 2:
				return 2;
				
			case 3:
				return 3;

			default:
				System.out.println("Favor de seleccionar una opcion");
				break;
			
			}
		}while(flagTerminar);
		return 0;
		
	}
	public static String getDatos(String dato)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Favor de escribir el: "+dato);
		String n = scan.nextLine();
		return n;
	}
	public static boolean esNumerico(String cad) {
		if (cad == null) {
			return false;
		}
		try {
			int numero = Integer.parseInt(cad); 
		}catch (NumberFormatException x) {
			return false;
		}
		return true;
	}

}
