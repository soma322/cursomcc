package blackjack;

import java.util.ArrayList;

public class jugador {
    String Nombre;
    ArrayList<Cartas> mano;
    int saldo;

    public jugador(String nombre,int saldo){
        this.Nombre = nombre;
        this.mano = new ArrayList<Cartas>();
        this.saldo = saldo;
    }

    public void agregarCarta(Cartas carta){
        mano.add(carta);
    }

    public void limpiarMano(){
        mano.clear();
    }

    public String toString(){
        String respuesta = this.Nombre+":  [";

        for (Cartas cartas : mano) {
            respuesta += mano.get(0).getCarta()+ mano.get(0).getTipoCarta();
            respuesta += " ";
        }

        respuesta += " ]";


        
        return respuesta;
    }

    public int cantidadCartas(){
        return mano.size();
    }
    

    public int puntuajeEnMano(){
        int puntuaje = 0;
        boolean ace = false;
        for (Cartas cartas : mano) {
            if(mano.get(0).getValor() == 1){
                ace = true;
            }
            puntuaje = puntuaje + mano.get(0).getValor();
        }

        if(puntuaje <= 10 && ace){
            puntuaje = puntuaje + 10;
        }

        
        return puntuaje;

    }






}
