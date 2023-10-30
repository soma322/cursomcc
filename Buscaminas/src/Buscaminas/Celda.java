package Buscaminas;

public class Celda {
	private boolean estaAbierta;
	private boolean bomba;
	private boolean exploto;
	private boolean bloquear;
	private int numeroBombas;
	
	public Celda (boolean bomba) {
		this.bomba = bomba;
		this.exploto = false;
		this.bloquear = false;
		this.estaAbierta = false;
		this.numeroBombas = 0;
	}
	
	public boolean esBomba() {
		return this.bomba;
	}
	public boolean estaBloqueado() {
		return this.bloquear;
	}
	public int getNumeroBombasAlrededor() {
		return this.numeroBombas;
	}

	public void setExploto(boolean exploto){
		this.exploto = exploto;
		this.bomba	= false;
	}

	public void setNumeroBombas(int numero){
		this.numeroBombas = numero;
	}

	public boolean setBloqueo(){
		if(estaAbierta || estaBloqueado()){
			return false; //no se puede interactuar
		}
		this.bloquear = true;
		return true;
	}

	public boolean setDesbloqueo(){
		if(estaAbierta || !estaBloqueado()){
			return false; //no se puede interactuar
		}
		this.bloquear = false;
		return true;
	}
	public void abrir() {
		estaAbierta = true;
	  
   }

	public boolean estaAbierta(){
		return estaAbierta;
	}
	
	public String toString() {//🚩💣💥
		if (this.exploto) {
            return "[💥]";
        }else if (this.bloquear) {
            return "[🚩]";
        }else if (estaAbierta) {
            return "[ " + this.numeroBombas + " ]";
        } else {
            return "[  ]";
        }
	}

	public String toString(boolean bomba) {
		if (this.bomba) {
            return "[💣]";
        }else if (this.exploto) {
            return "[💥]";
        }else if (this.bloquear) {
            return "[🚩]";
        }else if (estaAbierta) {
            return "[ " + this.numeroBombas + " ]";
        } else {
            return "[  ]";
        }
	}
	

}
