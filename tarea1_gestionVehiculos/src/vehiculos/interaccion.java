package vehiculos;
import java.util.ArrayList;
import java.util.Scanner;
public class interaccion {

	public static void main(String[] args) {
		
		ArrayList<vehiculo> listVehiculos = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		String marca,modelo,tipoCombustible,tipoChasis = "";
		int numeroPuertas,cilindrada;
		boolean flagTerminar = true;
		
		do {
			System.out.println("Bienvenido a la gestion de vehiculos");
			System.out.println("Que operacion deseas realizar?");
			System.out.println("1.- Registrar Carro");
			System.out.println("2.- Registrar Moto");
			System.out.println("3.- Consultar vehiculos registrados");
			System.out.println("4.- Terminar");
			int n = scan.nextInt();
			switch(n) {
			case 1:
				System.out.println("Favor de escribir la marca");
				scan.nextLine();
				marca = scan.nextLine();
				if(!soloLetras(marca)) {
					break;
				}
				
				System.out.println("Favor de escribir el modelo");
				modelo = scan.nextLine();
				
				
				
				try {
					System.out.println("Favor de escribir el numero de puertas: ");
					numeroPuertas = scan.nextInt();
					scan.nextLine();
				}catch(NumberFormatException x) {
					System.out.println("Escribir solo numeros");
					break;
				}
				
				
				System.out.println("Favor de escribir el tipo de Combustible");
				tipoCombustible = scan.nextLine();
				if(!soloLetras(tipoCombustible)) {
					break;
				}
				
				
				
				vehiculo mo1 = new Coche(marca,modelo,numeroPuertas,tipoCombustible);
				listVehiculos.add(mo1);
				break;
			case 2:
				System.out.println("Favor de escribir la marca");
				scan.nextLine();
				marca = scan.nextLine();
				if(!soloLetras(marca)) {
					break;
				}
				
				System.out.println("Favor de escribir el modelo");
				modelo = scan.nextLine();
				
				
				
				try {
					System.out.println("Favor de escribir el numero de cilindros: ");
					cilindrada = scan.nextInt();
					scan.nextLine();
				}catch(NumberFormatException x) {
					System.out.println("Escribir solo numeros");
					break;
				}
				
				
				System.out.println("Favor de escribir el tipo de chasis");
				tipoChasis = scan.nextLine();
				if(!soloLetras(tipoChasis)) {
					break;
				}
				
				
				
				vehiculo moto = new Moto(marca,modelo,cilindrada,tipoChasis);
				listVehiculos.add(moto);
				break;
			case 3:
				if(listVehiculos.size() != 0) {
					for(vehiculo carro : listVehiculos ) {
						carro.mostrarInformación();
					}
				}else {
					System.out.println("Favor de registrar un vehiculo!");
				}
				break;
			case 4:
				System.out.println("Adios!");
				flagTerminar = false;
				break;
			default:
				System.out.println("No ingresaste un numero correctamente");
				break;
			}
		}while(flagTerminar);
		
		
	}
	public static boolean soloLetras(String str) {
        // Use regular expression to check if the string contains only alphabetic characters
		if(str.matches("[a-zA-Z]+")) {
			return true;
		}else {
			System.out.println("Favor de escribir solo letras");
			return false;
		}
        
    }

}
