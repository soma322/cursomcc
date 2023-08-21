package recursividad;

public class palindromo {

	public static void main(String[] args) {
		String palabra ="a luna ese anula";
		palabra = palabra.replaceAll("\\s","");
		String[] partes = palabra.split("");
		int indexFinal = partes.length;
		int indexInicio = 0;
		palindroma(partes,indexInicio,indexFinal-1);
		
		
	}
	public static void palindroma(String []partes, int indexInicio, int indexFinal) {
		if (indexFinal <0) {
			System.out.println("Es palindroma");
			return;
		}
		if(partes[indexInicio].equals(partes[indexFinal])  ) {
			palindroma(partes,indexInicio+1,indexFinal-1);
		}else {
			System.out.println("No es palindroma");
			return;
		}
	}

}
