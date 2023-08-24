package biblioteca;

public class espera {
	int id;
	String nombreLibro;
	String usuario;
	
	
	public espera (int id,String nombreLibro, String usuario){
		this.id = id;
		this.nombreLibro = nombreLibro;
		this.usuario = usuario;
		
	}
	
	public String toString() {
		return "Id Libro: "+this.id +"| Libro: "+this.nombreLibro+ "| Usuario: "+ this.usuario;
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    espera aux = (espera) obj;
	    return this.id == aux.id && this.usuario.equals(aux.usuario);
	}
}
