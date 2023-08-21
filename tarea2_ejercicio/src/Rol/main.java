package Rol;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		System.out.println("Player 1:");
		Personaje player1 = crearPersonaje();
		
		System.out.println("Player 2:");
		Personaje player2 = crearPersonaje();
		
		
		simulacionBatalla(player1, player2);
		
		
		

	}
	
	public static void simulacionBatalla(Personaje player1, Personaje player2) {
		do {
			int p1Moneda = (int) (Math.random() * 6) + 1;
			System.out.println(player1.obtenerNombre()+" tira dado!:"+p1Moneda);
			int p2Moneda = (int) (Math.random() * 6) + 1;
			System.out.println(player2.obtenerNombre()+" tira dado!:"+p2Moneda);
			
			System.out.println("");
			if(p1Moneda == p2Moneda) {
				System.out.println("empate! vuelve a tirar");
			}else {
				if(p1Moneda > p2Moneda) {
					player1.atacar(player2);
				}else {
					player2.atacar(player1);
				}
			}
			System.out.println("");
			System.out.println(player1.obtenerNombre()+" le quedan "+player1.obtenerHp()+" de hp" );
			System.out.println(player2.obtenerNombre()+" le quedan "+player2.obtenerHp()+" de hp" );
			
			
		}while( player1.obtenerHp() > 0 && player2.obtenerHp() > 0);
		
		if(player1.obtenerHp() > player2.obtenerHp()  ) {
			System.out.println(player2.obtenerNombre()+" a caido!");
			System.out.println("Ganador: "+player1.obtenerNombre());
		}else{
			System.out.println(player1.obtenerNombre()+" a caido!");
			System.out.println("Ganador: "+player2.obtenerNombre());
		}
		
	}
	
	public static Personaje crearPersonaje() {
		
		crearPersonaje Pj = new crearPersonaje();
		Scanner scan = new Scanner(System.in);
		int tipoTienda = 0;
		boolean flagTerminar = true;
		do {
			System.out.println("Bienvenido a la creacion de personajes");
			System.out.println("Que clase desea utilizar?");
			System.out.println("1.- Guerrero");
			System.out.println("2.- Mago");
			System.out.println("3.- Arquero");
			int n = scan.nextInt();
			switch(n) {
			case 1:
				return new guerrero(Pj.pedirNombre(), Pj.pedirHp(), Pj.pedirAtributo());
			case 2:
				return new mago(Pj.pedirNombre(), Pj.pedirHp(), Pj.pedirAtributo());
			case 3:
				return new arquero(Pj.pedirNombre(), Pj.pedirHp(), Pj.pedirAtributo());
			default:
				System.out.println("Favor de seleccionar una opcion");
				break;
			
			}
		}while(flagTerminar);
		return new guerrero("asd",1,1);
		
	
	}

}
