package juego;

public class Celda {
	private boolean bomba = false;
	private String numeroBombas = "";
	
	public Celda (boolean vida) {
		this.vida = vida;
	}
	
	public boolean esBomba() {
		return this.bomba;
	}
	
	public String toString() {
		if(this.bomba) {
			return "[💣 ]";
		}else {
			return "[💥 ]";
		}
	}
	

}
