package oo2.punto2.exception;

//El precio debe ser mayor a 0 
public class PrecioInvalidoException extends RuntimeException{
    public PrecioInvalidoException(String message) {
        super(message);
    }
}
