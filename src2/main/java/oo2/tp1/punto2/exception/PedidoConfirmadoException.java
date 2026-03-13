package oo2.tp1.punto2.exception;
//No se pueden agregar items a un pedido confirmado
public class PedidoConfirmadoException extends Exception {
    public PedidoConfirmadoException(String message) {
        super(message);
    }
}
