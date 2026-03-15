package oo2.punto2;
/*Los pagos con tarjeta de crédito Visa tienen un descuento del 3% sobre el costo
total de las bebidas. */

public class Visa extends TarjetaCreditoAbstract {

    private static final double DESCUENTO = 0.03;

    public double calcularDescuento(Pedido pedido) {
        double total = pedido.calcularSubtotalBebidas() + pedido.calcularSubtotalPlatos();
        double des = pedido.calcularSubtotalBebidas() * DESCUENTO;
        return total - des;
    }
}
