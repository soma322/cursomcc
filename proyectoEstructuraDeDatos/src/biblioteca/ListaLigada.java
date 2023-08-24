package biblioteca;


public class ListaLigada <T>{
	private Nodo<T> raiz;
	private Nodo<T> cabeza;
	
	public ListaLigada() {
		this.raiz = null;
		this.cabeza = null;
	}
	
	public void insertar(T elem) {
		Nodo<T> nodo = new Nodo<T>(elem);
		if(this.raiz == null) {
			this.raiz = nodo;
			this.cabeza = nodo;
			return;
		}
		//Nodo<T> aux = this.raiz;
		//while(aux.getEnlace() != null) {
		//	aux = aux.getEnlace();
		//}
		//aux.setEnlace(nodo);
		insertarRecur(this.raiz, nodo,cabeza);
		//setCabeza(this.raiz);
		
	}
	
	private void insertarRecur(Nodo<T> actual, Nodo<T> elem, Nodo<T> cabeza) {
		if (actual.getEnlace() == null) {
			actual.setEnlace(elem);
			this.cabeza = actual.getEnlace();
			return;
		}
		cabeza = actual;
		insertarRecur(actual.getEnlace(), elem, cabeza);
	}
	
	//
	public void insertarInicio(T elem) {
		Nodo<T> nodo = new Nodo<T>(elem);
		if(this.raiz == null) {
			this.raiz = nodo;
			this.cabeza = nodo;
			return;
		}
		nodo.setEnlace(this.raiz);
		this.raiz = nodo;
		
		setCabeza(this.raiz);
	}
	
	public void setCabeza(Nodo<T> actual) {
		if(actual.getEnlace() == null) {
			this.cabeza = actual;
			return;
		}
		
		setCabeza(actual.getEnlace());
		
	}
	
	public void imprimePrimeroUltimo() {
		System.out.println("El primer elemento es: "+this.raiz.getDato());
		System.out.println("El Ultimo elemento es: "+this.cabeza.getDato());
	}

	
	public void imprimeLista() {
		System.out.println("Imprimiendo Lista");
		imprimeRecur(this.raiz);
	}
	
	private void imprimeRecur(Nodo<T> actual) {
		if (actual == null)
			return;
		System.out.println(actual.getDato());
		imprimeRecur(actual.getEnlace());
	}
	//tarea imprimir invertir en order inverso
	public void imprimeListaInversa() {
		System.out.println("Imprimiendo Lista Inversa");
		imprimeRecurInversa(this.raiz);
	}
	
	private void imprimeRecurInversa(Nodo<T> cabeza) {
		if (cabeza == null) {
			return;
		}
			
		imprimeRecurInversa(cabeza.getEnlace());
		System.out.println(cabeza.getDato());
	}
	
	public void borrar(T elem) {
		if (this.raiz == null) {
			System.out.println("No hay elementos en la lista");
			return;
		}
		if (this.raiz.getDato().equals(elem)) {
			this.raiz = this.raiz.getEnlace();
			return;
		}
		borrarRecursivo(this.raiz, elem);
	}
	
	private void borrarRecursivo(Nodo<T> actual, T elem) {
		if (actual.getEnlace() == null) {
			System.out.println("No se encontro ningun elemento");
			return;
		}
		if (actual.getEnlace().getDato().equals(elem)) {
			actual.setEnlace(actual.getEnlace().getEnlace());
			return;
		}
		borrarRecursivo(actual.getEnlace(), elem);
	}
	
	public boolean buscarElemento(T elemento) {
		if (this.raiz == null) {
			return false;
		}
		if (this.raiz.getDato().equals(elemento)) {
			return true;
		}
		
		return buscarElementoRecur(this.raiz,elemento);
		
	}
	//encontrar un elemento de la lista
	private boolean buscarElementoRecur(Nodo<T> actual,T elemento) {
		
		
		if (actual.getDato().equals(elemento)) {
			return true;
		}
		
		if (actual.getEnlace() == null) {
	        return false;
	    }
		
		
		return buscarElementoRecur(actual.getEnlace(),elemento);
		
	}
	
	public T obtenerValor(T elemento) {
	    if (this.raiz == null) {
	        return null; 
	    }
	    
	    return obtenerValorRecur(this.raiz, elemento);
	}

	private T obtenerValorRecur(Nodo<T> actual, T elemento) {
	    if (actual == null) {
	        return null; 
	    }
	    
	    if (actual.getDato().equals(elemento)) {
	        return actual.getDato(); // Element found
	    }
	    
	    return obtenerValorRecur(actual.getEnlace(), elemento);
	}
	
	public void unirListas(ListaLigada<T> listaNueva) {
		if (this.raiz == null) {
			this.raiz = listaNueva.raiz;
			this.cabeza = listaNueva.cabeza;
			return;
		}
		System.out.println(listaNueva.raiz.getDato());
		unirListaRecur(this.raiz, listaNueva.raiz);
		setCabeza(this.raiz);
		
		
	}
	private void unirListaRecur(Nodo<T> actual, Nodo<T> listaNueva) {
		if (actual.getEnlace() == null) {
			actual.setEnlace(listaNueva.getEnlace());
			
			return;
		}
		//System.out.println(listaNueva.getDato());
		
		unirListaRecur(actual.getEnlace(),listaNueva);
	}
	
	
}
