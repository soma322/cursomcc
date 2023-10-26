package Buscaminas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    
}
