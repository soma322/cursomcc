package recursividad;

public class sumaArreglo {

	public static void main(String[] args) {
		int[] numeros = {1,2,3,4,5};
		
		
		int suma = sumaArreglo(numeros,numeros.length-1);
		System.out.println(suma);
	}
	public static int sumaArreglo(int[] numeros,int index) {
		
		if(index < 0) {
			return 0;
		}

		return numeros[index] + sumaArreglo(numeros,index-1);
		
		
	}

}
