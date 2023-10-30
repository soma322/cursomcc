package Buscaminas;

public class Jugador {
        private String nombre;
        private int puntaje;

        public Jugador(String nombre) {
            this.nombre = nombre;
            this.puntaje = 0;
        }
        public Jugador(String nombre, int puntaje) {
            this.nombre = nombre;
            this.puntaje = puntaje;
        }

        public String getNombre() {
            return nombre;
        }

        public void setPuntaje(int puntaje) {
            this.puntaje = puntaje;
        }

        public int getPuntaje() {
            return puntaje;
        }

        public void guardarPuntuacion(){

        }
        public void juegoPerdido(){
            //guardar en json puntuaje en 0
        }

        public void juegoGanado(){
            //guardar en json puntuaje y nombre del jugador
        }
}
