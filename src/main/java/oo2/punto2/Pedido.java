package oo2.punto2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import oo2.punto2.exception.PedidoConfirmadoException;
import oo2.punto2.exception.PedidoVacioException;
public class Pedido {

    private List<ItemPedido> items;
    private boolean confirmado;
    TarjetaCredito tarjeta;
    Propina propina; 
    RegistroCena registro; 

    public Pedido(RegistroCena registro) {
        this.items = new ArrayList<>();
        this.confirmado = false;
        this.registro= registro; 
    }

    public void agregarItem(ItemPedido item) {
        if (confirmado) {
            throw new PedidoConfirmadoException("No se pueden agregar items a un pedido confirmado");
        }
        items.add(item);
    }

    public void confirmarPedido() {
        if (items.isEmpty()) {
            throw new PedidoVacioException("No se puede confirmar un pedido vacío");
        }
        confirmado = true;
    }

    public double calcularSubtotalBebidas() {
        return items.stream()
                .mapToDouble(ItemPedido::calcularSubtotalBebidas)
                .sum();
    }

    public double calcularSubtotalPlatos() {
        return items.stream()
                .mapToDouble(ItemPedido::calcularSubtotalPlatos)
                .sum();
    }

    double calcularTotalBruto(){
        return calcularSubtotalBebidas() + calcularSubtotalPlatos();
    }
    public void elegirPropina(Propina propina)  {
        this.propina = propina; 
    }

    public double calcularTotal(TarjetaCredito tarjeta) {
        double totalBruto = this.calcularTotalBruto();
        double propinaCalculada = propina.calcularSobre(totalBruto);
        double totalConPropina = totalBruto + propinaCalculada;
        double totalFinal = tarjeta.calcularDescuento(this, totalConPropina);

        registro.guardar(LocalDate.now(), totalFinal);

        return totalFinal;
    }
}
