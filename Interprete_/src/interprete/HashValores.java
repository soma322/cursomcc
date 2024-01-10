package interprete;


public class HashValores<T> {
    private String tipo;
    private T value; // Using Object to hold Number or String values

    public HashValores(String tipo, T value) {
        this.tipo = tipo;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public String getTipo() {
        return tipo;
    }

    public void setValor(T value) {
        this.value = value;
    }
}
