package oo2.tp1.punto2;
import oo2.tp1.punto2.exception.PrecioInvalidoException;

public class Bebida extends ProductoAbstract {
    private double cantidadLitros; 
    
    public Bebida(String nombre, double precio, double cantidadLitros) throws PrecioInvalidoException {
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
