package clase3;

public class Vehiculo {
	String marca;
	String modelo;
	
	public Vehiculo (String marca, String modelo){
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String toString() {
		return "La marca del vehiculo es: "+this.marca + " modelo: " + this.modelo;
	}
	public String getMarca() {
		return this.marca;
	}
	public String getModelo() {
		return this.modelo;
	}
	
	public boolean equals(Object obj) {
		Vehiculo aux = (Vehiculo) obj;
		return (this.marca == aux.marca && this.modelo == aux.modelo);
	}
}
