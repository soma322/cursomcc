package juego;
import java.util.Scanner;
public class leer {
    private Scanner scan;

    public leer(){
        this.scan = new Scanner(System.in);
    }

    public int leerReglas(String mensaje){
        String valor = "";
        int res      = 0;
        boolean flagValido = true;
        while(flagValido) {
        	System.out.println(mensaje);
        	valor = scan.nextLine();
        	if(esNumerico(valor)){
        		flagValido = false;
            }else {
            	System.out.println("Favor de introducir solo numeros");
            }
        }
        
        return Integer.parseInt(valor);
        

    }
    
    public int leerReglas(String mensaje,int minimo,int maximo){
        String valor = "";
        int res      = 0;
        boolean flagValido = true;
        while(flagValido) {
        	System.out.println(mensaje);
        	valor = scan.nextLine();
        	if(esNumerico(valor)){
        		res = Integer.parseInt(valor);
        		if (res >= minimo && res <= maximo) {
        			flagValido = false;
        		}else {
        			System.out.println("Favor de escribir en un rango entre "+minimo+" y "+maximo);
        		}
        		
            }else {
            	System.out.println("Favor escribir solo numeros");
            }
        }
        
        return res;
        

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
