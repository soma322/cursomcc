package Rol;
import java.util.Scanner;
public class crearPersonaje {
	Scanner scan;
	public crearPersonaje() {
		this.scan = new Scanner(System.in);
	}
	
	protected String pedirDato(String dato) {
		System.out.println("Favor de escribir el "+dato);
		String n = scan.nextLine();
		return n;
	}
	protected String pedirNombre() {
		return pedirDato("nombre");
	}
	protected double pedirHp() {
		return Double.parseDouble(pedirDato("Hp"));
	}
	protected int pedirAtributo() {
		return Integer.parseInt(pedirDato("valor de atributo"));
	}
}
