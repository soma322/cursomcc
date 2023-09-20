package juego;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// dejarar variables
		Leer scan = new Leer();
		boolean flagTerminar = true;
		Reglas reglas;
		Tablero juego;
		do {
			System.out.println("Bienvenido al juego de vida 😀😀😀");
			System.out.println("Seleccione un modo:");
			System.out.println("1.- Manual");
			System.out.println("2.- Automatico");
			
			int n = scan.leerInt();
			reglas = escribirReglas(); // Leer reglas del teclado
			juego = new Tablero(reglas.getNumFilas(),reglas.getNumColumnas()); // inicializar tablero sin coordenadas
			switch(n) {
			case 1:
				reglas = capturarCoordinadas(reglas); // capturar coordenadas manualmente
				juego.iniciarTableroManual(reglas); // inciar tablero con coordenadas introducidas
				flagTerminar = false;
				break;
			case 2:
				juego.iniciarTableroAutomatico(reglas.getOrganismosIniciales()); // generar coordenadas aleatorias  con % de organismos vivos introducidos desde el teclados
				flagTerminar = false;
				break;
			default:
				System.out.println("Favor de seleccionar una opcion");
				break;
			}
		}while(flagTerminar);


		jugarJuegoDeLaVida(reglas,juego ); // iniciar juego de la vida


		
	}
	
	public static void jugarJuegoDeLaVida(Reglas reglas, Tablero juego){
		int generacion = reglas.getNumGeneraciones();
		int contadorGeneraciones = 0;
		int contadorRepetidos = 0;
		boolean flagGeneracion = true;
		Scanner scanner = new Scanner(System.in);

       

		Tablero juegoAnterior = new Tablero(juego);
		Tablero juegoActual = new Tablero(juego);
		System.out.println("Generacion: "+(contadorGeneraciones+1));
		System.out.println("Inicia el juego");
		System.out.println(juegoActual.toString());
		System.out.println("Presiona Enter para continuar...");
		scanner.nextLine();
		while(flagGeneracion ){
				
			juegoActual = juegoActual.generacion(reglas);
			if(juegoActual.totalVecinosVivos() == 0){ // Caso todos los organismos murieron
				contadorRepetidos++;
				System.out.println("Generacion: "+(contadorGeneraciones+1));
				System.out.println("Juego terminado! Todos los organismos murieron");
				System.out.println( juegoActual.toString());
				flagGeneracion = false;
				return;
			}
			if(juegoActual.tablerosIguales(juegoAnterior)){ // caso 2 generaciones son iguales
				
				contadorRepetidos++;
				System.out.println("Generacion: "+(contadorGeneraciones+1));
				if(contadorRepetidos == 2){
					System.out.println(juegoActual.toString());
					System.out.println("Juego terminado! 2 Generaciones iguales");
					flagGeneracion = false;
					return;
				}else{
					contadorGeneraciones++;
					System.out.println("Generacion: "+(contadorGeneraciones+1));
					System.out.println(juegoActual.toString());
				 	System.out.println("Presiona Enter para continuar...");
      				scanner.nextLine();
					juegoAnterior = new Tablero(juegoActual);
				}
				
			}else{
				contadorRepetidos = 0;
				contadorGeneraciones++;
				if(generacion < contadorGeneraciones ){ // caso numero de generaciones a llegado a sus limites
					System.out.println("Juego terminado! Se llego al maximo de generaciones");
					flagGeneracion = false;
					return;
				}
				System.out.println("Generacion: "+(contadorGeneraciones+1));
				System.out.println(juegoActual.toString());
				 System.out.println("Presiona Enter para continuar...");
      			  scanner.nextLine();
				juegoAnterior = new Tablero(juegoActual);
			}
			

		}

	}

	
	public static Reglas escribirReglas() {
		
		Leer datos = new Leer();
		int numColumnas 	= datos.leerReglas("Favor de escribir el numero de columnas entre 2 y 20",2,20);
		int numFilas 		= datos.leerReglas("Favor de escribir el numero de filas entre 2 y 20",2,20);
		int numGeneraciones = datos.leerReglas("Favor de escribir el numero de generaciones entre 1 y 50",1,50);
		int numOrganismos 	= datos.leerReglas("Favor de escribir el numero de organismos entre 0% y 50%",0,50);
		
		Reglas valorReglas = new Reglas(numFilas,numColumnas,numGeneraciones,numOrganismos);
		
		return valorReglas;
		
	}

	public static Reglas capturarCoordinadas(Reglas valores){
		Leer datos = new Leer();
		int tamano = valores.getNumFilas() * valores.getNumColumnas();
		int tableroTotalVivos = valores.totalVivos();
		int contadorOrganismos = 0;
		int idOrganismo = 1;

		do{
			String coordenada = datos.leerCoordenas("Favor de escribir la posición fila y columna de organismo "+idOrganismo+" en un rango filas entre 0 y "+(valores.getNumFilas()-1)+ " o un rango columna entre 0 y "+(valores.getNumColumnas()-1)+ " Ejemplo: 0,0|0,1|0,2| etc",(valores.getNumFilas()-1),(valores.getNumColumnas()-1));
			if(!checarCoordenada(valores,coordenada)){
				valores.agregarCoordenadas(contadorOrganismos, coordenada);
				contadorOrganismos++;
			}else{
				System.out.println("Coordenada repetida, favor de escribir una distinta");
			}

		}while(tableroTotalVivos > contadorOrganismos );



		return valores;
	}

	public static boolean checarCoordenada(Reglas valores, String coordenada){
		
		int coorderanasLenght = valores.getCoordenadas().length;
		String[] lstCoordenadas = valores.getCoordenadas();
		for(int i= 0; i<coorderanasLenght;i++){
			if(coordenada.equals(lstCoordenadas[i])){
				return true;
			}
		}
		return false;
	}
	

	

}
