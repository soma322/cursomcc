package juego;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

	

}
