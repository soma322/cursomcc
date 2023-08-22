package biblioteca;

public class usuario {
	String usuario;
	String contrasena;
	
	public usuario (String usuario, String contrasena){
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	
	public String toString() {
		return "El usuario es: "+this.usuario + " contra: " + this.contrasena;
	}
	
	
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    usuario aux = (usuario) obj;

	    if(aux.contrasena == null) {
	    	 return this.usuario.equals(aux.usuario);
	    }else {
	        return this.usuario.equals(aux.usuario) && this.contrasena.equals(aux.contrasena);
	    }
	  
	}
	
	
}
