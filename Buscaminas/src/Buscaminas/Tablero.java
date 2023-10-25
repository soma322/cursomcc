package Buscaminas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Dificultad {
	PRINCIPIANTE,BASICO,MEDIO,AVANZADO;
};

public class Tablero {
	private int filas;
	private int columnas;
	private Celda[][] tablero;
	private ArrayList<Celda> CeldasAlrededor;
	private int minas;
	private int minasActivas;
	private Random random;
	public Tablero(Dificultad nivel) { // constructor del tablero inicial
		escogerNivel(nivel);
		this.minasActivas = 0;
		this.tablero = new Celda[filas][columnas];
		random = new Random();
		iniciarTablero();
		this.CeldasAlrededor = new ArrayList<Celda>();
		
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


	public int seleccionarCelda(int fila, int columna) {
			try {
				if(tablero[fila][columna].esBomba()){ // Verificar si la celda actual es una bomba.
					//perdio

				}
				if (tablero[fila][columna].getNumeroBombasAlrededor() == 0) {
					tablero[fila][columna].abrir();
				}
				int bombasVecinas = 0;
				// Recorrer las celdas vecinas y contar bombas.9
				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) {
						if (i != 0 || j != 0) { // Evitar la celda actual.
							bombasVecinas += seleccionarCelda(fila + i, columna + j);
						}
					}
				}
			} catch (Exception e) {
				// La excepción solo se captura si se desbordan los límites al explorar celdas vecinas.
				
			}
		
			return 0;
		

		
	}

	private void actualizarNumeroMinasAlrededor(){

		for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (i != 0 || j != 0) { // Evitar la celda actual.
						bombasVecinas += seleccionarCelda(fila + i, columna + j);
					}
				}
			}
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].isMina()){
                    List<Casilla> casillasAlrededor=obtenerCasillasAlrededor(i, j);
                    casillasAlrededor.forEach((c)->c.incrementarNumeroMinasAlrededor());
                }
            }
        }
    }




	public Celda[][] getTablero() { // regresa tablero del obj
		return this.tablero;
	}

	public int totalVecinosVivos() { // Regresa total vecinos vivos en un tablero
		int contador = 0;
		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {
				if (tablero[i][j].esBomba()) {
					contador++;
				}

			}

		}
		return contador;
	}

	public int vecinosVivos(int fila, int columna) { // Regresa el total de vecinos vivos alrededor de una Celda

		int contador = 0;
		// System.out.println( tablero[0].length);
		for (int i = fila - 1; i <= fila + 1; i++) {
			for (int j = columna - 1; j <= columna + 1; j++) {

				if (i != fila || j != columna) { // Excluir la Celda que se esta revisando
					try {
						if (tablero[i][j].esBomba()) {
							contador++;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						
					}
					/* 
					if (i >= 0 && i < tablero.length && j >= 0 && j < tablero[0].length && tablero[i][j].esBomba()) { 
						contador++;
					}*/
				}
			}
		}

		return contador;
	}
	
	public String toString() { // regresa un string con toda la informacion del tablero
		int contadorOrganismos = 1;
		String StringOrganismos = "Organismos vivos en Celdas: \n";
		int totalOrganismos = 0;

		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {
				if (tablero[i][j].esBomba()) {
					StringOrganismos += "n" + contadorOrganismos + "=(" + i + "," + j + ") ";
					contadorOrganismos++;
				}

			}

		}
		totalOrganismos = contadorOrganismos - 1;
		String respuesta = "Filas: " + filas + " Columnas: " + columnas + " Organismos=" + totalOrganismos + "\n";
		respuesta += StringOrganismos;
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
