package oo2.tp1.punto2;
/*Los pagos con tarjeta de crédito Mastercard tienen un 2% de descuento sobre
el costo total de los platos principales */
public class MasterCard extends TarjetaCreditoAbstract {
   
    public double calcularDescuento(Pedido pedido) {
        return pedido.calcularSubtotalPlatos() * 0.02;
    }
}
