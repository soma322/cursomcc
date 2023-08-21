package recursividad;

public class suma {

	public static void main(String[] args) {
		int numero = 10;
		
		System.out.println(sumaNumero(numero));

	}
	public static int sumaNumero(int numero) {
		if(numero == 0) {
			return 0;
		}
		return numero + sumaNumero(numero-1);
	}

}
