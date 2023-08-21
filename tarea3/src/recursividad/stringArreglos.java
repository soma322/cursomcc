package recursividad;

public class stringArreglos {

	public static void main(String[] args) {
		String[] frutas = {"manzana","pera","platano","durazno"};
		int index = frutas.length;
		
		imprimirArreglo(frutas,index-1);
		

	}
	public static void imprimirArreglo(String[]frutas,int index) {
		if(index < 0) {
			return; 
		}
		System.out.println(frutas[index]);
		imprimirArreglo(frutas,index-1);
	}

}
