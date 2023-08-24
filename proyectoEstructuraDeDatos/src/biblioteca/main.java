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
		usuario datos = new usuario("","");
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
				usuario user = inicioSesion();
				if(listUser.buscarElemento(user)) {
					datos = listUser.obtenerValor(user);
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
				break;
			default:
				System.out.println("Favor de seleccionar una opcion");
				break;
			}
		}while(flagTerminar);
		
		if(flagContinuar) {
			menuBiblioteca(datos);
		}
		
        
	}
	public static void menuBiblioteca(usuario datos) {
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
				rentarLibro(datos);
				break;
			case 3:
				devolverLibro(datos);
				break;
			case 4:
				revisarListaEspera();
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
	
	public static void devolverLibro(usuario usuario) {
		Scanner scan = new Scanner(System.in);
		boolean flagContinuar = true;
		json jsnLibros = new json();
		boolean flagTieneLibros = false;
		int contador = 0;
		ListaLigada<libros> lstLibros  = jsnLibros.leerLibros();
		ListaLigada<espera> lstEspera  = jsnLibros.leerEspera();
		
		do {
			
			flagTieneLibros = lstLibros.buscarElemento(new libros(0,null,usuario.usuario,false));
			
			
			if(flagTieneLibros) {
				libros valorLibro = lstLibros.obtenerValor(new libros(0,null,usuario.usuario,false));
				String jsonString = jsnLibros.leerJson("libros.json");
		        JSONObject jsonObject = new JSONObject(jsonString);
				JSONArray librosArray = jsonObject.getJSONArray("libros");


		        for (int i = 0; i < librosArray.length(); i++) {
		            JSONObject libro = librosArray.getJSONObject(i);
		            if (libro.getInt("id") == valorLibro.id) {
		                libro.put("usuario", "");
		                libro.put("status", true);
		                break;
		            }
		        }
		        System.out.println(usuario.usuario+" devolvio el libro "+valorLibro.nombreLibro);
		        jsnLibros.guardarJson(jsonObject.toString(4), "libros.json");
		        
		        lstLibros  = jsnLibros.leerLibros();
				lstEspera  = jsnLibros.leerEspera();
			}else {
				System.out.println(usuario.usuario+" devolvio todos su libros o no tiene libros para devolver");
			}
		}while(flagTieneLibros);
		
	}
	
	public static void rentarLibro(usuario usuario) {
		Scanner scan = new Scanner(System.in);
		boolean flagContinuar = true;
		json jsnLibros = new json();
		
		ListaLigada<libros> lstLibros  = jsnLibros.leerLibros();
		ListaLigada<espera> lstEspera  = jsnLibros.leerEspera();
		lstLibros.imprimeLista();
		System.out.println("¿Que libro desea rentar?");
		do{
			System.out.print("Escribe el numero del libro: ");
			int id = scan.nextInt();
			if(lstLibros.buscarElemento(new libros(id,null,null,false))) {
				libros Nlibros =  lstLibros.obtenerValor(new libros(id,null,null,false));
				if(Nlibros.status) {
					prestarLibroUsuario(id, usuario);
				}else {
					listaEspera(id, usuario);
				}
				flagContinuar = false;
			}else {
				System.out.println("Favor de seleccionar un libro de la lista");
			}
			

		}while(flagContinuar);
		
		
	}
	
	public static void listaEspera(int id, usuario user) {
		json jsnLibros = new json();
		
		String jsonString = jsnLibros.leerJson("libros.json");
		String jsonEsperaString = jsnLibros.leerJson("espera.json");
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject esperaObject = new JSONObject(jsonEsperaString);
		JSONArray librosArray = jsonObject.getJSONArray("libros");
		
		

		ListaLigada<libros> lstLibros  = jsnLibros.leerLibros();
		ListaLigada<espera> lstEspera  = jsnLibros.leerEspera();
		
		libros valorLibro = lstLibros.obtenerValor(new libros(id,null,null,false));
	
		if(valorLibro.usuario.equals(user.usuario) ) {
			System.out.println(user.usuario+" tiene asignado el libro, favor de devolverlo");
			return;
		}
		
		

		
		if(!lstEspera.buscarElemento(new espera(id,null,user.usuario))){
			JSONObject esperaListaEspera = esperaObject.getJSONObject("listaEspera");
			String Sid = ""+id;
			JSONArray esperaARRay = esperaListaEspera.getJSONArray(Sid);

			libros libro = lstLibros.obtenerValor(new libros(id,null,null,false));
			JSONObject nuevo = new JSONObject();
			
            nuevo.put("idLibro", id);
            nuevo.put("nombreLibro", libro.nombreLibro);
            nuevo.put("usuario", user.usuario);
            esperaARRay.put(nuevo);
            
            jsnLibros.guardarJson(esperaObject.toString(4),"espera.json");
            System.out.println(user.usuario+ " se agrego a la lista de espera exitosamente");
			
			
		}else {
			System.out.println("Usuario ya existe en la lista de espera");
		}
		
		
		
	}
	public static void prestarLibroUsuario(int idLibro, usuario user) {
		json jsnLibros = new json();
		//ListaLigada<libros> lstLibros  = jsnLibros.leerLibros();
		String jsonString = jsnLibros.leerJson("libros.json");
        JSONObject jsonObject = new JSONObject(jsonString);
        
        String jsonStringEspera = jsnLibros.leerJson("espera.json");
        JSONObject jsonObjectEspera = new JSONObject(jsonStringEspera);
        
        
        
		JSONArray librosArray = jsonObject.getJSONArray("libros");
		ListaLigada<espera> lstEspera  = jsnLibros.leerEspera();
		ListaLigada<libros> lstLibros  = jsnLibros.leerLibros();
		
		espera valorEspera = lstEspera.obtenerCabeza();
		
		
		espera cabezalista = lstEspera.obtenerCabeza();
		
			JSONObject esperaListaEspera = jsonObjectEspera.getJSONObject("listaEspera");
			String Sid = ""+idLibro;
			JSONArray esperaARRay = esperaListaEspera.getJSONArray(Sid);
            
			if(esperaARRay.length() > 0) {
				
	                JSONObject userObject = esperaARRay.getJSONObject(0);
	                
	                if (userObject.getString("usuario").equals(user.usuario) ) {
	                	esperaARRay.remove(0);
	                    
	                }else {
	                	System.out.println(user.usuario+" no es el primero en la lista");
	                	return;
	                	
	                }
	            
				
				jsnLibros.guardarJson(jsonObjectEspera.toString(4),"espera.json");
				
				
				 for (int i = 0; i < librosArray.length(); i++) {
			            JSONObject libro = librosArray.getJSONObject(i);
			            if (libro.getInt("id") == idLibro) {
			                libro.put("usuario", user.usuario);
			                libro.put("status", false);
			                break;
			            }
			        }
			        jsnLibros.guardarJson(jsonObject.toString(4), "libros.json");
				return;
			}else {
				  for (int i = 0; i < librosArray.length(); i++) {
			            JSONObject libro = librosArray.getJSONObject(i);
			            if (libro.getInt("id") == idLibro) {
			                libro.put("usuario", user.usuario);
			                libro.put("status", false);
			                break;
			            }
			        }
			        jsnLibros.guardarJson(jsonObject.toString(4), "libros.json");
			}
			
            

             // 
			
		
		
      
        
	}
	
	public static void revisarListaEspera() {
		json jsnEspera = new json();
		ListaLigada<espera> lstEspera  = jsnEspera.leerEspera();
		lstEspera.imprimeLista();
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
            
            json.guardarJson(jsonObject.toString(4),fileName);
            System.out.println("Creacion de usuario exitoso");
            return true;
        }
        
		
	}
	
	

}
