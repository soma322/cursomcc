package Cola;

public class Main {
	
	public static void main(String[] args) {
	
		
		Cola<Integer> cola = new Cola<Integer>();
		cola.agregar(90);
		cola.agregar(55);
		cola.agregar(42);
		cola.agregar(6);
		cola.agregar(22);
		
		System.out.println("--Imprimiendo Cola--");
		cola.imprimir();
		System.out.println("Extrayendo un elemento de la cola");
		cola.retirar();
		System.out.println("--Imprimiendo nueva Cola--");
		cola.imprimir();
		
		System.out.println("El valor del primero en la cola es: " + cola.primero());
		System.out.println("Se busca en la cola el valor 23: " + cola.buscar(23));
		System.out.println("Se busca en la cola el valor 6: " + cola.buscar(6));
		
		
		//tarea 4
		System.out.println("El valor del fondo en la cola es: "+cola.fondo());
		
		System.out.println("Remover el valor 55");
		cola.remover(55);
		cola.imprimir();
		
		System.out.println("cambiar valor 42 por 100");
		cola.editar(42, 100);
		cola.imprimir();
		///////////////////////////////////////////////////////////////////
		
		
	
		
	}

}
