package oo2.punto2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculoMaster {
    // Este test calcula el costo con tarjeta Mastercard
    @Test
    public void testCalculoMaster(){
        //Arrange 
        ProductoAbstract producto1 = new PlatoPrincipal("Milanesa con papas al horno", 6000);
        ProductoAbstract producto2 = new Bebida("Coca-cola", 2500, 500);
        ProductoAbstract producto3 = new Bebida("Fanta", 3000, 300);
        ItemPedido item1 = new ItemPedido(producto1, 2);
        ItemPedido item2 = new ItemPedido(producto2, 1);
        ItemPedido item3 = new ItemPedido(producto3, 3);
        Pedido pedido = new Pedido();
        pedido.agregarItem(item1);
        pedido.agregarItem(item2);
        pedido.agregarItem(item3);
        TarjetaCreditoAbstract tarjeta = new MasterCard();
        //Act
        double total = tarjeta.calcularDescuento(pedido);
        pedido.elegirPropina(PropinaEnum.CINCO);
        //Assert
        assertEquals(23030, total);
    }
}