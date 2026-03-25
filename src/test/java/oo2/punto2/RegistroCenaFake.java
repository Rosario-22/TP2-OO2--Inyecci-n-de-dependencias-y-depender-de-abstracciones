package oo2.punto2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistroCenaFake implements RegistroCena {

    private List<String> registros = new ArrayList<>();

    @Override
    public void guardar(LocalDate fecha, double monto) {
        registros.add(fecha + " || " + monto);
    }

    public List<String> registrosGuardados() {
        return registros;
    }
}
