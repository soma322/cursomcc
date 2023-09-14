package juego;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tablero juego = new tablero(3,3);
		
		juego.iniciarTablero(10);
		
		System.out.println(juego.toString());
		
		System.out.println(juego.vecinosVivos(1, 1));
	}

}
