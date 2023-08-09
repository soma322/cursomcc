package POO;
import POO.Circulo;
public class Cilindro extends Circulo{
	private double altura;
	public Cilindro(double radio, double altura) {
		super(radio);
		this.altura = altura;
		// TODO Auto-generated constructor stub
	}
	
	public double volumen() {
		double volumen = area() * altura;
		volumen = Math.round(volumen * 100.0) / 100.0;
		return volumen;
	}
	
	

	
	
}

