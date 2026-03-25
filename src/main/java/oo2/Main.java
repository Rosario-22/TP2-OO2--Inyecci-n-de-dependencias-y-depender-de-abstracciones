package oo2;

import oo2.punto2.Bebida;
import oo2.punto2.ItemPedido;
import oo2.punto2.Pedido;
import oo2.punto2.PlatoPrincipal;
import oo2.punto2.Producto;
import oo2.punto2.Propina;
import oo2.punto2.RegistroCena;
import oo2.punto2.SinDescuento;
import oo2.punto2.TarjetaCredito;
import oo2.punto2.persistencia.RegistroCenaArchivo;

public class Main {

    public static void main(String[] args) {

        RegistroCena registro;

        // archivo
        registro = new RegistroCenaArchivo("ventas.txt");

        // base de datos
        // registro = new RegistroCenaDB();

        // Crear pedido
        Pedido pedido = new Pedido(registro);

        // Crear productos
        Producto coca = new Bebida("Coca-cola", 2500, 0);
        Producto milanesa = new PlatoPrincipal("Milanesa", 6000);

        // Agregar items
        pedido.agregarItem(new ItemPedido(coca, 2));
        pedido.agregarItem(new ItemPedido(milanesa, 1));

        // Elegir propina
        pedido.elegirPropina(Propina.CINCO);

        // Elegir tarjeta
        TarjetaCredito tarjeta = new SinDescuento();

        double total = pedido.calcularTotal(tarjeta);

        // Mostrar resultado
        System.out.println("Total a pagar: " + total);
    }
}
