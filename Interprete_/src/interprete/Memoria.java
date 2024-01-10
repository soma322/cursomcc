package interprete;

import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Map;


public class Memoria<T> {

    private HashMap<String,HashValores<T>> memoria;
    
    public Memoria() {
        memoria = new HashMap<String,HashValores <T>>();
    }

    public void asignarVariable(String variable,HashValores<T> valor) {
        memoria.put(variable, valor);
    }

    // Método para obtener el valor de una variable
    public T obtenerVariable(String valor) {
        return (memoria.get(valor).getValue());
    }


    public boolean existeVariable(String valor) {
        return memoria.containsKey(valor);
    }

    public String obtenerClave(T valor) {
        for (Map.Entry<String, HashValores<T>> entry : memoria.entrySet()) {
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
