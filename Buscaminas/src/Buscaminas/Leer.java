package Buscaminas;
import java.util.Scanner;
public class Leer {
    private Scanner scan;

    public Leer(){
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
        int commaCount = 0;
        
        while(flagValido) {
        	System.out.println(mensaje);
        	valor = scan.nextLine();

            for (int i = 0; i < valor.length(); i++) {
                if (valor.charAt(i) == ',') {
                    commaCount++;
                }
            }
            if (commaCount == 1 ){
                String[] parts = valor.split(",");
                if(parts.length == 2){
                    

                    if(esNumerico(parts[0]) && esNumerico(parts[1])){
                    var1 = Integer.parseInt(parts[0]);
                    var2 = Integer.parseInt(parts[1]);
                    if (var1 >=0 && var2 >=0 && var1 <= filas && var2 <= columnas) {
                        flagValido = false;
                    }
                    
                    }else {
                        System.out.println("Favor escribir solo numeros");
                    }
                }
                
            }
            if(flagValido){
                System.out.println("Valor invalido");
            }
            commaCount = 0;
        	
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
