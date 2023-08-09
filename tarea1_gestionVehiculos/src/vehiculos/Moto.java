package vehiculos;

public class Moto extends vehiculo{
	int cilindrada;
	String tipoChasis;
	
	public Moto(String marca, String modelo,int cilindrada, String tipoChasis) {
		super(marca, modelo);
		this.cilindrada = cilindrada;
		this.tipoChasis = tipoChasis;
	}	
	
	public void mostrarInformación() {
		String respuesta = "Tienes una moto de marca: "+super.marca;
		respuesta += " es del modelo: "+super.modelo;
		respuesta += " tiene "+this.cilindrada+" cilindros";
		respuesta += " y utiliza un chasis de tipo: "+ this.tipoChasis;
		System.out.println(respuesta);
	
	}

	



	
	
	

}
