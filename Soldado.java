package Lab_5;

public class Soldado {
    private String nombre;
    private int nivelVida;
    private int fila;
    private int columna;
    private String ejercito;  

    public Soldado(String nombre, int nivelVida, int fila, int columna, String ejercito) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.fila = fila;
        this.columna = columna;
        this.ejercito = ejercito;  
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public String getEjercito() {
        return ejercito;
    }

    public void setEjercito(String ejercito) {
        this.ejercito = ejercito;
    }
}
