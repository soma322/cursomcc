package clase3;

public class Main {
	public static void main(String[] args) {
		Vehiculo v = new Vehiculo("Nissan", "Tsuru");
		Vehiculo v2 = new Vehiculo("Nissan", "Tsuru");
		Nodo <Vehiculo> nv = new Nodo<Vehiculo> (v);
		Nodo <Vehiculo> nv2 = new Nodo<Vehiculo> (v2, nv);
		System.out.println(nv.getDato());
		System.out.println(nv.getEnlace());
		System.out.println(nv2.getDato());
		System.out.println(nv2.getEnlace());
		
		System.out.println("Son iguales? " + (v.equals(v2)));
		
		ListaLigada<Vehiculo> lv = new ListaLigada<Vehiculo>();
		lv.insertar(new Vehiculo("Nissan", "Tsuru"));
		lv.insertar(new Vehiculo("Nissan", "Tsuru2"));
		lv.insertar(new Vehiculo("Nissan", "Tsuru3"));
		lv.insertar(new Vehiculo("Nissan", "Tsuru4"));
		lv.insertar(new Vehiculo("Nissan", "Tsuru"));
		lv.imprimeLista();
		lv.borrar(new Vehiculo("Nissan", "Tsuru"));
		lv.imprimeLista();
		lv.borrar(new Vehiculo("Nissan", "Tsuru"));
		lv.imprimeLista();
	}
}
