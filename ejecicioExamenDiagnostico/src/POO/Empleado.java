package POO;
import POO.Persona;
public class Empleado extends Persona{
	private String puesto;
	
	public Empleado() {
		super();
	}
	
	public Empleado(String nombre, int edad , String sexo, String puesto) {
		super(nombre,edad,sexo);
		this.puesto = puesto;
	}
	
	public String getPuesto() {
		return puesto;
	}
	

	
	
}
