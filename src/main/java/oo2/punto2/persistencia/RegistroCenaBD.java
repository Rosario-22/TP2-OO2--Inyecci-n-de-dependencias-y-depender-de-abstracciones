package oo2.punto2.persistencia;

import java.time.LocalDate;
import oo2.punto2.RegistroCena;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroCenaBD implements RegistroCena {

    private Connection connection;

    public RegistroCenaBD() {
        try {
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/resto", 
                "root", 
                "password"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error de conexión");
        }
    }

    @Override
    public void guardar(LocalDate fecha, double monto) {
        String sql = "INSERT INTO registros (fecha, monto) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(fecha));
            stmt.setDouble(2, monto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar en DB");
        }
    }
}
