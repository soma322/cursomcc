package interprete; // Rename the package to match the regular expression '^[a-z_]+(\.[a-z_][a-z0-9_]*)*$'

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear un objeto de la clase Commandos
        Commandos commandos = new Commandos("C:\\Users\\luisf\\eclipse-workspace\\cursomcc\\Interprete\\src\\interprete\\CommandsTxt\\Commandos.txt");
        List<String> programa = new ArrayList<>();
        Interprete interpreter = new Interprete();
        
        try {
            BufferedReader txt = commandos.leerCommandos();
            String linea;

            while ((linea = txt.readLine()) != null) {
                // Dividir la línea en un array por espacios
                //String[] valores = linea.split("\\s+");
                //System.out.println("El valor de valores es: " + valores[0]);
               programa.add(linea);
               /* int enteroBase = Integer.parseInt(valores[1]);
                int enteroAltura = Integer.parseInt(valores[3]);
                double area = Double.parseDouble(valores[5]);

                System.out.println("El valor de base es: " + enteroBase);
                System.out.println(enteroBase);
                System.out.println("salto");
                System.out.println("El valor de altura es: " + enteroAltura);
                System.out.println(enteroAltura);
                System.out.println("salto");
                System.out.println("El valor de area es: " + area);
                System.out.println(area);
                System.out.println("salto");*/
               
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        interpreter.ejecutarPrograma(programa);
       //System.out.println("El valor de base es: " + interpreter.obtenerVariable("base"));

        /*
        // Your code here
        List<String> programa = new ArrayList<>();
        programa.add("asignar a 5");
        programa.add("asignar b 7");
        programa.add("asignar c + a b");

        Interprete interpreter = new Interprete();
        
        
        //interpreter.ejecutarPrograma(programa);

        // Obtener el valor de la variable c después de ejecutar el programa
        //System.out.println("El valor de a es: " + interpreter.obtenerVariable("c"));
        */
    }
}
    

