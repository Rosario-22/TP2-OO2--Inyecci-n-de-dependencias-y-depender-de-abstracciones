package oo2.punto2;


public class Mesa{
    private int cantidadDeSillas;
    private boolean estaDisponible;
    private Pedido pedido; 

    public Mesa(int cantidadDeSillas) {
        this.cantidadDeSillas = cantidadDeSillas;
        this.estaDisponible = true;
        this.pedido = null;
    }

    public int saberCapacidad() {
        return cantidadDeSillas;
    }

    public boolean EstaDisponible() {
        return estaDisponible;
    }

    public Pedido getPedido() {
        return pedido;
    }
}
