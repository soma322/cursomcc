package Buscaminas;
import java.util.Scanner;
public class Leer {
    private Scanner scan;

    public Leer(){
        this.scan = new Scanner(System.in);
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
                if(parts.length == 3){
                    

                    if(esNumerico(parts[0]) && esNumerico(parts[1]) && soloLetras(parts[2])){
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
    

    private static boolean soloLetras(String str) {
        // Use regular expression to check if the string contains only letters
        return str.matches("^[a-zA-Z]*$");
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
