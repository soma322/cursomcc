package blackjack;

public class EnumCartas {
    
	public enum simboloCartas{
			TREBOL("♠"),
			DIAMANTE("♦"),
			PICA("♣"),
			CORAZON("♥");
			
		
			private final String simbolo;
		

			private simboloCartas(String simbolo) {
				this.simbolo = simbolo;
			
			}

			public String getSimbolo() {
				return simbolo;
			}	
	}

	public enum blackjack{
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

	public enum dompe{
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
	    JOTA("JOTA", 11),
	    REINA("REINA", 12),
	    REY("REY", 13);
	
		private final String nombre;
        private final int valor;

        private dompe(String nombre, int valor) {
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
