package oo2.tp1.punto2;

import oo2.tp1.punto2.exception.PrecioInvalidoException;

public class PlatoPrincipal extends ProductoAbstract {
      
    public PlatoPrincipal(String nombre, double precio) throws PrecioInvalidoException{
        super(nombre, precio);
    }

    @Override
    public boolean esPlatoPrincipal() {
        return true; 
    }
}
