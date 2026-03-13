package oo2.punto2;

import java.util.ArrayList;
import java.util.List;

import oo2.punto2.exception.PedidoConfirmadoException;
import oo2.punto2.exception.PedidoVacioException;

public class Pedido {

    private List<ItemPedido> items;
    private boolean confirmado;
    TarjetaCreditoAbstract tarjeta;
    PropinaEnum propina; 

    public Pedido() {
        this.items = new ArrayList<>();
        this.confirmado = false;
    }

    public void agregarItem(ItemPedido item) {
        if (confirmado) {
            throw new PedidoConfirmadoException("No se pueden agregar items a un pedido confirmado");
        }
        items.add(item);
    }

    public void confirmarPedido() {
        if (items.isEmpty()) {
            throw new PedidoVacioException("No se puede confirmar un pedido vacío");
        }
        confirmado = true;
    }

    public double calcularSubtotalBebidas() {
        return items.stream()
                .filter(item -> item.obtenerProducto().esBebida())
                .mapToDouble(ItemPedido::calcularSubtotal)
                .sum();
    }

    public double calcularSubtotalPlatos() {
        return items.stream()
                .filter(item -> item.obtenerProducto().esPlatoPrincipal())
                .mapToDouble(ItemPedido::calcularSubtotal)
                .sum();
    }

    public double calcularTotal() {
        return tarjeta.calcularDescuento(this);
    }

    public void elegirPropina(PropinaEnum propina)  {
        this.propina = propina; 
    }
}