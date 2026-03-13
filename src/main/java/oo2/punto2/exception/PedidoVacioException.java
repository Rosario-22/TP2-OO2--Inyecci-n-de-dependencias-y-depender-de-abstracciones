package oo2.punto2.exception;

//No se puede confirmar un pedido vacío
public class PedidoVacioException extends RuntimeException{
    public PedidoVacioException(String message) {
        super(message);
    }
}
