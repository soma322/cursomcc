package biblioteca;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class json {
	
	public  void guardarJson(String json, String fileName) {
        try {
            java.nio.file.Files.write(java.nio.file.Paths.get(fileName), json.getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
	public  String leerJson(String fileName) {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(fileName));
            return new String(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	public ListaLigada<usuario> leerUsuarios(){
		json json = new json();
		String fileName = "usuarios.json";
	    String jsonString = json.leerJson(fileName);
	    ListaLigada<usuario> listUser = new ListaLigada<usuario>();
	
	    if (jsonString == null) {
	    	
	        String jsonUsuarios = "{\"usuarios\": []}";
	        json.guardarJson(jsonUsuarios, "usuarios.json");
	    	jsonString = json.leerJson(fileName);
	    }
	    JSONObject jsonObject = new JSONObject(jsonString);
	    JSONArray usuarios = jsonObject.getJSONArray("usuarios");

	    for (int i = 0; i < usuarios.length(); i++) {
	        JSONObject personObject = usuarios.getJSONObject(i);
	        listUser.insertar(new usuario(personObject.getString("user"),personObject.getString("pass")));
	        
	    }
	    return listUser;
    }
	
	public ListaLigada<libros> leerLibros(){
		json json = new json();
		String fileName = "libros.json";
	    String jsonString = json.leerJson(fileName);
	    ListaLigada<libros> listLibros = new ListaLigada<libros>();
	
	    if (jsonString == null) {
	    	String jsonLibros = "{\"libros\":[" +
	    		    "{\"usuario\":\"\",\"id\":1,\"nombre\":\"Mecanica del corazon\",\"status\":true}," +
	    		    "{\"usuario\":\"\",\"id\":2,\"nombre\":\"Habitos Atomicos\",\"status\":true}," +
	    		    "{\"usuario\":\"\",\"id\":3,\"nombre\":\"Gente eficiente\",\"status\":true}," +
	    		    "{\"usuario\":\"\",\"id\":4,\"nombre\":\"Metamorfosis\",\"status\":true}," +
	    		    "{\"usuario\":\"\",\"id\":5,\"nombre\":\"Overlord\",\"status\":true}" +
	    		"]}";
	    	json.guardarJson(jsonLibros, "libros.json");
	    	jsonString = json.leerJson(fileName);
	    	
	    }
	    JSONObject jsonObject = new JSONObject(jsonString);
	    JSONArray usuarios = jsonObject.getJSONArray("libros");

	    for (int i = 0; i < usuarios.length(); i++) {
	        JSONObject personObject = usuarios.getJSONObject(i);
	        listLibros.insertar(new libros(personObject.getInt("id"),personObject.getString("nombre"),personObject.getString("usuario"),personObject.getBoolean("status")));
	    }
	    return listLibros;
    }
	
	
	
	public ListaLigada<espera> leerEspera(){
		json json = new json();
		String fileName = "espera.json";
	    String jsonString = json.leerJson(fileName);
	    ListaLigada<espera> listLibros = new ListaLigada<espera>();
	
	    if (jsonString == null) {
	    	String jsonEspera = "{\"listaEspera\":{\"1\":[],\"2\":[],\"3\":[],\"4\":[],\"5\":[]}}";
		    json.guardarJson(jsonEspera, "espera.json");
	    	jsonString = json.leerJson(fileName);
	    }
	    
	    
	    JSONObject jsonObject = new JSONObject(jsonString);
	    JSONObject espera = jsonObject.getJSONObject("listaEspera");
	    
	    
	    for (String key : espera.keySet()) {
	        JSONArray esperaArray = espera.getJSONArray(key); 

	        for (int i = 0; i < esperaArray.length(); i++) {
	            JSONObject libroObject = esperaArray.getJSONObject(i);
	            int idLibro = libroObject.getInt("idLibro");
	            String nombreLibro = libroObject.getString("nombreLibro");
	            String usuario = libroObject.getString("usuario");
	            listLibros.insertar(new espera(idLibro, nombreLibro, usuario));
	        }
	    }
	  
	    return listLibros;
    }
    
}
