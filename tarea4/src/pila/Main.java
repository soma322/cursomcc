package pila;

public class Main {
	
	public static void main(String[] args) {
		Pila<Integer> pila = new Pila<Integer>();
		pila.apilar(23);
		pila.apilar(15);
		pila.apilar(2);
		pila.apilar(43);
		
		System.out.println("La cima de la pila es: " +pila.cima());
		System.out.println("El tama�o de la pila es: " + pila.tamano());
		System.out.println("Se busca en la pila el valor 23: " + pila.buscar(23));
		System.out.println("Se busca en la pila el valor 5: " + pila.buscar(5));
		
		System.out.println("--Imprimiendo Pila--");
		pila.imprimir();
		System.out.println("Retirando un elemento de la pila");
		pila.desapilar();
		System.out.println("--Imprimiendo nueva Pila--");
		pila.imprimir();

		
		
		///////////////////////////////////////////////////////////////////
		
		//tarea 4
		System.out.println("El fondo de la pila es: "+pila.fondo());
		
		System.out.println("¿Se encuentra el elemento 23 en la pila? " +pila.buscar(23));
		
		System.out.println("Cambiar el elemento 23 por 50 e imprimir: ");
		
		pila.editar(23, 50);
		pila.imprimir();
		
	}

}
