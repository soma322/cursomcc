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
        if(!croupier.darCartaJugador(baraja, player)){
            System.out.println("nueva baraja");
            setBaraja(new Baraja(baraja.getJuego()));
            croupier.darCartaJugador(baraja, player);
        }
    }

    public void jugadorJuega(){
        for(Jugador player: jugador) {
            System.out.println(player.toString(false) + "puntuaje: "+calcularPuntuaje(player));
            while (calcularPuntuaje(player) < 21 && pedirQuedarse(player)){
                darCarta(player);
                System.out.println(player.toString(false) + " puntuaje: "+calcularPuntuaje(player));
            }
           

        }
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
        int repartir = 0;
         for (Jugador player : jugador){
            
            player.limpiarMano();
            do{
                darCarta(player);
                repartir++;
            }while(repartir <2);
            
         
         }
         repartir = 0;

        this.croupier.limpiarMano();
         do{
                darCarta(this.croupier);
                repartir++;
            }while(repartir <2);
         
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
            
                Cartas carta = baraja.cartaTopeBaraja();
                if (carta != null) {
                    croupier.agregarCarta(carta);
                }else{
                    setBaraja(new Baraja(baraja.getJuego()));
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
