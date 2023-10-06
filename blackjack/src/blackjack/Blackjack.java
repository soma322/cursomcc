package blackjack;

import java.util.ArrayList;

public class Blackjack {
    private ArrayList<Jugador> jugador;
    private Baraja baraja;
    private Croupier croupier;
    

    public Blackjack(Baraja baraja, Croupier croupier) {
        this.baraja = baraja;
        this.croupier = croupier;
        this.jugador = new ArrayList<Jugador>();
    }

    public void darCarta(Jugador player){
        croupier.darCartaJugador(baraja, player);
    }

    public boolean pedirQuedarse(Jugador jugador) {
         Leer scan = new Leer();
         boolean respuesta = true;
         boolean flagTerminar = true;
        do {
            String valor = scan.leerString("Jugador: "+jugador.getNombre()+" quieres (p)pedir o (q)quedarte? (p/q):");
            
            switch (valor) {
                case "p":
                    respuesta = true;
                    flagTerminar = false;
                    break;
                case "q":
                    respuesta = false;
                    flagTerminar = false;
                    break;
                    
                default:
                    System.out.println("Favor de escribir una opcion valida");
                    break;
            }

        } while (flagTerminar);
         return respuesta;


    }

    public void setBaraja(Baraja baraja){
        this.baraja = baraja;
    }


    public void iniciarJuego(){
         for (Jugador player : jugador){
            player.limpiarMano();
            this.croupier.repartirInicioJugador(this.baraja,player);
         }
         this.croupier.limpiarMano();
         this.croupier.repartirInicioJugador(this.baraja,this.croupier);
    }
    public void apostarJugador(Jugador jugador){
        Leer scan = new Leer();
        System.out.println("Jugador "+jugador.getNombre()+" tiene "+jugador.getSaldo()+" creditos");
        jugador.setApuesta(scan.leerReglas("Ponte tu apuesta (1- "+jugador.getSaldo()+"):", 1, jugador.getSaldo()));
    }

    public int calcularPuntuaje(Jugador jugador){
         int puntuaje = 0;
            boolean ace = false;
        try {
           
            for (Cartas cartas : jugador.getMano()) {
                if(cartas.getValor() == 1){
                    ace = true;
                }
                puntuaje = puntuaje + cartas.getValor();
            }

            if(puntuaje <= 11 && ace){
                puntuaje = puntuaje + 10;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        

        
        return puntuaje;

    }
     
    public Croupier getCroupier(){
        return this.croupier;
    }
    public Baraja getBaraja(){
        return this.baraja;
    }
    public ArrayList<Jugador> getJugadores(){
        return this.jugador;
    }

    public int croupierJuega() {

        
		while (calcularPuntuaje(croupier) <= 16) {
            try {
                croupier.agregarCarta(baraja.cartaTopeBaraja());
             } catch (Exception e) {
                // Se acabo la baraja
                

                baraja = new Baraja(getJuego());
                croupier.agregarCarta(baraja.cartaTopeBaraja());

             }
			
		}
        return calcularPuntuaje(croupier);
        
	}
   
    public void restarSaldoJugadores(){
        for(Jugador player: jugador){
            if(player.getApuesta() != 0){
                System.out.println("Jugador:"+player.getNombre() + " pierde contra blackjack natural del dealer!");
                player.perder();
            }
            
            
        }
    }
    public void checarEmpateBlackjackNatural(){
         for(Jugador player: jugador){
            if (esBlackjack(player) && player.cantidadCartas() == 2) {
                System.out.println("Jugador:"+player.getNombre() + " tambien tiene blackjack natural! Empata con dealer");
                player.empate();
            }
        }
    }

     public void sumarSaldoJugadores(){
        for(Jugador player: jugador){
            player.ganar();
            
        }
    }
   

    public String toString(boolean revelarCarta){
        String respuesta ="";
        boolean flagAux = revelarCarta;
        respuesta += croupier.getRol()+": "+croupier.getNombre()+"  [";
        int aux = 0;
        for (Cartas cartas : croupier.getMano()) {
             if (flagAux && aux == 0) {
                    respuesta += "OCULTA ";
                    flagAux = false;
                    aux++;
                    continue;
                }
                respuesta += cartas.getTipoCarta()+ cartas.getCarta();
                respuesta += " ";

        }
        flagAux = revelarCarta;
        aux = 0;

        respuesta += " ]";
        respuesta +="\n";
        for(Jugador player: jugador){
            
            respuesta +=  player.getRol()+": "+player.getNombre()+"  [";
            
            for (Cartas cartas : player.getMano()) {
                if (flagAux && aux == 0) {
                    respuesta += "OCULTA ";
                    flagAux = false;
                    aux++;
                    continue;
                }
                respuesta += cartas.getTipoCarta()+ cartas.getCarta();
                respuesta += " ";
                
            }

            respuesta += " ]";
            respuesta +="\n";
            aux = 0;
            flagAux = revelarCarta;
        }
        return respuesta;
    }


    public boolean esBlackjack(Jugador jugador){
        boolean response = false;
        if(calcularPuntuaje(jugador) == 21){
            response = true;
        }
        return response;
    }
    public int cantidadJugadores(){
        return this.jugador.size();
    }
    public void agregarJugador(Jugador jugador){
        this.jugador.add(jugador);
    }

    public void eliminarJugador(Jugador jugador){
        this.jugador.remove(jugador);

    }
}
