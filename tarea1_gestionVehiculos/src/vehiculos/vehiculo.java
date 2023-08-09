package vehiculos;

public abstract class vehiculo {
	String marca;
	String modelo;
	
	public vehiculo(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
	public abstract void mostrarInformación();
	

}
