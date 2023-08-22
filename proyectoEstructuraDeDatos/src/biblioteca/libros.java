package biblioteca;

public class libros {
	String nombreLibro;
	
	boolean status;
	
	public libros (String nombreLibro, String prestadoUsuario, boolean status){
		this.nombreLibro = nombreLibro;
		
		this.status = status;
	}
	
	public String toString() {
		return "Libro: "+this.nombreLibro + "| Status: " + this.status;
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    libros aux = (libros) obj;
	    return this.nombreLibro.equals(aux.nombreLibro) && this.status == aux.status;
	}
}
