package recursividad;

public class impares {

	public static void main(String[] args) {
		int numero = 10;
		impares(numero);

	}
	
	public static void impares(int numero) {
		if(numero <= 0) {
			return;
		}
		if(numero %2 != 0) {
			impares(numero-1);
			System.out.println(numero);
		}else {
			impares(numero-1);
		}
		
		
	}

}
