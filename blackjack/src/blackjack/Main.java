package blackjack;

public class Main {
	public static void main(String[] args) {
   // Cartas carta = new Cartas(EnumCarta.AS);
   boolean flagTerminar = true;
   /*
    Baraja deck = new Baraja("blackjack");
    Croupier master = new Croupier();
    Jugador jugador = new Jugador("soma",100);
    
    while(flagTerminar){
        try {
            master.darCartaJugador(deck, jugador);
            System.out.println(deck.cantidadCartas());
            System.out.println(jugador.toString(false));
            System.out.println("Di carta a jugador");
        } catch (Exception e) {
            System.out.println("Trone");
            flagTerminar = false;
        }
    }*/
    

   Leer scan = new Leer();
    do {
        System.out.println("Bienvenido al casino! ");
        System.out.println("Seleccione un juego:");
        System.out.println("1.- Blackjack");
        System.out.println("2.- terminar");
        int n = scan.leerInt();
        switch(n) {
            case 1:
            Blackjack juego = capturarBlackjack();
            jugarBlackJack(juego);
            break;
            case 2:
                flagTerminar = false;
            break;
            default:
				System.out.println("Favor de seleccionar una opcion");
			break;
			

        }
    } while (flagTerminar);

	}

    public static void jugarBlackJack(Blackjack juego){
       
        bienvenidaBlackjack();
        boolean flagJuego = true;
        int puntuajeDealer = 0;
       
        
        while ( juego.cantidadJugadores() > 0) {
                juego.iniciarJuego();

            System.out.println(juego.toString(true));
            for(Jugador player: juego.getJugadores()) { // jugadores apuestan
                juego.apostarJugador(player);
            }
           
            //turn jugador
            /* 
            for(Jugador player: juego.getJugadores()) {
                System.out.println(player.toString(false) + "puntuaje: "+juego.calcularPuntuaje(player));
                while (juego.calcularPuntuaje(player) < 21 && juego.pedirQuedarse(player)){
                    juego.darCarta(player);
                    System.out.println(player.toString(false) + " puntuaje: "+juego.calcularPuntuaje(player));
                }
               

            }*/
            juego.jugadorJuega();
            System.out.println("----------------");
            System.out.println("");

            if(juego.esBlackjack(juego.getCroupier())){
                    System.out.println(juego.getCroupier().toString(false)+ " puntuaje: "+juego.calcularPuntuaje(juego.getCroupier()));
                    System.out.println("Croupier tiene Blackjack natural! Croupier Gana");
                    juego.checarEmpateBlackjackNatural();
                    juego.restarSaldoJugadores();
                    continue;
            }
             //turno del dealer
            juego.croupierJuega();
            System.out.println(juego.getCroupier().toString(false)+ " puntuaje: "+juego.calcularPuntuaje(juego.getCroupier()) );
            
            for(Jugador player: juego.getJugadores()) {
                    System.out.println(player.toString(false) + " puntuaje: "+juego.calcularPuntuaje(player));
            }
            System.out.println("----------------");
            System.out.println("");

            try {
                for(Jugador player: juego.getJugadores()) {
                    System.out.println(player.toString(false) + " puntuaje: "+juego.calcularPuntuaje(player));

                if (juego.calcularPuntuaje(juego.getCroupier()) == juego.calcularPuntuaje(player)) {
                    System.out.println("Jugador: "+player.getNombre()+ " empato con el  Croupier");
                    System.out.println("Puntuaje: "+player.getNombre()+":"+juego.calcularPuntuaje(player));
                    System.out.println("Puntuaje: "+juego.getCroupier().getNombre()+":"+juego.calcularPuntuaje(juego.getCroupier()));
                    player.empate();
                }
                
                if(juego.calcularPuntuaje(juego.getCroupier()) < juego.calcularPuntuaje(player) && juego.calcularPuntuaje(player) <= 21 || juego.calcularPuntuaje(juego.getCroupier())>21){
                    System.out.println("Jugador: "+player.getNombre()+ " gano!");
                    System.out.println("Puntuaje: "+player.getNombre()+":"+juego.calcularPuntuaje(player));
                    System.out.println("Puntuaje: "+juego.getCroupier().getNombre()+":"+juego.calcularPuntuaje(juego.getCroupier()));
                    player.ganar();
                }
                if(juego.calcularPuntuaje(juego.getCroupier()) > juego.calcularPuntuaje(player)  && juego.calcularPuntuaje(juego.getCroupier()) <= 21 || juego.calcularPuntuaje(player)>21 ){
                    System.out.println("Jugador: "+player.getNombre()+ " perdio!");
                    System.out.println("Puntuaje: "+player.getNombre()+":"+juego.calcularPuntuaje(player));
                    System.out.println("Puntuaje: "+juego.getCroupier().getNombre()+":"+juego.calcularPuntuaje(juego.getCroupier()));
                    player.perder();
                }

                if(player.getSaldo() <= 0){
                    System.out.println("jugador "+player.getNombre()+ " se a quedado sin saldo y a sido eliminado");
                    juego.eliminarJugador(player);
                }

                System.out.println("----------------");
                System.out.println("");
            }
           
            } catch (Exception e) {
                // TODO: handle exception
            }
                
        
            
            
            
            
        }
          System.out.println("No quedan jugadores para jugar.");
    }
    
    public static void bienvenidaBlackjack(){
        System.out.println("¡Bienvenido al Blackjack!");
        System.out.println("");
        System.out.println("  REGLAS DEL BLACKJACK: ");
        System.out.println("-Cada jugador recibe 2 cartas. Al crupier se le reparten 2 cartas, una boca arriba y otra boca abajo.");
        System.out.println("-Las cartas tienen un valor igual a su número, las cartas con figuras valen 10 y un As puede valer 1 u 11.");
        System.out.println("-Se suman las cartas de cada jugador para obtener su total.");
        System.out.println("-Los jugadores 'Pide' para recibir otra carta del mazo. Los jugadores se 'Quedan' para conservar su total actual de cartas.");
        System.out.println("-El crupier 'Pide' cartas hasta que alcance o supere los 17 puntos.");
        System.out.println("-El objetivo es tener un total de cartas superior al del crupier sin pasarse de 21.");
        System.out.println("-Si el total de un jugador es igual al total del crupier, se llama 'Empate' y la mano termina.");
        System.out.println("-Los jugadores ganan su apuesta si vencen al crupier. Los jugadores ganan 1.5 veces su apuesta si obtienen un 'Blackjack', que es 21.");
        System.out.println("");
        System.out.println("");
    }
    public static Blackjack capturarBlackjack(){
        Leer scan = new Leer();
        int index = 1;
        int salgoJugado = 0;
        String nomJugador = "";
        Baraja baraja = new Baraja("blackjack");
        Croupier dealer = new Croupier();
        Blackjack blackjack = new Blackjack(baraja, dealer);
       
        int jugadores = scan.leerReglas("¿Cuantos jugadores jugaran blackjack?",1,7);

        while (jugadores >= index) {
            nomJugador = scan.leerString("Favor de escribir el nombre del jugador "+index);
            salgoJugado = scan.leerReglas("Con cuanto saldo empezara el jugador "+index+"?", 1, 10000);
            blackjack.agregarJugador(new Jugador(nomJugador, salgoJugado));
            index++;
        }
        

        return blackjack;
    }
    
}
