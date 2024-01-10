package interprete;

import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Map;

public class Memoria {
     private HashMap<String,HashValores> memoria;

     public Memoria() {
        memoria = new HashMap<String,HashValores>();
     }

    public void asignarVariable(String variable,HashValores valor) {
         memoria.put(variable, valor);
         //memoria.put(variable, valor);
    }

    // Método para obtener el valor de una variable
    public Object obtenerVariable(String valor) {
        return (memoria.get(valor).getValue());
    }


    public boolean existeVariable(Object valor) {
        return memoria.containsKey(valor);
    }
    public String obtenerClave(Object valor) {
        for (Map.Entry<String, HashValores> entry : memoria.entrySet()) {
            if (entry.getKey() == null) {
                continue;
            }
            if (entry.getKey().equals(valor)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String obtenerTipo(String key ){
        return memoria.get(key).getTipo();
    }
}
