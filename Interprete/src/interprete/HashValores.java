package interprete;

public class HashValores {
    private String key;
    private String tipo;
    private Integer value;

    public HashValores(String key,String tipo, Integer value) {
        this.key = key;
        this.tipo = tipo;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
    public String getTipo() {
        return tipo;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
