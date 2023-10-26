package Buscaminas;

public class Main {
    public static void main(String[] args) {
        Tablero buscaminas = new Tablero(Dificultad.PRINCIPIANTE);
        
        buscaminas.abrirCelda(1,1);
        System.out.println(buscaminas.toString());
       // System.out.println(buscaminas.contarBombasVecinas(1,1,buscaminas.getVisitadas()));
    }
    
}
