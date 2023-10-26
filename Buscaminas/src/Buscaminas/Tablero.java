package Buscaminas;

import java.util.Random;

enum Dificultad {
	PRINCIPIANTE,BASICO,MEDIO,AVANZADO;
};

public class Tablero {
	private int filas;
	private int columnas;
	private Celda[][] tablero;
	private int minas;
	private Random random;
	private long tiempoInicio;
	
	public Tablero(Dificultad nivel,long tiempoInicio) { // constructor del tablero inicial
		escogerNivel(nivel);
		this.tablero = new Celda[filas][columnas];
		this.tiempoInicio = tiempoInicio;
		random = new Random();
		
		iniciarTablero();
		
	}

	
	private void escogerNivel(Dificultad nivel){
		
		switch(nivel){
			case PRINCIPIANTE:
				this.filas = 8;
				this.columnas = 8;
				this.minas = Math.round(((float) 10 / 100) * tamano());
			break;
			case BASICO:
				this.filas = 15;
				this.columnas = 15;
				this.minas = Math.round(((float) (random.nextInt(6) + 15) / 100) * tamano());
			break;
			case MEDIO:
				this.filas = 30;
				this.columnas = 30;
				this.minas = Math.round(((float) (random.nextInt(6) + 20) / 100) * tamano());
			break;
			case AVANZADO:
				this.filas = 50;
				this.columnas = 50;
				this.minas = Math.round(((float) (random.nextInt(21) + 25) / 100) * tamano());
			break;
		}

	}

	

	public int tamano() { // regresa el tamaño del tablero
		return (filas * columnas);
	}

	

	public void iniciarTablero() {

		// inicializar tablero con objetos Celda
		for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new Celda(false);
            }
        }
		
		agregarMinas(minas);
	}

	public void agregarMinas(int minas){
		if(minas == 0){
			return;
		}
		int filaRandom = random.nextInt(this.filas);
		int columnaRandom = random.nextInt(this.columnas);
		
		if(!tablero[filaRandom][columnaRandom].esBomba()){
			tablero[filaRandom][columnaRandom] = new Celda(true);
			agregarMinas(minas - 1);
		}else{
			agregarMinas(minas);
		}
	}

	public void abrirCelda(int fila, int columna) {
		try {
			if (tablero[fila][columna].estaAbierta()) {
				return; // La celda ya está abierta o marcada.
			}
		
			tablero[fila][columna].abrir();
		
			if (!tablero[fila][columna].esBomba()) {
				int bombasVecinas = contarBombasVecinas(fila, columna);
				tablero[fila][columna].setNumeroBombas(bombasVecinas);
		
				if (bombasVecinas == 0) {
					// Si no hay bombas vecinas, abrir celdas vecinas.
					for (int i = fila - 1; i <= fila + 1; i++) {
						for (int j = columna - 1; j <= columna + 1; j++) {
							try {
								if (i != fila || j != columna) { // Evitar la celda actual.
									abrirCelda(i, j);
								}
							} catch (Exception e) {
								// fuera de index
							}
						}
					}
				}
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
	
		
	}
	
	public int contarBombasVecinas(int fila, int columna) {
		int bombasVecinas = 0;
	
		for (int i = fila - 1; i <= fila + 1; i++) {
			for (int j = columna - 1; j <= columna + 1; j++) {
				try {
					if ((i != fila || j != columna) && tablero[i][j].esBomba()) {
						bombasVecinas++;
					}
				} catch (Exception e) {
					// fuera de index
				}
				
			}
		}
	
		return bombasVecinas;
	}




	public Celda[][] getTablero() { // regresa tablero del obj
		return this.tablero;
	}
	
	
	public String toString() { // regresa un string con toda la informacion del tablero
		
		
		String respuesta = "";
		respuesta += "\n";

		respuesta += "[ ]";
		for (int i = 0; i < filas; i++) {
			respuesta += " [" + i + "]";
		}
		respuesta += "\n";
		for (int i = 0; i < filas; i++) {
			respuesta += "[" + i + "] ";
			for (int j = 0; j < columnas; j++) {
				respuesta += tablero[i][j].toString();

			}
			respuesta += "\n";
		}

		return respuesta;
	}

	public void imprimir() { // imprime el tablero
		System.out.print("[ ]");
		for (int i = 0; i < filas; i++) {
			System.out.print("[" + i + "]");
		}
		System.out.println();

		for (int i = 0; i < filas; i++) {
			System.out.print("[" + i + "]");
			for (int j = 0; j < columnas; j++) {

				System.out.print(tablero[i][j].toString());

			}
			System.out.println("");
		}
	}

}
