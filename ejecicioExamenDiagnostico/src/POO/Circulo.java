package POO;

public class Circulo {
	private double radio;
	
	public Circulo(double radio) {
		this.radio = radio;
	}
	
	public double area() {
		double area = (3.1416 * (radio * radio));
		area = Math.round(area * 100.0) / 100.0;
		return area;
	}
}
