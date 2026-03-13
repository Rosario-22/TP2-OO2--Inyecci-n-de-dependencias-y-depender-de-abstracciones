package oo2.tp1.punto2.exception;

//No se puede confirmar un pedido vacío
public class PedidoVacioException extends Exception {
    public PedidoVacioException(String message) {
        super(message);
    }
}
