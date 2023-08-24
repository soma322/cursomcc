package biblioteca;

public class libros {
	int id;
	String nombreLibro;
	String usuario;
	boolean status;
	
	public libros (int id,String nombreLibro,String usuario, boolean status){
		this.id = id;
		this.nombreLibro = nombreLibro;
		this.usuario = usuario;
		this.status = status;
	}
	
	public String toString() {
		if(this.status) {
			return this.id+".- Libro: "+this.nombreLibro + "| Status: Disponible";
		}else {
			return this.id+".- Libro: "+this.nombreLibro + "| Status: No disponible";
		}
		
		
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    libros aux = (libros) obj;
	    if(aux.status) {
	    	return this.id == aux.id && this.status == aux.status;
	    }else {
	    	if(aux.id == 0) {
	    		return this.usuario.equals(aux.usuario);
	    	}else {
	    		return this.id == aux.id;
	    	}
	    	
	    }
	    
	}
}
