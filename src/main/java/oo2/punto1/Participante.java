package oo2.punto1;

public class Participante {
    private String nombre;
    private int cantidadDePuntos;

    public Participante(String nombre, int cantidadDePuntos) {
        this.nombre = nombre;
        this.cantidadDePuntos = 0; // Inicializo los puntos en 0 al crear un participante
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

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;}
        if ((obj == null) || (getClass() != obj.getClass())){
            return false;}
        Participante other = (Participante) obj;
        return nombre.equals(other.nombre);
    }
}
