package oo2.punto1;

import java.io.FileWriter;
import java.io.IOException;

public class RegistroArchivo implements RegistroInscripcion{
private String ruta;

    public RegistroArchivo(String ruta) {
        this.ruta = ruta;
    }

    public void guardar(String texto) {
        try {
            FileWriter fw = new FileWriter(ruta, true);
            fw.write(texto + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
