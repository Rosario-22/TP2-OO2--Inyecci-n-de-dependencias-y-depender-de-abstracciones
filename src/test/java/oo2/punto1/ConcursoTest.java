package oo2.punto1;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
//Esta clase test es la encargada de evaluar 3 funcionalidades del concurso
//utilizando el formato AAA (Arrange-set up, Act-execute, Assert-verify) para cada prueba.
//Los test prueban comportamiento, no implementacion.
public class ConcursoTest {

    //1. prueba para verificar que un participante se inscribe correctamente
    // en el concurso y recibe puntos si se inscribe el primer día.
    @Test
    public void testInscripcionParticipante() {
        // Arrange
        Concurso concurso = new Concurso(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10));
        Participante participante = new Participante("Juan", 0);
        LocalDate fechaInscripcion = LocalDate.of(2024, 1, 1);
        // Act
        boolean resultado = concurso.inscribirParticipante(participante, fechaInscripcion);
        // Assert
        assertTrue(resultado);
        assertEquals(10, participante.getCantidadDePuntos());
    }

    //2. Prueba para verificar si un participante intenta inscribirse fuera del período de inscripción y se muestra el mensaje.
    @Test
    public void testInscripcionFueraDePeriodo() {
        // Arrange
        Concurso concurso = new Concurso(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10));
        Participante participante = new Participante("Maria", 0);
        LocalDate fechaInscripcion = LocalDate.of(2024, 1, 11); // Fecha fuera del período de inscripción
        // Act
        boolean resultado = concurso.inscribirParticipante(participante, fechaInscripcion);
        // Assert
        assertTrue(!resultado);
    }

    
    //3. prueba para verificar que el método cantidadParticipantes() devuelve el número correcto de participantes.
    @Test
    public void testCantidadParticipantes() {
        // Arrange
        Concurso concurso = new Concurso(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10));
        Participante participante1 = new Participante("Juan", 0);
        Participante participante2 = new Participante("Maria", 0);
        concurso.inscribirParticipante(participante1, LocalDate.of(2024, 1, 1));
        concurso.inscribirParticipante(participante2, LocalDate.of(2024, 1, 2));
        // Act
        int cantidad = concurso.cantidadParticipantes();
        // Assert
        assertEquals(2, cantidad);
    }


    //4. prueba para verificar que el método obtenerGanador() 
    // devuelve al participante con la mayor cantidad de puntos como ganador.
    @Test
    public void testObtenerGanador() {
        // Arrange
        Concurso concurso = new Concurso(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10));
        Participante participante1 = new Participante("Juan", 0);
        Participante participante2 = new Participante("Maria", 0);
        concurso.inscribirParticipante(participante1, LocalDate.of(2024, 1, 1));
        concurso.inscribirParticipante(participante2, LocalDate.of(2024, 1, 2));
        participante2.ganarPuntos(5); // Maria tiene más puntos que Juan
        // Act
        Participante ganador = concurso.obtenerGanador();
        // Assert
        assertEquals("Maria", ganador.getNombre());
    }
}
