package oo2.punto2.exception;

//La cantidad debe ser mayor a 0
public class CantidadInvalidaException extends RuntimeException {
    public CantidadInvalidaException(String message) {
        super(message);
    }
    
}
