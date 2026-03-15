package oo2.punto2;

import oo2.punto2.exception.PrecioInvalidoException;

public abstract class ProductoAbstract {
    private String nombre;
    private double precio;
    
    public ProductoAbstract(String nombre, double precio) {
        if (precio <= 0) {
            throw new PrecioInvalidoException("El precio debe ser mayor a 0");
        }
        this.nombre = nombre;
        this.precio = precio;
    }
    
    private String obtenerNombre() {
        return nombre;
    }
    
    private double obtenerPrecio() {
        return precio;
    }

    public boolean esBebida() {
        return false;
    }

    public boolean esPlatoPrincipal() {
        return false; 
    }
}
