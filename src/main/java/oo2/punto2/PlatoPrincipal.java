package oo2.punto2;

public class PlatoPrincipal extends Producto {
      
    public PlatoPrincipal(String nombre, double precio){
        super(nombre, precio);

    }

    @Override
    public double calcularSubtotalBebida(int cantidad) {
        return 0;
    }

    @Override
    public double calcularSubtotalPlato(int cantidad) {
        return obtenerPrecio() * cantidad; 
    }

   
}
