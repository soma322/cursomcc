package blackjack;

public class Cartas {
    private String carta;
    private int valor;
    private String tipoCarta;

    public Cartas(String nomCarta, int valorCarta, String tipoCarta) {
        this.carta = nomCarta;
        this.valor = valorCarta;
        this.tipoCarta = tipoCarta;
    }

    

    public String getCarta() {
        return this.carta;
    }

    public int getValor() {
    	return this.valor;
    }

    public String getTipoCarta() {
        return this.tipoCarta;
    }
       
    
   
}
