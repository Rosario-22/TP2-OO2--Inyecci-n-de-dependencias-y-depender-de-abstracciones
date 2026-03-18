package oo2.punto2;

public class SinDescuento extends TarjetaCredito {

    @Override
    public double calcularDescuento(Pedido pedido, double totalconPropina) {
        return totalconPropina;
    }
}

