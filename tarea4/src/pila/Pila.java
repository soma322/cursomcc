package pila;
import pila.Nodo;

public class Pila <T>{
	private Nodo<T> inicio;
	private int tope;
	
	public Pila() {
		this.inicio = null;
		this.tope = 0;
	}
	
	public int tamano() {
		return tope;
	}
	
	public boolean esVacia() {
		return tope == 0;
	}
	
	public void apilar(T valor) {
		Nodo<T> nuevo = new Nodo<T>(valor);
		
		if(esVacia()) {
			inicio = nuevo;
		}else {
			nuevo.setEnlace(inicio);
			inicio = nuevo;
		}
		tope ++;
	}
	
	public void desapilar() {
		if(!esVacia()) {
			inicio = inicio.getEnlace();
			tope--;
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
	
	public T cima() {
		if(!esVacia()) {
			return inicio.getDato();
		}
		System.out.println("La pila est� vacia");
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
	
	//Buscar el ultimo elmento en la pila.
	public T fondo() {
		if (esVacia()) {
			
			return null;
		}
		
		return fondoRecur(inicio);
	}
	public T fondoRecur(Nodo<T> actual) {
		if (actual.getEnlace() == null) {
			return actual.getDato();
		}
		
		return fondoRecur(actual.getEnlace());
	}
	
	//Eliminar un elemento en la pila por su valor.
	public T remover(T valor) {
		if (esVacia()) {
			return null;
		}
		
		return removerRecur(inicio,valor);
	}
	public T removerRecur(Nodo<T> actual, T valor) {
		if (actual.getEnlace() == null) {
			return null;
		}
		
		if(actual.getDato().equals(valor)) {
			return actual.getDato();
		}
		
		return fondoRecur(actual.getEnlace());
	}
	
	//Buscar un elemento en la pila y si lo encuentra modifica su valor
	public void editar(T valor, T nuevo) {
		if (esVacia()) {
			return;
		}
		
		editarRecur(inicio,valor,nuevo);
	}
	public void editarRecur(Nodo<T> actual,T valor, T nuevo) {
		if (actual == null) {
			return;
		}
		
		if(actual.getDato().equals(valor)) {
			actual.setDato(nuevo);
		}
		editarRecur(actual.getEnlace(),valor,nuevo);
		
	}
	
}
