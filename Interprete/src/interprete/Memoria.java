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
    }

    public void actualizarVariable(String nomVariable, Object valor) {
        memoria.get(nomVariable).setValor(valor);
    }

    // Método para obtener el valor de una variable
    public Object obtenerValor(String nomVariable) {
        return (memoria.get(nomVariable).getValue());
    }


    public boolean existeVariable(String nomVariable) {//parametro string
        return memoria.containsKey(nomVariable);
    }

    public String obtenerTipo(String nomVariable ){
        return memoria.get(nomVariable).getTipo();
    }
}
