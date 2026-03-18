package oo2.punto2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;


public class TarjetaTest {
    @Test 
    public void calculoCostoVisa()  {
        //Arrange
        Producto coca = new Bebida("COCA-COLA", 2500, 750);
        Producto milanesa = new PlatoPrincipal("milanesa con papas al horno", 6000);
        Pedido mesaPedido = new Pedido(); 
        ItemPedido platoPpal = new ItemPedido(milanesa, 2);
        ItemPedido bebida = new ItemPedido(coca, 4);
        mesaPedido.agregarItem(platoPpal);
        mesaPedido.agregarItem(bebida);
        mesaPedido.confirmarPedido();
        TarjetaCredito tarjeta = new Visa();
        mesaPedido.elegirPropina(Propina.CINCO);
        //act
        double total = mesaPedido.calcularTotal(tarjeta);
        //assert
        //tarjeta visa (5% propina, 3% bebidas)
        assertEquals(22800, total, 0.1);
    }

    @Test
    public void calculoCostoMaster() {
        //arrange
        Producto bebida = new Bebida("Fanta", 2500, 750);
        Producto platoPpal = new PlatoPrincipal("fideos a la crema", 6000);
        Pedido mesaPedido = new Pedido(); 
        ItemPedido item = new ItemPedido(platoPpal, 2);
        ItemPedido item1= new ItemPedido(bebida, 4);
        mesaPedido.agregarItem(item);
        mesaPedido.agregarItem(item1);
        mesaPedido.confirmarPedido();
        TarjetaCredito tarjeta = new MasterCard();
        mesaPedido.elegirPropina(Propina.DOS);
        //act
        double total = mesaPedido.calcularTotal(tarjeta);
        //assert
        //tarjeta master card (2% propina, 2% platos)
        assertEquals(22200, total, 0.1);
    }

    @Test
    public void calculoCostoComarca() {
        //arrange
        Producto bebida = new Bebida("Vino", 2500, 750);
        Producto platoPpal = new PlatoPrincipal("Lomo al plato con guarnición", 6000);
        Pedido mesaPedido = new Pedido(); 
        ItemPedido item1 = new ItemPedido(bebida, 2);
        ItemPedido item2 = new ItemPedido(platoPpal, 4);
        mesaPedido.agregarItem(item1);
        mesaPedido.agregarItem(item2);
        mesaPedido.confirmarPedido();
        TarjetaCredito tarjeta = new ComarcaPlus();
        mesaPedido.elegirPropina(Propina.TRES);
        //act
        double total = mesaPedido.calcularTotal(tarjeta);
        //assert
        //tarjeta comarca plus (3% propina, 2% total)
        assertEquals(29290, total, 0.1);
    }

    @Test
    public void costotarjetaViedma() {
        //arrange
        Producto bebida = new Bebida("Vino", 2500, 750);
        Producto platoPpal = new PlatoPrincipal("Lomo al plato con guarnición", 6000);
        Pedido mesaPedido = new Pedido(); 
        ItemPedido item1 = new ItemPedido(bebida, 2);
        ItemPedido item2 = new ItemPedido(platoPpal, 4);
        mesaPedido.agregarItem(item1);
        mesaPedido.agregarItem(item2);
        mesaPedido.confirmarPedido();
        TarjetaCredito tarjeta = new SinDescuento();
        mesaPedido.elegirPropina(Propina.TRES);
        //act
        double total = mesaPedido.calcularTotal(tarjeta);
        //assert
        // tarjeta viedma (3% propina, sin descuento)
        assertEquals(29870, total, 0.1);
    }
}
