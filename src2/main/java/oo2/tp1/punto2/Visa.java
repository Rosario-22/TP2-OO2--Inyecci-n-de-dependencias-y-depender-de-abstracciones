package oo2.tp1.punto2;
/*Los pagos con tarjeta de crédito Visa tienen un descuento del 3% sobre el costo
total de las bebidas. */
public class Visa extends TarjetaCreditoAbstract {
    public double calcularDescuento(Pedido pedido) {
        return pedido.calcularSubtotalBebidas() * 0.03;
    }
}
