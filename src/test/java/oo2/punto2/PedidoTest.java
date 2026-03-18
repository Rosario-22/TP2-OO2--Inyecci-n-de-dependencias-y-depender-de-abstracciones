package oo2.punto2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    @Test
    public void testCalcularSubtotalParaUnaBebida() {
        //Configuracion
        Producto coca = new Bebida("Coca-cola", 2500, 0);
        Pedido pedido = new Pedido();
        pedido.agregarItem(new ItemPedido(coca, 1));

        //Ejercitacion
        double subtotalBebida = pedido.calcularSubtotalBebidas();

        //Verificacion
        Assertions.assertEquals(2500, subtotalBebida);
    }

    @Test
    public void testCalcularSubtotalParaDosBebidas() {
        //Configuracion
        Producto coca = new Bebida("Coca-cola", 2500, 0);
        Pedido pedido = new Pedido();
        pedido.agregarItem(new ItemPedido(coca, 2));

        //Ejercitacion
        double subtotalBebida = pedido.calcularSubtotalBebidas();

        //Verificacion
        Assertions.assertEquals(5000, subtotalBebida);
    }
    @Test
    public void testCalcularSubtotalParaVariasBebidas() {
        //Configuracion
        Producto coca = new Bebida("Coca-cola", 2500, 0);
        Producto fanta = new Bebida("Fanta", 3000, 0);
        Pedido pedido = new Pedido();
        pedido.agregarItem(new ItemPedido(coca, 2));
        pedido.agregarItem(new ItemPedido(fanta, 2));

        //Ejercitacion
        double subtotalBebida = pedido.calcularSubtotalBebidas();

        //Verificacion
        Assertions.assertEquals(11000, subtotalBebida);
    }

    @Test
    public void testCalcularSubtotalParaUnPlato() {
        //Configuracion
        Producto milanesa = new PlatoPrincipal("Milanesa con papas al horno", 6000);
        Pedido pedido = new Pedido();
        pedido.agregarItem(new ItemPedido(milanesa, 1));

        //Ejercitacion
        double subtotalPlato = pedido.calcularSubtotalPlatos();

        //Verificacion
        Assertions.assertEquals(6000, subtotalPlato);
    }

    @Test
    public void testCalcularSubtotalParaDosPlatos() {
        //Configuracion
        Producto milanesa = new PlatoPrincipal("Milanesa con papas al horno", 6000);
        Pedido pedido = new Pedido();
        pedido.agregarItem(new ItemPedido(milanesa, 2));

        //Ejercitacion
        double subtotalPlato = pedido.calcularSubtotalPlatos();

        //Verificacion
        Assertions.assertEquals(12000, subtotalPlato);
    }

    @Test
    public void testCalcularSubtotalParaVariosPlatos() {
        //Configuracion
        Producto milanesa = new PlatoPrincipal("Milanesa con papas al horno", 6000);
        Producto salmon = new PlatoPrincipal("Salmon ahumado", 10000);
        Pedido pedido = new Pedido();
        pedido.agregarItem(new ItemPedido(milanesa, 2));
        pedido.agregarItem(new ItemPedido(salmon, 2));
        //Ejercitacion
        double subtotalPlato = pedido.calcularSubtotalPlatos();
        //Verificacion
        Assertions.assertEquals(32000, subtotalPlato);
    }
}
