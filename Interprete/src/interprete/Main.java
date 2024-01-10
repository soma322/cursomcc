package interprete; // Rename the package to match the regular expression '^[a-z_]+(\.[a-z_][a-z0-9_]*)*$'

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear un objeto de la clase Commandos
        Commandos commandos = new Commandos("src\\interprete\\CommandsTxt\\Commandos.txt");
        List<String> programa = new ArrayList<>();
        Interprete interpreter = new Interprete();
        
        try {
            BufferedReader txt = commandos.leerCommandos();
            String linea;

            while ((linea = txt.readLine()) != null) {
          
               programa.add(linea);
            
               
            }
        } catch (Exception e) {
        }
        interpreter.ejecutarPrograma(programa);
     
    }
}
    

