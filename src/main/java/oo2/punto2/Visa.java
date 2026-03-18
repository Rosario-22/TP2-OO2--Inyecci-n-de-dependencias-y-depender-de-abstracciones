package oo2.punto2;
/*Los pagos con tarjeta de crédito Visa tienen un descuento del 3% sobre el costo
total de las bebidas. */

public class Visa extends TarjetaCredito {

    private static final double DESCUENTO = 0.03;

    @Override
    public double calcularDescuento(Pedido pedido, double totalConPropina) {
        double descuento = pedido.calcularSubtotalBebidas() * DESCUENTO;
        return totalConPropina - descuento;
    }
}

