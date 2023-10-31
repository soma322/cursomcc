package Buscaminas;

import java.util.Random;

enum Dificultad {
	PRINCIPIANTE,BASICO,MEDIO,AVANZADO;
}

public class Tablero {
	private int filas;
	private int columnas;
	private Celda[][] tablero;
	private int minas;
	private Random random;
	private long tiempoInicio;
	private long tiempoFinal;
	private int nivelDificultad;
	private int celdasVacias;
	
	public Tablero(Dificultad nivel,long tiempoInicio) { // constructor del tablero inicial
		random = new Random();
		int minimo = 0;
		int maximo = 0;
		switch(nivel){
			case PRINCIPIANTE:
				this.nivelDificultad = 1;
				this.filas = 8;
				this.columnas = 8;
				this.minas = (int) (0.10 * tamano());
			break;
			case BASICO:
				this.nivelDificultad = 2;
				this.filas = 15;
				this.columnas = 15;
				minimo = (int) (0.20 * tamano());
            	maximo = (int) (0.25 * tamano());
				this.minas = random.nextInt(maximo - minimo + 1) + minimo;
			break;
			case MEDIO:
				this.nivelDificultad = 3;
				this.filas = 30;
				this.columnas = 30;
				minimo = (int) (0.20 * tamano());
           	 	maximo = (int) (0.25 * tamano());
				this.minas = random.nextInt(maximo - minimo + 1) + minimo;
			break;
			case AVANZADO:
				this.nivelDificultad = 4;
				this.filas = 50;
				this.columnas = 50;
				minimo = (int) (0.25 * tamano());
           	 	maximo = (int) (0.40 * tamano());
				this.minas = random.nextInt(maximo - minimo + 1) + minimo;
			break;
		}
		this.tablero = new Celda[this.filas][this.columnas];
		this.tiempoInicio = tiempoInicio;
		this.tiempoFinal  = 0;
		
		
		// inicializar tablero con objetos Celda
		for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new Celda(false);
            }
        }
		celdasVacias = tamano() - minas;
		agregarMinas(minas);
		
	}

	public int calcularPuntuacion(){
		int puntuaje = 0;
		if(checarResultado()){
			puntuaje = puntuaje + 1000;
		}else{
			return 0;
		}
		switch (this.nivelDificultad) {
			case 1: // PRINCIPIANTE
				puntuaje += 500;
				break;
			case 2: // BÁSICO
				puntuaje += 1000;
				break;
			case 3: // MEDIO
				puntuaje += 1500;
				break;
			case 4: // AVANZADO
				puntuaje += 2000;
				break;
			default:
				break;
		}
		long tiempo = this.tiempoInicio - this.tiempoFinal;
		if (tiempo <= 60) { // menor a 1min
			puntuaje += 200;
		} else if (tiempo <= 120) { // menor a 2 min
			puntuaje += 100;
		} else if (tiempo <= 180) { // menor a 3 min
			puntuaje += 50;
		} else if (tiempo <= 240) { // menor a 4min
			puntuaje += 25;
		}else if(tiempo >240){
			puntuaje += 10;
		}
		puntuaje = puntuaje + random.nextInt(10);
		return puntuaje;

	}
	
	
	

	

	public int tamano() { // regresa el tamaño del tablero
		return (filas * columnas);
	}

	public boolean boom(int fila,int columna){
		boolean response = false;
		if(tablero[fila][columna].esBomba()){
			tablero[fila][columna].setExploto(true);
			response = true;
		}
		return response;
	}
	

	public boolean bloqueoCelda(int fila, int columna){
		return tablero[fila][columna].setBloqueo();
	}
	public boolean desBloqueoCelda(int fila, int columna){
		return tablero[fila][columna].setDesbloqueo();
	}
	public boolean bloqueoMinaCelda(int fila, int columna){
		return tablero[fila][columna].setEsMina();
	}
	public boolean desBloqueoMinaCelda(int fila, int columna){
		return tablero[fila][columna].DesSetEsMina();
	}
	
	public int celdasVacias(){
		return this.celdasVacias;
	}

	public boolean jugar(int fila, int columna, String opcion){
		boolean response = true;
		System.out.println(opcion);
		switch(opcion){
			case "M":
				if(!bloqueoMinaCelda(fila,columna) ){
					System.out.println("Casilla abierta o bloqueada");
					System.out.println("Favor de seleccionar casillas cerradas.");
				}
			break;
			case "B":
				if(!bloqueoCelda(fila,columna) ){
					System.out.println("Casilla abierta o bloqueada");
					System.out.println("Favor de seleccionar casillas cerradas.");
				}
			break;
			case "D":
				boolean check = false;
				if(!desBloqueoCelda(fila,columna) ){
					check = true;
					
				}
				if(!desBloqueoMinaCelda(fila,columna) ){
					check = true;
				}

				if(check){
					System.out.println("Casilla abierta o no bloqueada");
					System.out.println("Favor de seleccionar casillas bloqueada.");
				}

				
			break;
			case "A":
				if(tablero[fila][columna].estaAbierta()){
					System.out.println("Casilla ya se encuentra abierta");
					System.out.println("Favor de seleccionar otra.");
					break;
					
				}
				if(tablero[fila][columna].estaBloqueado()){
					System.out.println("Casilla Bloqueada");
					System.out.println("Favor de seleccionar otra.");
					break;
				}
				if(tablero[fila][columna].esMina()){
					System.out.println("Casilla Bloqueada");
					System.out.println("Favor de seleccionar otra.");
					break;
				}

				if(!tablero[fila][columna].esBomba()){
					abrirCelda(fila,columna);
					if(this.celdasVacias == 0){
						response = false;
					}
					
				}else{
					tablero[fila][columna].setExploto(true);
					response = false;
				}
			break;
			default:
				System.out.println("Favor de seleccionar una opcion valida (B)loquear,(D)esbloquear,(M)ina :");
				System.out.println("Ejemplo: 1,1,M");
			break;

		}

		return response;

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
			if (tablero[fila][columna].estaAbierta() || tablero[fila][columna].estaBloqueado() || tablero[fila][columna].esMina()) {
				return; // La celda ya está abierta o marcada.
			}
		
			tablero[fila][columna].abrir();
			celdasVacias = celdasVacias - 1;
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
			// si entra, significa fuera de index
			
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

	public String toString(boolean flag) { // regresa un string con toda la informacion del tablero
		
		
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
				respuesta += tablero[i][j].toString(flag);

			}
			respuesta += "\n";
		}

		return respuesta;
	}

	public int getFilas(){
		return this.filas;
	}
	public int getColumas(){
		return this.columnas;
	}
	
	public boolean checarResultado(){
		boolean response = false;
		if(this.celdasVacias == 0){
			response = true;
		}
		return response;

	}
	public int getNivelDificultad(){
		return this.nivelDificultad;
	}

	public void abrirTodasCeldas() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if(!tablero[i][j].esBomba()){
					tablero[i][j].abrir();
					this.celdasVacias = this.celdasVacias - 1;
				}
				
			}
		}
	}

	

}
