package Buscaminas;

public class Jugador {
        private String nombre;
        private int puntaje;

        public Jugador(String nombre) {
            this.nombre = nombre;
            this.puntaje = 0;
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

        public void juegoPerdido(){
            //guardar en json puntuaje en 0
        }

        public void juegoGanado(){
            //guardar en json puntuaje y nombre del jugador
        }
}
