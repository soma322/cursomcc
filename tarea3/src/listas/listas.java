package listas;
import clase3.ListaLigada;
import clase3.Vehiculo;

public class listas {
	
	
	

	public static void main(String[] args) {
	
		
		ListaLigada<Vehiculo> lv = new ListaLigada<Vehiculo>();
		lv.insertar(new Vehiculo("Nissan", "Tsuru"));
		lv.insertar(new Vehiculo("Nissan", "Tsuru2"));
		lv.insertar(new Vehiculo("Nissan", "Tsuru3"));
		lv.insertar(new Vehiculo("Nissan", "Tsuru4"));
		lv.insertar(new Vehiculo("Nissan", "Tsuru5"));
		lv.imprimeLista();
		lv.imprimeListaInversa();
		
		lv.insertarInicio(new Vehiculo("Nissan", "Tsuru6"));
		lv.insertarInicio(new Vehiculo("Nissan", "Tsuru7"));
		lv.insertar(new Vehiculo("Nissan", "Tsuru10"));
		lv.imprimeLista();
		
		lv.imprimePrimeroUltimo();
				
		
		lv.buscarElemento(new Vehiculo("Nissan", "Tsuru10"));
		
		ListaLigada<Vehiculo> lv2 = new ListaLigada<Vehiculo>();
		lv2.insertar(new Vehiculo("Toyota", "Corolla"));
		lv2.insertar(new Vehiculo("Toyota", "Corolla2"));
		lv2.insertar(new Vehiculo("Toyota", "Corolla3"));
		lv2.insertar(new Vehiculo("Toyota", "Corolla4"));
		lv2.insertar(new Vehiculo("Toyota", "Corolla5"));
		
		
		
		lv.unirListas(lv2);

		lv.imprimeLista();
		
		lv.imprimeListaInversa();
		
		
		
		
	}
}
