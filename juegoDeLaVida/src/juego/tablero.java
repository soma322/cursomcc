package juego;
import java.util.Random;
import java.lang.Math;
public class tablero {
	private int filas;
	private int columnas;
	private celda[][] tablero;
	
	public tablero(int filas,int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.tablero = new celda[filas][columnas];
	}
	public int tamano() {
		return (filas*columnas);
	}
	
	public void iniciarTablero(int porcentajeVivos) {
		
		Random random = new Random();
		
		int tamanoTablero = tamano();
		System.out.println(tamanoTablero);
		int totalVivos = Math.round(((float)porcentajeVivos / 100) * tamanoTablero); //calcular el numero de vivos en el tablero
		
		int contador = 0;
		System.out.println(totalVivos);
		
		
		
		do {
			for (int i = 0; i < filas; i++) {
				
	            for (int j = 0; j < columnas; j++) {
	            	
	            	if (tablero[i][j] == null) {
	                      tablero[i][j] = new celda(false); // Initialize to a dead cell if not already initialized
	                }
	            	if(random.nextBoolean() && !tablero[i][j].estaVivo() && totalVivos != contador ) {
	            		tablero[i][j] = new celda(true);
	            		contador++;
	            	}
	            	
	            	
	                  
	            }
	        }
		}while(totalVivos != contador);
		
		
	}
	
	public void imprimir() {
		System.out.print("[ ]");
		for(int i = 0; i < filas; i++) {
			System.out.print("["+i+"]");
		}
		System.out.println();
		
		for (int i = 0; i < filas; i++) {
			System.out.print("["+i+"]");
            for (int j = 0; j < columnas; j++) {   	
            	
            		System.out.print(tablero[i][j].toString());

            }
            System.out.println("");
		}
	}
	
}

