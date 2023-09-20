package juego;

public class Celda {
	private boolean vida = false;
	
	public Celda (boolean vida) {
		this.vida = vida;
	}
	
	public boolean estaVivo() {
		return vida;
	}
	
	public String toString() {
		if(vida) {
			return "[❤️ ]";
		}else {
			return "[☠️ ]";
		}
	}
	

}
