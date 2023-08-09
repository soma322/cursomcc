package Tienda;

public class TiendaEfectivo extends Tienda {
	boolean efectivo = true;
	boolean tarjeta = false;
	double saldo;
	double limitePago;
	
	
	public TiendaEfectivo(String nombre, String direccion, int telefono) {
		super(nombre, direccion, telefono);
		this.saldo = 0;
	}

	@Override
	public void realizarCobro(double monto) {
		this.saldo = this.saldo + monto;
		
	}
	


	@Override
	public void realizarPago(double monto,String tipoPago) {
		if(tipoPago != "efectivo") {
			System.out.println("Tienda solo aceptar efectivo");
		}else {
			if(saldo == 0) {
				System.out.println("favor de hacer un cobro");
				return;
			}
			if(saldo >= monto) {
				saldo = saldo - monto;
				System.out.println();
			}else {
				System.out.println("Saldo insufiente");
			}
		}
		
	}


	@Override
	public void verInventario() {
		for(Productos prod : super.inventario ) {
			System.out.println("Nombre del producto: "+prod.nombre+ "cantidad: "+prod.cantidad+" y con un valor de: "+prod.precio);
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

	
}
