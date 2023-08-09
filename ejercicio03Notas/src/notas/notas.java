package notas;
import java.util.ArrayList;

public class notas {

	ArrayList<Double> notas;
	public notas() {
		notas = new ArrayList<>();
	}
	
	public void guardarNota(double n) {
		notas.add(n);
	}
	public double media() {
		double media = 0;
		for(double d:notas) {
			media+=d;
		}
		return media/notas.size();
	}
	
}
