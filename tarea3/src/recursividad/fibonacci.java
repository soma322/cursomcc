package recursividad;

public class fibonacci {

	public static void main(String[] args) {
		int n1= 0;
		int n2= 1;
		int n3= 0;
		 int count=15;    
		  System.out.print(0+" "+1);
		  imprimirFibonacci(n1,n2,n3,count-2);   

	}
	
	public static void imprimirFibonacci(int n1,int n2,int n3, int numero) {
		
		if(numero>0){    
	         n3 = n1 + n2;    
	         n1 = n2;    
	         n2 = n3;    
	         System.out.print(" "+n3);   
	         imprimirFibonacci(n1,n2,n3,numero-1);    
	     }    
	}

}
