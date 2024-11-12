package Lab_5;

public class Soldado {
    private String nombre;
    private int nivelVida;
    public int fila;
    public int columna;
    
    public Soldado(String nombre, int nivelVida, int fila, int columna) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.columna=columna;
        this.fila= fila;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelVida() {
        return nivelVida;
    }
    public int getfila() {
    	return fila;
    }
    public int getcolumna() {
    	return columna;
    }
    public String toString() {
        return nombre + " (Vida: " + nivelVida + ", Posición: (" + fila + ", " + columna + "))";
    }
}