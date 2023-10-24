package juego;

import java.util.Random;
import java.util.stream.IntStream;

public class Tablero {
	private int filas;
	private int columnas;
	private Celda[][] tablero;

	public Tablero(int filas, int columnas) { // constructor del tablero inicial
		this.filas = filas;
		this.columnas = columnas;
		this.tablero = new Celda[filas][columnas];
	}

	public Tablero(Tablero original) { // constructor para copiar el tablero iniciar
		this.filas = original.filas;
		this.columnas = original.columnas;
		this.tablero = new Celda[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				this.tablero[i][j] = new Celda(original.tablero[i][j].estaVivo());
			}
		}
	}

	public int tamano() { // regresa el tamaño del tablero
		return (filas * columnas);
	}

	public void iniciarTableroManual(Reglas valores) {
		int tamanoTablero = tamano();

		int totalVivos = valores.totalVivos();

		int contador = 0;
		int coorderanasLenght = valores.getCoordenadas().length;
		String[] lstCoordenadas = valores.getCoordenadas();

		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = new Celda(false);
			}
		}

		for (int i = 0; i < coorderanasLenght; i++) {
			if (lstCoordenadas[i] != null) {
				String[] parts = lstCoordenadas[i].split(",");
				
				tablero[Integer.parseInt(parts[0])]
						[Integer.parseInt(parts[1])] = new Celda(true);
			}

		}

	}

	public void iniciarTableroAutomatico(int porcentajeVivos) {

		Random random = new Random();

		int tamanoTablero = tamano();
		System.out.println(tamanoTablero);
		int totalVivos = Math.round(((float) porcentajeVivos / 100) * tamanoTablero); // calcular el numero de vivos en
																						// el tablero

		int contador = 0;
		System.out.println(totalVivos);

		do {
			for (int i = 0; i < filas; i++) {

				for (int j = 0; j < columnas; j++) {

					if (tablero[i][j] == null) {
						tablero[i][j] = new Celda(false);
					}
					if (random.nextBoolean() && !tablero[i][j].estaVivo() && totalVivos != contador) {
						tablero[i][j] = new Celda(true);
						contador++;
					}

				}
			}
		} while (totalVivos != contador);

	}

	public void setTablero(int fila, int columna, Celda cell) { // funcion de apoyo para generacion
		this.tablero[fila][columna] = cell;
	}

	public Tablero generacion(Reglas valores) { // proceso para crear una nueva generacion
		Tablero nuevaGeneracion = new Tablero(valores.getNumFilas(), valores.getNumColumnas());
		int vecinosVivos = 0;

		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {

				vecinosVivos = vecinosVivos(i, j);
				
				if (tablero[i][j].estaVivo()) {
					// tablero[i][j] = new Celda(true);

					if (vecinosVivos < 2 || vecinosVivos > 3) { // si tiene menos de 2 o mas de 3 vecinos muere
						nuevaGeneracion.setTablero(i, j, new Celda(false));
					} else {
						if (vecinosVivos == 2 || vecinosVivos == 3) { // si tiene 2 o 3 vecinos vive, si no muere
							nuevaGeneracion.setTablero(i, j, new Celda(true));
						} else {
							nuevaGeneracion.setTablero(i, j, new Celda(false));
						}

					}

				} else {
					if (vecinosVivos == 3) { // si esta muerto y tiene 3 vecinos entonces vive
						nuevaGeneracion.setTablero(i, j, new Celda(true));
					} else {
						nuevaGeneracion.setTablero(i, j, new Celda(false));
					}

				}

			}
		}

		return nuevaGeneracion;
	}

	public boolean tablerosIguales(Tablero anterior) { // comparar tablero actual vs tablero anterior

		Celda[][] tableroAnterior = anterior.getTablero();
		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {

				if (tablero[i][j].estaVivo() != tableroAnterior[i][j].estaVivo()) {
					return false;
				}

			}

		}

		return true;
	}

	public Celda[][] getTablero() { // regresa tablero del obj
		return this.tablero;
	}

	public int totalVecinosVivos() { // Regresa total vecinos vivos en un tablero
		int contador = 0;
		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {
				if (tablero[i][j].estaVivo()) {
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
						if (tablero[i][j].estaVivo()) {
							contador++;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						
					}
					/* 
					if (i >= 0 && i < tablero.length && j >= 0 && j < tablero[0].length && tablero[i][j].estaVivo()) { 
						contador++;
					}*/
				}
			}
		}

		return contador;
	}
	
	public int vecinosVivosNoFor(int fila, int columna) { //Regresa el total de vecinos sin fors, lo saque de chatgpt XD
		return (int) IntStream.rangeClosed(fila - 1, fila + 1)
				.mapToObj(row -> IntStream.rangeClosed(columna - 1, columna + 1)
						.filter(col -> row != fila || col != columna)
						.filter(col -> row >= 0 && row < tablero.length && col >= 0 && col < tablero[0].length)
						.filter(col -> tablero[row][col].estaVivo()))
				.flatMap(IntStream::boxed)
				.count();
	}

	public String toString() { // regresa un string con toda la informacion del tablero
		int contadorOrganismos = 1;
		String StringOrganismos = "Organismos vivos en Celdas: \n";
		int totalOrganismos = 0;

		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {
				if (tablero[i][j].estaVivo()) {
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
