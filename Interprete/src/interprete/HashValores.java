package interprete;

public class HashValores {
    private String tipo;
    private Object value; // Using Object to hold Number or String values

    public HashValores(String tipo, Object value) {
        this.tipo = tipo;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public String getTipo() {
        return tipo;
    }

    public void setValor(Object value) {
        this.value = value;
    }
}
