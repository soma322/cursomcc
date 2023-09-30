package blackjack;

public class EnumCartas {
    
	public enum blackjack {
		AS("AS", 1),
	    DOS("DOS", 2),
	    TRES("TRES", 3),
	    CUATRO("CUATRO", 4),
	    CINCO("CINCO", 5),
	    SEIS("SEIS", 6),
	    SIETE("SIETE", 7),
	    OCHO("OCHO", 8),
	    NUEVE("NUEVE", 9),
	    DIEZ("DIEZ", 10),
	    JOTA("JOTA", 10),
	    REINA("REINA", 10),
	    REY("REY", 10);
	
		private final String nombre;
        private final int valor;

        private blackjack(String nombre, int valor) {
            this.nombre = nombre;
            this.valor = valor;
        }

        public String getNombre() {
            return nombre;
        }

        public int getValor() {
            return valor;
        }
	    

    
	}
    
}
