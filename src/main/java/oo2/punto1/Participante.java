package oo2.punto1;

public class Participante {
    private String nombre;
    private int cantidadDePuntos;
    public Participante(String nombre, int cantidadDePuntos) {
        this.nombre = nombre;
        this.cantidadDePuntos = cantidadDePuntos;
    }

    public String getNombre() {
        return nombre;
    }
     public int getCantidadDePuntos() {
        return cantidadDePuntos;
    }
    public void ganarPuntos(int puntos) {
        this.cantidadDePuntos += puntos;
    }
}
