package juego;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "😀";
		System.out.println( s ) ;
		tablero juego = new tablero(3,3);
		leer scan = new leer();
		boolean flagTerminar = true;
		
		do {
			System.out.println("Bienvenido al juego de vida");
			System.out.println("Seleccione un modo:");
			System.out.println("1.- Manual");
			System.out.println("2.- Automatico");
			System.out.println("3.- Salir");
			int n = scan.leerInt();
			switch(n) {
			case 1:
				reglas reglas = escribirReglas();
			System.out.println(	reglas.toString());
				break;
			case 2:
				juego.iniciarTableroAutomatico(30);
		int totalVivos = Math.round(((float)3 / 100) * juego.tamano()); //calcular el numero de vivos en el tablero
		System.out.println(juego.toString());
		
		System.out.println(juego.vecinosVivos(1, 1));
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
	

	

}
