package blackjack;

import java.util.ArrayList;
import java.util.List;
public class Baraja {
    private List<Cartas> cartas;
    
    public Baraja() {
    	cartas = new ArrayList<>();
        EnumCartaBlackJack[] cartaValues = EnumCartaBlackJack.values();
        String[] tipoCartas = {"♠","♥","♦","♣"};
        for (int i = 0; i < tipoCartas.length; i++) {
            for (EnumCartaBlackJack carta : cartaValues) {
               
                this.cartas.add(new Cartas(carta.getNombre(), carta.getValor(), tipoCartas[i]));
            }
        }
       
    }
    
    public EnumCartaBlackJack juego() {
    	
    }

    public String toString(){
        String res = "";

        for (int i = 0; i < cartas.size(); i++) {
            res += cartas.get(i).getCarta() + " valor:"+ cartas.get(i).getValor()+ " tipo:"+ cartas.get(i).getTipoCarta()+ "\n";
        }
        return res;
    }
}
