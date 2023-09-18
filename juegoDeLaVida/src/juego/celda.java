package juego;

public class celda {
	private boolean vida = false;
	
	public celda (boolean vida) {
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
