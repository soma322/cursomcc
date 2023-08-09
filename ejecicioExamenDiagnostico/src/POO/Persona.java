package POO;

public class Persona {
	private String nombre;
	private int edad;
	private String sexo;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, int edad , String sexo) {
		this.nombre = nombre;
		this.edad	= edad;
		this.sexo	= sexo;
		
	}
	public String getnombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public String getSexo() {
		return sexo;
	}


}

