package juego;

public class Reglas {
    private int numFilas;
    private int numColumnas;
    private int numGeneraciones;
    private int organismosIniciales;
    private String[] coordenadas;

    public Reglas (int numFilas, int numColumnas, int numGeneraciones,int organismosIniciales){
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numGeneraciones = numGeneraciones;
        this.organismosIniciales = organismosIniciales;
        this.coordenadas = new String[(numFilas*numColumnas)];
        
    }

    public void agregarCoordenadas(int index, String coordenada){
        coordenadas[index] = coordenada;
    }

    public int totalVivos(){
        int totalVivos = Math.round(((float)this.organismosIniciales / 100) * (this.numFilas*this.numColumnas));
        return totalVivos;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    }

    
    public int getNumFilas(){
        return this.numFilas;
    }
    public int getNumColumnas(){
        return this.numColumnas;
    }
    public int getNumGeneraciones(){
        return numGeneraciones;
    }
    public int getOrganismosIniciales(){
        return organismosIniciales;
    }
    public String[] getCoordenadas(){
        return coordenadas;
    }

}


