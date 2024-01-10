package interprete;

import java.io.BufferedReader;
import java.io.FileReader;

public class Commandos {
    String archivo;

    public Commandos(String archivo) {
        this.archivo = archivo;
    }

    public BufferedReader leerCommandos(){
        try {
            return new BufferedReader(new FileReader(archivo));
        } catch (Exception e) {
            return null;
        }

        
    }
}
