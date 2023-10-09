package blackjack;

public class Croupier extends Jugador{

    public Croupier() {
        super("Dealer");
        super.rol = "Croupier";
        
    }

    public int repartirInicioJugador(Baraja baraja, Jugador jugador, int repartir){
        do{
            
                Cartas carta = baraja.cartaTopeBaraja();
               
                if(carta != null){
                    jugador.agregarCarta(baraja.cartaTopeBaraja());
                }else{
                   return repartir;
                }
               
             
             repartir++;
        }while(repartir < 2);
        repartir = 0;
        return repartir;
        

    }
    public boolean darCartaJugador(Baraja baraja, Jugador jugador){
        boolean res = true;
        Cartas carta = baraja.cartaTopeBaraja();
        if(carta != null){
              jugador.agregarCarta(carta);
        }else{
            res = false;
        }
          
       
        return res;
            
        
    }
    

}
