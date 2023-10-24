package blackjack;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    protected String rol;
    protected ArrayList<Cartas> mano;
    private int saldo;
    private int apuesta;

    public Jugador(String nombre,int saldo){
        this.nombre = nombre;
        this.mano  = new ArrayList<Cartas>();
        this.saldo = saldo;
        this.rol   = "Jugador";
    }
     public Jugador(String nombre){
        this.nombre = nombre;
        this.mano  = new ArrayList<Cartas>();
        this.saldo = 0;
        this.rol   = "Croupier";
    }


    public void setApuesta(int apuesta){
        this.apuesta = apuesta;

    }
    public int getApuesta(){
        return this.apuesta;
    }
    public String getNombre(){
        return this.nombre;
    }

    public ArrayList<Cartas> getMano(){
        return this.mano;
    }
    public String getRol(){
        return this.rol;
    }
    public int getSaldo(){
        return this.saldo;
    }
    public void ganar(){
        
        saldo = saldo + (int)Math.round(apuesta * 1.5);
        apuesta = 0;
    }
    public void perder(){
        saldo = saldo - apuesta;
        apuesta = 0;
    }
    public void empate(){
        apuesta = 0;
    }

    public void agregarCarta(Cartas carta){
        mano.add(carta);
    }

    public void limpiarMano(){
        mano.clear();
    }

    public void restarSaldoJugador(int saldo){
        this.saldo = this.saldo - saldo;
    }

    public String toString(boolean revelarCarta){
        String respuesta = this.rol+": "+this.nombre+"  [";

        for (Cartas cartas : mano) {
            if (revelarCarta) {
                respuesta += "Carta oculta";
                revelarCarta = false;
                continue;
            }
            respuesta += cartas.getTipoCarta()+ cartas.getCarta();
            respuesta += " ";
           
        }

        respuesta += "]";


        
        return respuesta;
    }

    public int cantidadCartas(){
        return mano.size();
    }
    

    






}
