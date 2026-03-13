package oo2.tp1.punto2.exception;

//El precio debe ser mayor a 0 
public class PrecioInvalidoException extends Exception {
    public PrecioInvalidoException(String message) {
        super(message);
    }
}
