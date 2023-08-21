package vehiculos;

public class Coche extends vehiculo implements Sonido{
	int numeroPuertas;
	String tipoCombustible;
	public Coche(String marca, String modelo, int numeroPuertas, String tipoCombustible) {
		super(marca, modelo);
		this.numeroPuertas = numeroPuertas;
		this.tipoCombustible = tipoCombustible;
	}

	
	public void mostrarInformación() {
		String respuesta = "Tienes un coche de marca: "+super.marca;
		respuesta += " es del modelo: "+super.modelo;
		respuesta += ", tiene "+this.numeroPuertas+" puertas";
		respuesta += " y utiliza combustible del tipo: "+ this.tipoCombustible;
		System.out.println(respuesta);

		
	}


	@Override
	public void claxon() {
		System.out.println("PI PI PI");
		
	}


	@Override
	public void alarma() {
		System.out.println("bong bong bong");
		
	}
	
}
