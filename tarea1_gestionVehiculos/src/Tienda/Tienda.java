package Tienda;

import java.util.ArrayList;

public abstract class Tienda {
	protected String nombre;
	protected String direccion;
	protected int telefono;
	protected ArrayList<Productos> inventario;
	
	public Tienda(String nombre, String direccion,int telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.inventario = new ArrayList<>();
	}
	
	
	public abstract void realizarCobro(double monto);
	public abstract void realizarPago(double monto, String tipoPago);
	public abstract void verInventario();
	public abstract void agregarProducto(String nombre,	int precio,	int cantidad);
	
	
	
}
