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

     public String leerCoordenas(String mensaje,int filas,int columnas){
        String valor = "";
        int var1     = 0;
        int var2     = 0;
        boolean flagValido = true;
        while(flagValido) {
        	System.out.println(mensaje);
        	valor = scan.nextLine();
            if(valor.length() > 2 || valor.length() < 0){
                System.out.println("Valor invalido");
            }

        	if(esNumerico(String.valueOf(valor.charAt(0))) && esNumerico(String.valueOf(valor.charAt(1)))){
        		var1 = Integer.parseInt(String.valueOf(valor.charAt(0)));
                var2 = Integer.parseInt(String.valueOf(valor.charAt(1)));
        		if (var1 >-1 && var2 >-1 && var1 <= filas && var2 <= columnas) {
        			flagValido = false;
        		}else {
        			System.out.println("Valor invalido");
        		}
        		
            }else {
            	System.out.println("Favor escribir solo numeros");
            }
        }
        
        return valor;
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
