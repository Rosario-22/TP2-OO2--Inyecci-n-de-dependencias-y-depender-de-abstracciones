package oo2.punto2;
/*Los pagos con tarjeta de crédito Mastercard tienen un 2% de descuento sobre
el costo total de los platos principales */
public class MasterCard extends TarjetaCreditoAbstract {
   
    private static final double DESCUENTO = 0.02;

    public double calcularDescuento(Pedido pedido) {
        double total = pedido.calcularSubtotalBebidas() + pedido.calcularSubtotalPlatos();
        double des= pedido.calcularSubtotalPlatos() * DESCUENTO;
        return total - des;
    }
}
