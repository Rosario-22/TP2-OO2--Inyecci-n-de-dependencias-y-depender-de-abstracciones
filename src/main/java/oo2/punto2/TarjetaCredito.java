package oo2.punto2;

public abstract class TarjetaCredito {
    //Este metodo se implementara en el caso que las tarjetas no sean ni visa, ni master o comarcaPlus.
    public double calcularDescuento(Pedido pedido) {
        return 0;
    }
    
}
