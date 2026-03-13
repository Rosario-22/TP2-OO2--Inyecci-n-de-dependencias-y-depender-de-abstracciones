package oo2.tp1.punto2;

import oo2.tp1.punto2.exception.PrecioInvalidoException;

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
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }

    public boolean esBebida() {
        return false;
    }

    public boolean esPlatoPrincipal() {
        return false; 
    }
}
