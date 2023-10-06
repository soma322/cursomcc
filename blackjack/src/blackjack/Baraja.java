package blackjack;

import java.util.ArrayList;
import java.util.Collections;
public class Baraja {
    private ArrayList<Cartas> cartas;
    private String juego;
    
    public Baraja(String juego) {
    	cartas = new ArrayList<Cartas>(); // inicializar baraja
        this.juego = juego;
        nuevaBaraja();
        barajearBaraja();
    }

    private void nuevaBaraja(){
        EnumCartas.simboloCartas[] simbolo = EnumCartas.simboloCartas.values();

        switch (this.juego) {
                case "blackjack":
                    EnumCartas.blackjack[] cartaValues = EnumCartas.blackjack.values();
                    for (int i = 0; i < simbolo.length; i++) {
                        for (int j = 0; j < cartaValues.length; j++ ) {
                        
                            this.cartas.add(new Cartas(cartaValues[j].getNombre(), cartaValues[j].getValor(), simbolo[i].getSimbolo() ));
                        }
                    }

                     break;
                default:
                  throw new IllegalArgumentException("juego invalido: " + juego);
                  
        }
    }

    public void barajearBaraja(){
        Collections.shuffle(cartas);
    }

    public Cartas cartaTopeBaraja(){
        Cartas carta = null;
        try {
            carta = cartas.remove(0);
        } catch (Exception e) {
           // si truena significa que no hay mas cartas
        }
        return carta;
    }

    public String toString(){
        String res = "";

        for (int i = 0; i < cartas.size(); i++) {
            res += cartas.get(i).getCarta() + " valor:"+ cartas.get(i).getValor()+ " tipo:"+ cartas.get(i).getTipoCarta()+ "\n";
        }
        return res;
    }
}
