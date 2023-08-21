package Cola;
import pila.Nodo;

public class Cola <T>{
	
	private Nodo<T> inicio, fondo;
	
	public Cola() {
		this.inicio = null;
		this.fondo = null;
	}
	
	public boolean esVacia() {
		return this.inicio == null;
	}
	
	public void agregar(T valor) {
		Nodo<T> nuevo = new Nodo<T>(valor);
		
		if(esVacia()) {
			this.inicio = nuevo;
			this.fondo = nuevo;
		} else {
			fondo.setEnlace(nuevo);
			fondo = nuevo;
		}
	}
	
	public void imprimir() {
		imprimeRecur(inicio);
	}
	
	private void imprimeRecur(Nodo<T> actual) {
		if (actual == null)
			return;
		System.out.println(actual.getDato());
		imprimeRecur(actual.getEnlace());
	}
	
	public void retirar() {
		if (!esVacia()) {
			if(inicio == fondo) {
				inicio = null;
				fondo = null;
			}else
				inicio = inicio.getEnlace();
		}
	}
	
	public T primero() {
		if(!esVacia())
			return inicio.getDato();
		System.out.println("La cola est� vacia");
		return null;
	}
	
	public boolean buscar(T valor) {
		if (esVacia())
			return false;
		return buscarRecur(inicio, valor);
	}
	
	private boolean buscarRecur(Nodo<T> actual, T valor) {
		if (actual == null)
			return false;
		if (actual.getDato().equals(valor))
			return true;
		return buscarRecur(actual.getEnlace(), valor);
	}
	
	//Buscar el �ltimo elmento en la cola.
	public T fondo() {
		if (esVacia())
			return null;
		return fondoRecur(inicio);
	}
	private T fondoRecur(Nodo<T> actual) {
		if (actual.getEnlace() == null) {
			return actual.getDato();
		}
		
			
		return fondoRecur(actual.getEnlace());
	}
	
	//Eliminar un elemento en la cola por su valor.
	public void remover(T valor) {
		if (esVacia())
			return;
		inicio = removerRecur(inicio, valor);
	}
	private Nodo<T> removerRecur(Nodo<T> actual, T valor) {
		if (actual == null) {
			return null;
		}
			
		if (actual.getDato().equals(valor)) {
			
				return actual.getEnlace();
			
			
		}
			
		if (actual.getEnlace() != null && actual.getEnlace().getDato().equals(valor)) {
	        actual.setEnlace(actual.getEnlace().getEnlace());
	    } else {
	        actual.setEnlace(removerRecur(actual.getEnlace(), valor));
	    }
		
		return actual;
		
	}
	
	//Buscar un elemento en la cola y si lo encuentra modifica su valor
	public void editar(T valor, T nuevo) {
		if (esVacia())
			return;
		editarRecur(inicio, valor,nuevo);
	}
	private void editarRecur(Nodo<T> actual, T valor, T nuevo) {
		if (actual == null)
			return;
		if (actual.getDato().equals(valor)) {
			actual.setDato(nuevo);
			return;
		}
			
		editarRecur(actual.getEnlace(), valor, nuevo);
	}
}
