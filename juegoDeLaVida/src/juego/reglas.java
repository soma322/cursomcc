package juego;

public class reglas {
    private int numFilas;
    private int numColumnas;
    private int numGeneraciones;
    private int organismosIniciales;
    private String[] coordenadas;

    public reglas (int numFilas, int numColumnas, int numGeneraciones,int organismosIniciales){
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numGeneraciones = numGeneraciones;
        this.organismosIniciales = organismosIniciales;
    }

    public void agregarCoordenadas(int index, String coordenada){
        coordenadas[index] = coordenada;
    }
}


