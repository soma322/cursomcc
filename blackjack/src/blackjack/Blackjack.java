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
        for (Cartas cartas : jugador.getMano()) {
            if(cartas.getValor() == 1){
                ace = true;
            }
            puntuaje = puntuaje + cartas.getValor();
        }

        if(puntuaje <= 10 && ace){
            puntuaje = puntuaje + 10;
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
                baraja.nuevaBaraja();
                baraja.barajearBaraja();
                croupier.agregarCarta(baraja.cartaTopeBaraja());

             }
			
		}
        return calcularPuntuaje(croupier);
        
	}
   
    public void restarSaldoJugadores(){
        for(Jugador player: jugador){
            player.perder();
        }
    }
    public void checarEmpateBlackjack(){
         for(Jugador player: jugador){
            if (esBlackjack(player)) {
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
        boolean revelarCartaCroupier = revelarCarta;
        respuesta += croupier.getRol()+": "+croupier.getNombre()+"  [";
        for (Cartas cartas : croupier.getMano()) {
             if (revelarCartaCroupier) {
                    respuesta += "OCULTA ";
                    revelarCartaCroupier = false;
                    continue;
                }
                respuesta += cartas.getTipoCarta()+ cartas.getCarta();
                respuesta += " ";

        }

        respuesta += " ]";
        respuesta +="\n";
        for(Jugador player: jugador){
            respuesta +=  player.getRol()+": "+player.getNombre()+"  [";
            
            for (Cartas cartas : player.getMano()) {
                if (revelarCarta) {
                    respuesta += "OCULTA ";
                    revelarCarta = false;
                    continue;
                }
                respuesta += cartas.getTipoCarta()+ cartas.getCarta();
                respuesta += " ";
                
            }

            respuesta += " ]";
            respuesta +="\n";
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
