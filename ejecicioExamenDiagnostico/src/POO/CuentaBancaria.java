package POO;

public class CuentaBancaria {
	private int saldo;
	private String cliente;
	
	
	public CuentaBancaria() {
		cliente = "";
		saldo = 0;
	}
	public void altaCliente(String nuevoCliente) {
		cliente = nuevoCliente;
	}
	
	public void deposito(int nuevoDeposito) {
		saldo = saldo + nuevoDeposito;
	}
	public void retiro(int nuevoRetiro) {
		saldo = saldo - nuevoRetiro;
	}
	
	public String obtenerCliente() {
		return cliente;
	}
	
	public int obtenerSaldo() {
		return saldo;
	}
}
