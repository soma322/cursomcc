package Buscaminas;

public class Celda {
	private boolean estaAbierta;
	private boolean bomba;
	private boolean exploto;
	private boolean bloquear;
	private boolean marcar;
	private int numeroBombas;
	
	public Celda (boolean bomba) {
		this.bomba = bomba;
		this.exploto = false;
		this.bloquear = false;
		this.marcar = false;
		this.estaAbierta = false;
		this.numeroBombas = 0;
	}
	
	public boolean esBomba() {
		return this.bomba;
	}
	public boolean estaBloqueado() {
		return this.bloquear;
	}
	public boolean estaMarcado() {
		return this.bomba;
	}
	public int getNumeroBombasAlrededor() {
		return this.numeroBombas;
	}



	public boolean marcar(){
		if(estaAbierta){
			return false; //no se puede interactuar
		}
		this.marcar = !this.marcar;
		return true;
	}

	public boolean bloquear(){
		if(estaAbierta){
			return false; //no se puede interactuar
		}
		this.bloquear = !this.bloquear;
		return true;
	}
	public void abrir() {
        estaAbierta = true;
	}
	
	public String toString() {//🚩💣💥
		/*if(!estaAbierta){
			return "[  ]";
		}*/

		if (this.exploto) {
            return "[💥]";
        } else if (this.bomba) {
            return "[💣]";
        } else if (this.bloquear) {
            return "[❌]";
        } else if (this.marcar) {
            return "[🚩]";
        } else if (estaAbierta) {
            return "[" + this.numeroBombas + "]";
        } else {
            return "[  ]";
        }
	}
	

}
