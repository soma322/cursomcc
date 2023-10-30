package Buscaminas;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONObject;
public class Json {
	
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

    public void guardarPuntuacion(int nivel, Jugador jugador){
        boolean flagJugador = false;
        Json json = new Json();
        String fileName = "jugadores.json";
        String jsonString = json.leerJson(fileName);
        JSONObject nuevo = new JSONObject();


        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray usuarios = jsonObject.optJSONArray(String.valueOf(nivel));
        

        
        if (usuarios == null) {
            usuarios = new JSONArray();
            jsonObject.put(String.valueOf(nivel), usuarios);
        }

        // checar si el usuario ya existe
        for (int i = 0; i < usuarios.length(); i++) {
            JSONObject jugadorObj = usuarios.getJSONObject(i);
            if (jugadorObj.getString("nombre").equals(jugador.getNombre())) {
                jugadorObj.put("nombre", jugador.getNombre());
                jugadorObj.put("puntuacion", jugador.getPuntaje());
                //usuarios.put(nuevo);
                flagJugador = true;
                break;
            }
        }
        // si no existe guarda nuevo
        if (!flagJugador) {
            JSONObject nuevoJugador = new JSONObject();
            nuevoJugador.put("nombre", jugador.getNombre());
            nuevoJugador.put("puntuacion", jugador.getPuntaje());
            usuarios.put(nuevoJugador);
        }


        //guardar json
        String nuevoJson = jsonObject.toString(4);
        json.guardarJson(nuevoJson,fileName);
    }

    public ArrayList<Jugador> leerPuntaciones(int nivel){
        ArrayList<Jugador> lista = new ArrayList<>();
        Json json = new Json();
		String fileName = "jugadores.json";
	    String jsonString = json.leerJson(fileName);

        JSONObject jsonObject = new JSONObject(jsonString);
	    //JSONObject niveles = jsonObject.getJSONObject(String.valueOf(nivel));
        JSONArray usuarios = jsonObject.getJSONArray(String.valueOf(nivel));
        for (int i = 0; i < usuarios.length(); i++) {
            JSONObject jugadorObj = usuarios.getJSONObject(i);
            lista.add(new Jugador(jugadorObj.getString("nombre"), jugadorObj.getInt("puntuacion")));

        }
        Comparator<Jugador> byScoreDescending = (jugador1, jugador2) ->Integer.compare(jugador2.getPuntaje(), jugador1.getPuntaje());
        Collections.sort(lista, byScoreDescending);

        return lista;


    }

    
}
