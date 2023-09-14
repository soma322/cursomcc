package juego;
import java.util.Scanner;
public class leer {
    private Scanner scan;

    public leer(){
        this.scan = new Scanner(System.in);
    }

    public int leerInt(){
        String valor = scan.nextLine();
        int res      = 0;
        if(esNumerico(valor)){
            
            return Integer.parseInt(valor);
        }
        return -1;

    }


    private static boolean esNumerico(String cad) {
		if (cad == null) {
			return false;
		}
		try {
			int numero = Integer.parseInt(cad); 
		}catch (NumberFormatException x) {
			return false;
		}
		return true;
	}
    
}
