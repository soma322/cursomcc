package blackjack;

public class Main {
	public static void main(String[] args) {
   // Cartas carta = new Cartas(EnumCarta.AS);
    
   Baraja baraja = new Baraja("blackjack");

   System.out.println(baraja.toString());
   /*
    EnumCarta[] cartaValues = EnumCarta.values();
    for (EnumCarta cartav : cartaValues) {
        System.out.println("Card Name: " + cartav.getNombre() + ", Card Value: " + cartav.getValor());
    }*/
   // System.out.println(carta.getCarta());
	}
    
}
