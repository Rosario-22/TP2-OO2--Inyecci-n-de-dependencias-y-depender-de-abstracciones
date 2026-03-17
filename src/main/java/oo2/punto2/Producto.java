package oo2.punto2;

import oo2.punto2.exception.PrecioInvalidoException;

public abstract class Producto {
    private String nombre;
    private double precio;
    
    public Producto(String nombre, double precio) {
        if (precio <= 0) {
            throw new PrecioInvalidoException("El precio debe ser mayor a 0");
        }
        this.nombre = nombre;
        this.precio = precio;
    }
    double obtenerPrecio() {
        return precio;
    }
    public abstract double calcularSubtotalBebida(int cantidad);

    public abstract double calcularSubtotalPlato(int cantidad);
}
