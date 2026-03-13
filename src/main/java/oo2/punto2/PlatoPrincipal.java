package oo2.punto2;

public class PlatoPrincipal extends ProductoAbstract {
      
    public PlatoPrincipal(String nombre, double precio){
        super(nombre, precio);

    }

    @Override
    public boolean esPlatoPrincipal() {
        return true; 
    }
}
