package blackjack;

public class Croupier extends Jugador{

    public Croupier() {
        super("Dealer");
        super.rol = "Croupier";
        
    }

    public void repartirInicioJugador(Baraja baraja, Jugador jugador){
        int repartir = 0;
        do{
             try {
                jugador.agregarCarta(baraja.cartaTopeBaraja());
             } catch (Exception e) {
                // Se acabo la baraja
                baraja.nuevaBaraja();
                baraja.barajearBaraja();
                jugador.agregarCarta(baraja.cartaTopeBaraja());

             }
             repartir++;
        }while(repartir < 2);
    }
    public void darCartaJugador(Baraja baraja, Jugador jugador){
        
        try {
            jugador.agregarCarta(baraja.cartaTopeBaraja());
        } catch (Exception e) {
            // Se acabo la baraja
            baraja.nuevaBaraja();
            baraja.barajearBaraja();
            jugador.agregarCarta(baraja.cartaTopeBaraja());

        }
            
        
    }
    

}
