package oo2.punto2;

public class Bebida extends Producto {
    
    public Bebida(String nombre, double precio, double cantidadLitros) {
        super(nombre, precio);
    }

    @Override
    public double calcularSubtotalBebida(int cantidad) {
       return obtenerPrecio()* cantidad; 
    }

    @Override
    public double calcularSubtotalPlato(int cantidad) {
        return 0; 
    }

    

}
