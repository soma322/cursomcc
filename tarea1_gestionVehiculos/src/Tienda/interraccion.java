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
		datosTienda();
		tienda(tipoTienda);
	}
	
	
	
		

	}
	
	public static void tienda(int tipoTienda) {
		
		switch(tipoTienda) {
		case 1:
			//Tienda tienda = new TiendaEfectivo(String); 
			break;
		case 2:
			break;
		case 3:
			break;
			
		}
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

}
