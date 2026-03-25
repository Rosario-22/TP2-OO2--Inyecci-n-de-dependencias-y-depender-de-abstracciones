package oo2.punto1;

public class Participante {
    private static int contador = 0;
    private int id;
    private String nombre;
    private int cantidadDePuntos;

    public Participante(String nombre, int cantidadDePuntos) {
        contador ++; 
        this.id= contador; 
        this.nombre = nombre;
        this.cantidadDePuntos = 0; // Inicializo los puntos en 0 al crear un participante
    }
    public int id(){
        return this.id;
    }
    public String nombre() {
        return nombre;
    }
     public int cantidadDePuntos() {
        return cantidadDePuntos;
    }
    public void ganarPuntos(int puntos) {
        this.cantidadDePuntos += puntos;
    }
}
