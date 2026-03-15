package oo2.punto2;
/*Los pagos con tarjeta de crédito Comarca Plus tienen un
descuento del 2% sobre el costo total (bebidas + platos principales) */
public class ComarcaPlus extends TarjetaCreditoAbstract{
   
    private static final double DESCUENTO = 0.02;

    public double calcularDescuento(Pedido pedido) {
        return (pedido.calcularSubtotalBebidas() + pedido.calcularSubtotalPlatos()) * DESCUENTO;
    }
}
