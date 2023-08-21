package recursividad;

public class subcadenas {

	public static void main(String[] args) {
		String cadena = "123456";
		//System.out.println(cadena.charAt(0));
		int index = cadena.length();
		subcadena(cadena,0,1);
		
	}
	private static void subcadena(String cadena, int indexInicio,int indexFinal ) {
		
		if(indexInicio == cadena.length()) {
			return;
		}
	
		if(indexFinal >= cadena.length()) {
			indexFinal = -1;
			subcadena(cadena,indexInicio+1,indexFinal+1);
			return;
		}
		
		System.out.println(cadena.charAt(indexInicio)+""+cadena.charAt(indexFinal));
		
		subcadena(cadena,indexInicio,indexFinal+1);
	}

}
