package oo2.tp1.punto2;

import oo2.tp1.punto2.exception.CantidadInvalidaException;

public class ItemPedido {
    private ProductoAbstract producto;
    private int cantidad;

    public ItemPedido(ProductoAbstract producto, int cantidad)throws CantidadInvalidaException {
        if (cantidad <= 0) {
            throw new CantidadInvalidaException("La cantidad debe ser mayor a 0");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    public ProductoAbstract obtenerProducto() {
        return producto;
    }

    public int obtenerCantidad() {
        return cantidad;
    }

}
