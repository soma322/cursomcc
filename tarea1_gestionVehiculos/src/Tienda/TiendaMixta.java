package Tienda;

public class TiendaMixta extends Tienda implements Pago {
	boolean efectivo = true;
	boolean tarjeta = true;
	double saldo;
	public TiendaMixta(String nombre, String direccion, int telefono) {
		super(nombre, direccion, telefono);
		this.saldo = 0;
	}

	@Override
	public void realizarCobro(double monto) {
		this.saldo = this.saldo + monto;
		
	}



	@Override
	public void realizarPago(double monto,String tipoPago) {
		if(saldo == 0) {
			System.out.println("favor de hacer un cobro");
			return;
		}
		if(saldo >= monto) {
			saldo = saldo - monto;
		}else {
			System.out.println("Saldo insufiente");
		}
		
	}


	@Override
	public void verInventario() {
		for(Productos prod : super.inventario ) {
			System.out.println("Nombre del producto: "+prod.nombre+ " cantidad: "+prod.cantidad+" y con un valor de: "+prod.precio);
		}
		
	}

	@Override
	public void agregarProducto(String nombre, int precio, int cantidad) {
		int contador = 0;
		Productos prod = new Productos(nombre,precio,cantidad);
		for(Productos list : super.inventario ) {
			if(list.nombre == nombre) {
				prod = new Productos(nombre,precio,(cantidad+list.cantidad));
				super.inventario.set(contador,prod);
				return;
			}
			contador = contador + 1;
		}
		super.inventario.add(prod);
		
	}

	@Override
	public void realizarPago(double cantidad) {
		System.out.println("Se ha realizado un pago de $" + cantidad + " en la tienda");
		
	}


}
