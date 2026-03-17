package oo2.punto2;
import oo2.punto2.exception.CantidadInvalidaException;

public class ItemPedido {

    private Producto producto;
    private int cantidad;

    public ItemPedido(Producto producto, int cantidad){
        if (cantidad <= 0) {
            throw new CantidadInvalidaException("La cantidad debe ser mayor a 0");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return producto.obtenerPrecio() * cantidad;
    }

    public double calcularSubtotalBebidas() {
        return producto.calcularSubtotalBebida(cantidad);
    }

    public double calcularSubtotalPlatos() {
        return producto.calcularSubtotalPlato(cantidad);
    }
}