package oo2.tp1.punto2;

public class Bebida extends ProductoAbstract {
    private double cantidadLitros; 
    
    public Bebida(String nombre, double precio, double cantidadLitros) {
        super(nombre, precio);
        this.cantidadLitros = cantidadLitros;
    }

    public double obtenerCantidadDeLitros() {
        return cantidadLitros;
    }

    @Override
    public boolean esBebida() {
        return true; 
    }
}
