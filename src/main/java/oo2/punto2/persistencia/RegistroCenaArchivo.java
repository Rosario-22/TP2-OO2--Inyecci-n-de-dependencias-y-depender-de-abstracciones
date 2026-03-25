package oo2.punto2.persistencia;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import oo2.punto2.RegistroCena;

public class RegistroCenaArchivo implements RegistroCena {

    private String nombreArchivo;

    public RegistroCenaArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void guardar(LocalDate fecha, double monto) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String linea = fecha.format(f) + " || " + monto;
        try {
            FileWriter fw = new FileWriter(nombreArchivo, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(linea);
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo");
        }
    }
}
