package interprete;

import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class Memoria {
     private HashMap<HashValores> memoria;

     public Memoria() {
         memoria = new HashMap<>();
         memoria.put("int", new HashValores());
         memoria.put("real", new HashValores());
         memoria.put("String", new HashValores());
     }

    public Integer obtenerMapInt(String valor) {
        HashMap<String, Integer> mapInt = (HashMap<String, Integer>) memoria.get("int");
        if (mapInt != null) {
            return mapInt.get(valor); // This may return null if 'valor' is not a key in the map
        }
        return null; // Or handle the absence of the map if needed
    }
    public KeyValue obtenerMapKey(String valor) {
    HashMap<String, Integer> mapInt = (HashMap<String, Integer>) memoria.get("int");
    if (mapInt != null) {
        Integer value = mapInt.get(valor);
        if (value != null) {
            return new KeyValue(valor, value);
        }
    }
    return null;
}
    

      // Método para asignar valor a una variable
    public void asignarVariable(String variable, Object valor) {
         (HashMap<String,Integer>)memoria.get(tipo).put(valor);
    }

    // Método para obtener el valor de una variable
    public Object obtenerVariable(String tipo,String valor) {
        return ((HashMap<String,Integer>)memoria.get(tipo)).get(valor);
    }

    public boolean existeVariable(Object valor) {
        return memoria.containsKey(valor);
    }
    public String obtenerClave(Object valor) {
        for (Map.Entry<String, Object> entry : memoria.entrySet()) {
            if (entry.getKey() == null) {
                continue;
            }
            if (entry.getKey().equals(valor)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
