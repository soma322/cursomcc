package POO;

import POO.CuentaBancaria;
import POO.Estudiante;
import POO.Rectangulo;
import POO.Empleado;
import POO.Cilindro;
import java.util.*;

public class poo {

	public static void main(String[] args) {
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		String cad;
		boolean numerico = true;
		do {
			System.out.println("Programacion POO!!");
			System.out.println("Seleccione una opcion del menu: ");
			System.out.println("1) Ejercicio 1 - Cuenta Bancaria");
			System.out.println("2) Ejercicio 2 - Estudiante");
			System.out.println("3) Ejercicio 3 - Rectangulo");
			System.out.println("4) Ejercicio 4 - Empleado");
			System.out.println("5) Ejercicio 5 - Cilindro");
			System.out.print("Escriba un numero de la lista: ");
			cad = sc.nextLine();
			numerico = esNumerico(cad);
			if (numerico) {
				menu = Integer.parseInt(cad);
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
			if (menu > 5 || menu < 1) {
				System.out.println("Favor de seleccionar un numero entre 1 y 5");
				System.out.println("");
				continue;
			}
			
		}while(menu > 5 || menu < 1 || !numerico);
		
		switch(menu) {
			case 1:
				cuentaBancaria();
				break;
			case 2:
				estudiante();
				break;
			case 3:
				rectangulo();
				break;
			case 4:
				empleado();
				break;
			case 5:
				cilindro();
				break;
		}

	}

public static void cilindro() {
		
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		String cad,radio,altura;
		boolean numerico = true;
		
		do {
			System.out.println("Cilindro");
			System.out.println("Seleccione una opcion del menu: ");
			System.out.println("1) Volumen de cilindro");
			System.out.println("2) Terminar");
			System.out.print("Escriba un numero de la lista: ");
			cad = sc.nextLine();
			numerico = esNumerico(cad);
			if (numerico) {
				menu = Integer.parseInt(cad);
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
			if (menu > 2 || menu < 1) {
				System.out.println("Favor de seleccionar una opcion");
				System.out.println("");
				continue;
			}
			
			switch(menu) {
				case 1:
					System.out.print("Favor de escribir el radio del cilindro: ");
					radio = sc.nextLine();
					System.out.print("Favor de escribir la altura del cilindro: ");
					altura = sc.nextLine();
					
					Cilindro objCilindro = new Cilindro(Double.parseDouble(radio),Double.parseDouble(altura));
					
					System.out.println("");
					System.out.println("Volumen del cilindro: "+objCilindro.volumen() );
					
					
					break;
				
				
				
			}
			
		}while(menu != 2 || !numerico);
		

	}
	

public static void empleado() {
		
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		String cad,nombre,edad,sexo,puesto;
		boolean numerico = true;
		
		do {
			System.out.println("Empleados");
			System.out.println("Seleccione una opcion del menu: ");
			System.out.println("1) Nuevo empleado");
			System.out.println("2) Terminar");
			System.out.print("Escriba un numero de la lista: ");
			cad = sc.nextLine();
			numerico = esNumerico(cad);
			if (numerico) {
				menu = Integer.parseInt(cad);
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
			if (menu > 2 || menu < 1) {
				System.out.println("Favor de seleccionar una opcion");
				System.out.println("");
				continue;
			}
			
			switch(menu) {
				case 1:
					System.out.print("Favor de escribir el nombre del empleado: ");
					nombre = sc.nextLine();
					System.out.print("Favor de escribir la edad del empleado: ");
					edad = sc.nextLine();
					System.out.print("Favor de escribir la sexo del empleado: ");
					sexo = sc.nextLine();
					System.out.print("Favor de escribir la puesto del empleado: ");
					puesto = sc.nextLine();
					
					Empleado objEmpleado = new Empleado(nombre,Integer.parseInt(edad),sexo,puesto);
					
					System.out.println("");
					System.out.println("Nombre del empleado: "+objEmpleado.getnombre() );
					System.out.println("Nombre del edad: "+objEmpleado.getEdad() );
					System.out.println("Nombre del sexo: "+objEmpleado.getSexo() );
					System.out.println("Nombre del puesto: "+objEmpleado.getPuesto() );
					
					break;
				
				
				
			}
			
		}while(menu != 2 || !numerico);
		

	}


public static void rectangulo() {
		
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		String cad,base,altura;
		boolean numerico = true;
		Rectangulo objRectangulo = new Rectangulo();
		do {
			System.out.println("Rectangulo");
			System.out.println("Seleccione una opcion del menu: ");
			System.out.println("1) Calcular perimetro");
			System.out.println("2) Calcular area");
			System.out.println("3) Terminar");
			System.out.print("Escriba un numero de la lista: ");
			cad = sc.nextLine();
			numerico = esNumerico(cad);
			if (numerico) {
				menu = Integer.parseInt(cad);
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
			if (menu > 3 || menu < 1) {
				System.out.println("Favor de seleccionar una opcion");
				System.out.println("");
				continue;
			}
			
			switch(menu) {
				case 1:
					System.out.print("Favor de escribir la base del rectangulo ");
					base = sc.nextLine();
					objRectangulo.setBase(Integer.parseInt(base));
					System.out.print("Favor de escribir la altura del rectangulo");
					altura = sc.nextLine();
					objRectangulo.setAltura(Integer.parseInt(altura));
					
					int perimetro = (objRectangulo.getBase()*2) + (objRectangulo.getAltura()*2);
					System.out.println("El perimetro del rectangulo es: "+ perimetro);
					
					break;
				case 2:
					System.out.print("Favor de escribir la base del rectangulo ");
					base = sc.nextLine();
					objRectangulo.setBase(Integer.parseInt(base));
					System.out.print("Favor de escribir la altura del rectangulo");
					altura = sc.nextLine();
					objRectangulo.setAltura(Integer.parseInt(altura));
					
					int area = objRectangulo.getBase() * objRectangulo.getAltura();
					System.out.println("El area del rectangulo es: " + area);
					
					break;
				
				
			}
			
		}while(menu != 3 || !numerico);
		

	}
public static void estudiante() {
		
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		String cad,nombre,edad,carrera;
		boolean numerico = true;
		Estudiante objEstudiante = new Estudiante();
		do {
			System.out.println("Estudiantes");
			System.out.println("Seleccione una opcion del menu: ");
			System.out.println("1) Alta estudiante");
			System.out.println("2) informacion del estudiante");
			System.out.println("3) Terminar");
			System.out.print("Escriba un numero de la lista: ");
			cad = sc.nextLine();
			numerico = esNumerico(cad);
			if (numerico) {
				menu = Integer.parseInt(cad);
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
			if (menu > 3 || menu < 1) {
				System.out.println("Favor de seleccionar una opcion");
				System.out.println("");
				continue;
			}
			
			switch(menu) {
				case 1:
					System.out.print("Favor de escribir el nombre del estudiante: ");
					nombre = sc.nextLine();
					System.out.println("Favor de escribir la edad del estudiante");
					edad = sc.nextLine();
					System.out.println("Favor de escribir la carrera del estudiante");
					carrera = sc.nextLine();
					objEstudiante.altaEstudiante(nombre,Integer.parseInt(edad),carrera);
					break;
				case 2:
					if(objEstudiante.obtenerNombre() != "") {
						System.out.println("Informacion del estudiante: ");
						System.out.println("Nombre: "+objEstudiante.obtenerNombre());
						System.out.println("Edad: "+objEstudiante.obtenerEdad());
						System.out.println("Carrera: "+objEstudiante.obtenerCarrera());
					}else {
						System.out.println("Favor de capturar un estudiante");
					}
					break;
				
				
			}
			
		}while(menu != 3 || !numerico);
		

	}
	public static void cuentaBancaria() {
		
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		String cad;
		boolean numerico = true;
		CuentaBancaria objBanco = new CuentaBancaria();
		do {
			System.out.println("Cuenta Bancaria");
			System.out.println("Seleccione una opcion del menu: ");
			System.out.println("1) Alta cliente");
			System.out.println("2) Deposito");
			System.out.println("3) Retiro");
			System.out.println("4) Consulta Saldo");
			System.out.println("5) Consulta Cliente");
			System.out.println("6) Terminar");
			System.out.print("Escriba un numero de la lista: ");
			cad = sc.nextLine();
			numerico = esNumerico(cad);
			if (numerico) {
				menu = Integer.parseInt(cad);
			}else {
				System.out.println("Favor de escribir solo numeros!!");
				System.out.println("");
				continue;
			}
			
			if (menu > 6 || menu < 1) {
				System.out.println("Favor de seleccionar un numero entre 1 y 4");
				System.out.println("");
				continue;
			}
			
			switch(menu) {
				case 1:
					System.out.print("Favor de escribir el nombre de cliente: ");
					cad = sc.nextLine();
					objBanco.altaCliente(cad);
					break;
				case 2:
					System.out.print("Favor de escribir la cantidad a depositar: ");
					cad = sc.nextLine();
					numerico = esNumerico(cad);
					if (numerico) {
						objBanco.deposito(Integer.parseInt(cad));
					}else {
						System.out.println("Favor de escribir solo numeros!!");
						System.out.println("");
						
					}
					break;
				case 3:
					System.out.print("Favor de escribir la cantidad a retirar: ");
					cad = sc.nextLine();
					numerico = esNumerico(cad);
					if (numerico) {
						objBanco.retiro(Integer.parseInt(cad));
					}else {
						System.out.println("Favor de escribir solo numeros!!");
						System.out.println("");
					}
					break;
				case 4:
					System.out.println("Su saldo es: "+objBanco.obtenerSaldo());
					break;
				case 5:
					System.out.println("El nombre del cliente es: "+objBanco.obtenerCliente());
					break;
				
			}
			
		}while(menu != 6 || !numerico);
		

	}
	
	public static boolean esNumerico(String cad) {
		if (cad == null) {
			return false;
		}
		try {
			int numero = Integer.parseInt(cad); 
		}catch (NumberFormatException x) {
			return false;
		}
		return true;
	}

}
