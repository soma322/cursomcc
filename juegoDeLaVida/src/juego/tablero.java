package juego;
import java.util.Random;
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

	public void iniciarTableroManual(reglas valores){
		int tamanoTablero = tamano();
		System.out.println(tamanoTablero);
		
		int totalVivos = valores.totalVivos();
		
		int contador = 0;
		int coorderanasLenght = valores.getCoordenadas().length;
		String[] lstCoordenadas = valores.getCoordenadas();
		// iniciar table con celdas false
		for (int i = 0; i < filas; i++) {
				
			for (int j = 0; j < columnas; j++) {
						tablero[i][j] = new celda(false);
			}
	    }

		for(int i= 0; i<coorderanasLenght;i++){
			if(lstCoordenadas[i] != null){
				tablero[Integer.parseInt(String.valueOf(lstCoordenadas[i].charAt(0)))]
					[Integer.parseInt(String.valueOf(lstCoordenadas[i].charAt(1)))] = new celda(true);
			}
			
		}

	}
	
	
	public void iniciarTableroAutomatico(int porcentajeVivos) {
		
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
	                      tablero[i][j] = new celda(false); 
	                }
	            	if(random.nextBoolean() && !tablero[i][j].estaVivo() && totalVivos != contador ) {
	            		tablero[i][j] = new celda(true);
	            		contador++;
	            	}
	            	
	            	
	                  
	            }
	        }
		}while(totalVivos != contador);
		
		
	}

	public tablero generacion(){
		tablero juego = new tablero(filas,columnas);

		for (int i = 0; i < filas; i++) {
				
	            for (int j = 0; j < columnas; j++) {
	            	
	            	if (tablero[i][j] == null) {
	                      tablero[i][j] = new celda(false); 
	                }
	            	if(!tablero[i][j].estaVivo()) {
	            		tablero[i][j] = new celda(true);
						vecinosVivos(i,j);
	            		
	            	}else{
						
					}
	            	
	            	
	                  
	            }
			}


		return juego;
	}
	public int vecinosVivos(int fila, int columna) {
		
		int contador = 0;
		//System.out.println( tablero[0].length);
		for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
            	
                if (i != fila || j != columna) { // Excluir la celda que se esta revisando
                    if (i >= 0 && i < tablero.length && j >= 0 && j < tablero[0].length && tablero[i][j].estaVivo()) { // checa que esta dentro del tablero y si el vecino esta vivo
                    	
                    	
                    	contador++;
                    }
                }
            }
        }
		
		return contador;
	}
	
	public String toString() {
		String respuesta = "[ ]";
		for(int i = 0; i < filas; i++) {
			respuesta +="["+i+"] ";
		}
		respuesta += "\n";
		for (int i = 0; i < filas; i++) {
			respuesta +="["+i+"]";
            for (int j = 0; j < columnas; j++) {
            	respuesta +=tablero[i][j].toString();
            		

            }
            respuesta += "\n";
		}
		
		return respuesta;
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

