package juego;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "😀";
		System.out.println( s ) ;
		
		leer scan = new leer();
		boolean flagTerminar = true;
		
		do {
			System.out.println("Bienvenido al juego de vida");
			System.out.println("Seleccione un modo:");
			System.out.println("1.- Manual");
			System.out.println("2.- Automatico");
			System.out.println("3.- Salir");
			int n = scan.leerInt();
			reglas reglas = escribirReglas();
			switch(n) {
			case 1:
				
				tablero juegoManual = new tablero(reglas.getNumFilas(),reglas.getNumColumnas());
				reglas = capturarCoordinadas(reglas);
				juegoManual.iniciarTableroManual(reglas);

				System.out.println(juegoManual.toString());

				break;
			case 2:
				
			
				tablero juegoAuto = new tablero(reglas.getNumFilas(),reglas.getNumColumnas());
				juegoAuto.iniciarTableroAutomatico(reglas.getOrganismosIniciales());
				int totalVivos = Math.round(((float)3 / 100) * juegoAuto.tamano()); //calcular el numero de vivos en el tablero
				System.out.println(juegoAuto.toString());
				
				System.out.println(juegoAuto.vecinosVivos(1, 1));
				break;
			case 3:
				System.out.println("Vuelva pronto!");
				flagTerminar = false;
				break;
			default:
				System.out.println("Favor de seleccionar una opcion");
				break;
			}
		}while(flagTerminar);


		
	}
	
	public static reglas escribirReglas() {
		leer datos = new leer();
		int numColumnas 	= datos.leerReglas("Favor de escribir el numero de columnas entre 2 y 20",2,20);
		int numFilas 		= datos.leerReglas("Favor de escribir el numero de filas entre 2 y 20",2,20);
		int numGeneraciones = datos.leerReglas("Favor de escribir el numero de generaciones entre 1 y 50",1,50);
		int numOrganismos 	= datos.leerReglas("Favor de escribir el numero de organismos entre 0% y 50%",0,50);
		
		reglas valorReglas = new reglas(numFilas,numColumnas,numGeneraciones,numOrganismos);
		
		return valorReglas;
		
	}

	public static reglas capturarCoordinadas(reglas valores){
		leer datos = new leer();
		int tamano = valores.getNumFilas() * valores.getNumColumnas();
		int tableroTotalVivos = valores.totalVivos();
		int contadorOrganismos = 0;
		int idOrganismo = 1;

		do{
			String coordenada = datos.leerCoordenas("Favor de escribir la posición fila y columna de organismo "+idOrganismo+" en un rango filas entre 0 y "+(valores.getNumFilas()-1)+ " o un rango columna entre 0 y "+(valores.getNumColumnas()-1)+ "Ejemplo: 00,01,02,etc",(valores.getNumFilas()-1),(valores.getNumColumnas()-1));
			if(!checarCoordenada(valores,coordenada)){
				valores.agregarCoordenadas(contadorOrganismos, coordenada);
				contadorOrganismos++;
			}else{
				System.out.println("Coordenada repetida, favor de escribir una distinta");
			}

		}while(tableroTotalVivos > contadorOrganismos );



		return valores;
	}

	public static boolean checarCoordenada(reglas valores, String coordenada){
		
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
