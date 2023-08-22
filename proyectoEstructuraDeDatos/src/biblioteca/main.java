package biblioteca;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import biblioteca.json;
import biblioteca.ListaLigada;



public class main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int tipoTienda = 0;
		boolean flagTerminar = true;
		boolean flagContinuar = false;
		do {
			System.out.println("Bienvenido a la biblioteca");
			System.out.println("Que operacion deseas realizar?");
			System.out.println("1.- Iniciar sesion");
			System.out.println("2.- Registrar usuario");
			System.out.println("2.- Terminar");
			int n = scan.nextInt();
			switch(n) {
			case 1:
				json listUsuarios = new json();
				ListaLigada<usuario> listUser = listUsuarios.leerUsuarios();
				if(listUser.buscarElemento(inicioSesion())) {
					flagTerminar = false;
					flagContinuar = true;
				}else {
					System.out.println("Usuario incorrecto/no existe");
				}
				break;
			case 2:
				if(!crearUsuario()) 
					System.out.println("Usuario ya existe");
				break;
			case 3:
				System.out.println("Vuelva pronto!");
				
				flagTerminar = false;
			default:
				System.out.println("Favor de seleccionar una opcion");
				break;
			}
		}while(flagTerminar);
		
		if(flagContinuar) {
			menuBiblioteca();
		}
		/*
		 *  String jsonString = "{\"name\":\"John\",\"age\":30,\"isStudent\":false,\"hobbies\":[\"Reading\",\"Swimming\",\"Painting\"]}";

	        JSONObject jsonObject = new JSONObject(jsonString);

	        String name = jsonObject.getString("name");
	        int age = jsonObject.getInt("age");
	        boolean isStudent = jsonObject.getBoolean("isStudent");
	        JSONArray hobbies = jsonObject.getJSONArray("hobbies");

	        System.out.println("Name: " + name);
	        System.out.println("Age: " + age);
	        System.out.println("Is Student: " + isStudent);
	        System.out.println("Hobbies: " + hobbies.toString());
	        
	        String jsonString_ = jsonObject.toString();
	        saveJSONToFile(jsonString_, "output.json");
	        */
		
       // listUser.imprimeLista();
       // usuario busqueda = new usuario ("soma2","123");
       // listUser.buscarElemento(new usuario ("soma2","123"));
        
        /*String name = jsonObject.getString("name");
         * 
         * 
        int age = jsonObject.getInt("age");
        boolean isStudent = jsonObject.getBoolean("isStudent");
        JSONArray hobbies = jsonObject.getJSONArray("hobbies");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Is Student: " + isStudent);
        System.out.println("Hobbies: " + hobbies.toString());*/
        
	}
	public static void menuBiblioteca() {
		Scanner scan = new Scanner(System.in);
		int tipoTienda = 0;
		boolean flagTerminar = true;
		boolean flagContinuar = false;
		do {
			System.out.println("Menu biblioteca");
			System.out.println("Que operacion deseas realizar?");
			System.out.println("1.- Lista de libro");
			System.out.println("2.- Rentar libro");
			System.out.println("3.- Devolver libro");
			System.out.println("4.- Checar lista de espera");
			System.out.println("5.- Terminar");
			int n = scan.nextInt();
			switch(n) {
			case 1:
				revisarLibros();
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				break;
			case 5:
				System.out.println("Vuelva pronto!");
				flagTerminar = false;
				break;
			default:
				System.out.println("Favor de seleccionar una opcion");
				break;
			}
		}while(flagTerminar);
	}
	
	public static void revisarLibros() {
		json jsnLibros = new json();
		ListaLigada<libros> lstLibros  = jsnLibros.leerLibros();
		lstLibros.imprimeLista();
	}
	
	public static usuario inicioSesion() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Usuario:");
		String usuario = scan.nextLine();
		
		System.out.println("Contrasena: ");
		String contra = scan.nextLine();
		
        return (new usuario(usuario, contra));
		
	}
	
	public static boolean crearUsuario() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Usuario:");
		String usuario = scan.nextLine();
		
		System.out.println("Contrasena: ");
		String contra = scan.nextLine();
		
		json json = new json();
		json listUsuarios = new json();
		
		String fileName = "usuarios.json";
        String jsonString = json.leerJson(fileName);
		

        ListaLigada<usuario> listUser = listUsuarios.leerUsuarios();
        if (listUser.buscarElemento(new usuario(usuario, null))) {
        	return false;
        }else {
        	JSONObject jsonObject = new JSONObject(jsonString);
            
            JSONArray usuariosArray = jsonObject.getJSONArray("usuarios");
            
            JSONObject nuevo = new JSONObject();
            nuevo.put("user", usuario);
            nuevo.put("pass", contra);
            usuariosArray.put(nuevo);
            //
            
            json.guardarJson(jsonObject.toString(),fileName);
            System.out.println("Creacion de usuario exitoso");
            return true;
        }
        
		
	}
	
	

}
