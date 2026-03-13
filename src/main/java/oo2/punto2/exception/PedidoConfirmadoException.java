package oo2.punto2.exception;
//No se pueden agregar items a un pedido confirmado
public class PedidoConfirmadoException extends RuntimeException{
    public PedidoConfirmadoException(String message) {
        super(message);
    }
}
