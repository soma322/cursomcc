package biblioteca;

public class espera {
	String nombreLibro;
	String prestadoUsuario;
	
	
	public espera (String nombreLibro, String prestadoUsuario){
		this.nombreLibro = nombreLibro;
		this.prestadoUsuario = prestadoUsuario;
		
	}
	
	public String toString() {
		return "Libro: "+this.nombreLibro + " Nombre del usuario que tiene: "+ this.prestadoUsuario;
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    espera aux = (espera) obj;
	    return this.nombreLibro.equals(aux.nombreLibro) && this.prestadoUsuario.equals(aux.prestadoUsuario);
	}
}
