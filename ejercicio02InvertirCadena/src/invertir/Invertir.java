package invertir;
import java.util.Scanner;
public class Invertir {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cad;
		StringBuilder aux = new StringBuilder("");
		System.out.println("Introduce una cadena: ");
		cad = sc.nextLine();
		
		for (int i=cad.length()-1; i>=0; i--) {
			aux.append(cad.charAt(i));
		}
		System.out.println(aux.toString());

	}

}
