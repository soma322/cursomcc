package Buscaminas;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        long tiempoInicio = System.currentTimeMillis();
        Leer scan = new Leer();

        System.out.println("Bienvenido a buscaminas 🚩💣💥");
        Dificultad dificultad = seleccionarDificultad();
        String nombreJugador = scan.leerString("Favor de escribir nombre de jugador");

        Jugador jugador = new Jugador(nombreJugador.toUpperCase());
        Tablero buscaminas = new Tablero(dificultad,tiempoInicio);
        
        jugar(buscaminas, jugador);

    }

    public static void jugar(Tablero buscaminas, Jugador jugador){
        int puntuacion = 0;
        Leer scan = new Leer();
        Json json = new Json();
        System.out.println(buscaminas.toString(true));
        boolean flagJuego = true;
        do {
            System.out.println(buscaminas.toString());
            String movimiento = scan.leerCoordenas("Favor de escribir las coordenas y una opcion valida (B)loquear,(D)esbloquear,(M)ina", buscaminas.getFilas(), buscaminas.getColumas());
            String[] movs = movimiento.split(",");
            flagJuego = buscaminas.jugar(Integer.parseInt(movs[0]), Integer.parseInt(movs[1]), movs[2]);
            
        } while (flagJuego);
        System.out.println("Juego Terminado!!");
        System.out.println(buscaminas.toString(true));
        jugador.setPuntaje(buscaminas.calcularPuntuacion());
        
        if (jugador.getPuntaje() > 0){
           json.guardarPuntuacion(buscaminas.getNivelDificultad(),jugador);
        }else{
            System.out.println("Jugador "+jugador.getNombre()+" exploto!!");
        }
        imprimirPuntajes(buscaminas.getNivelDificultad());

    }

    public static void imprimirPuntajes(int nivel){
        Json jugadores = new Json();
        ArrayList<Jugador> lstJugadores = jugadores.leerPuntaciones(nivel);
        int index = 1;

        System.out.println("Tabla de puntuaciondes: ");
        for (Jugador jugador : lstJugadores) {
            System.out.println(index+".- "+jugador.getNombre() + ": " + jugador.getPuntaje());
            index++;
        }


    }



    public static Dificultad seleccionarDificultad(){
        Leer scan = new Leer();
        Dificultad dificultad = Dificultad.PRINCIPIANTE;
        boolean flagDatos = true;
        do {
            System.out.println("Favor de seleccionar una dificulad:");
            System.out.println("1.- PRINCIPIANTE");
            System.out.println("2.- BASICO");
            System.out.println("3.- MEDIO");
            System.out.println("4.- AVANZADO");
            int n = scan.leerInt();
            switch(n) {
                case 1:
                    dificultad = Dificultad.PRINCIPIANTE;
                    flagDatos = false;
                break;
                case 2:
                    dificultad = Dificultad.BASICO;
                    flagDatos = false;
                break;
                case 3:
                    dificultad = Dificultad.MEDIO;
                    flagDatos = false;
                break;
                case 4:
                    dificultad = Dificultad.AVANZADO;
                    flagDatos = false;
                break;

                default:
                    System.out.println("Favor de seleccionar una opcion valida(numerica)");
                break;
        }
       } while (flagDatos);
       return dificultad;
    }
    
}
