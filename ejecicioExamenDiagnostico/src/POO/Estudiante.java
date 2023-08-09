package POO;

public class Estudiante {
	private String nombre;
	private int edad;
	private String carrera;
	
	public Estudiante() {
		nombre = "";
		edad = 0;
		carrera = "";
	}
	public void altaEstudiante(String nuevoEstudiante, int edadEstudiante, String carreraEstudiante) {
		nombre = nuevoEstudiante;
		edad = edadEstudiante;
		carrera = carreraEstudiante;
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	public int obtenerEdad() {
		return edad;
	}
	
	public String obtenerCarrera() {
		return carrera;
	}
	
}
