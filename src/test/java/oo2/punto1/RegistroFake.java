package oo2.punto1;

import java.util.ArrayList;
import java.util.List;

public class RegistroFake implements RegistroInscripcion {

    private List<String> lineas = new ArrayList<>();

    public void guardar(String linea) {
        lineas.add(linea);
    }

    public List<String> lineasGuardadas() {
        return lineas;
    }
}
