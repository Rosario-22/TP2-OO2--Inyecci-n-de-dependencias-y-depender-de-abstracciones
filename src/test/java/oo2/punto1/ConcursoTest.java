package oo2.punto1;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//Esta clase test es la encargada de evaluar 3 funcionalidades del concurso
//utilizando el formato AAA (Arrange-set up, Act-execute, Assert-verify) para cada prueba.
//Los test prueban comportamiento, no implementacion.
public class ConcursoTest {

    //1. prueba para verificar que un participante se inscribe correctamente
    // en el concurso y recibe puntos si se inscribe el primer día.
    @Test
    public void testInscripcionPrimerDia() {
        // Arrange
        RegistroFake registro = new RegistroFake(); 
        Concurso concurso = new Concurso(LocalDate.of(2024,1,1), LocalDate.of(2024,1,10), registro);
        Participante participante = new Participante("Romina",0);
        LocalDate fechaInscripcion = LocalDate.of(2024,1,1);
        // Act
        concurso.inscribirParticipante(participante, fechaInscripcion);
        // Assert
        assertTrue(concurso.estaInscripto(participante));
        assertEquals(10, participante.cantidadDePuntos());
        assertEquals(1, registro.lineasGuardadas().size());
    }

    //2. Prueba para verificar si un participante intenta inscribirse fuera del período de inscripción y se lanza la excepcion.
    @Test
    public void testInscripcionFueraDePeriodo() {
        // Arrange
        RegistroFake registro = new RegistroFake(); 
        Concurso concurso = new Concurso(LocalDate.of(2024,1,1), LocalDate.of(2024,1,10), registro);
        Participante participante = new Participante("Maria",0);
        LocalDate fechaInscripcion = LocalDate.of(2024,1,11);
        // Act + Assert
        ValidacionFechaException exception = assertThrows(ValidacionFechaException.class,
            () -> concurso.inscribirParticipante(participante, fechaInscripcion) );
        assertEquals("La fecha de inscripción del concurso ha finalizado.", exception.getMessage());
        assertEquals(0, registro.lineasGuardadas().size());//valido que no se haya guardado nada 
    }

    //3. Prueba para verificar si un particvipante intenta inscribirse antes del inicio del período de inscripción y se lanza la excepcion. 
    @Test
    public void testInscripcionAntesDePeriodo() {
        // Arrange
        RegistroFake registro = new RegistroFake();
        Concurso concurso = new Concurso(LocalDate.of(2024,1,2), LocalDate.of(2024,1,10), registro);
        Participante participante = new Participante("Ana",0);
        LocalDate fechaInscripcion = LocalDate.of(2024,1,1);
        // Act + Assert
        ValidacionFechaException exception = assertThrows( ValidacionFechaException.class,
            () -> concurso.inscribirParticipante(participante, fechaInscripcion) );
        assertEquals("Aún no comienza el período de inscripción al concurso.", exception.getMessage());
        assertEquals(0, registro.lineasGuardadas().size());//valido que no se haya guardado nada 
    }

    //4. prueba para verificar que el método cantidadParticipantes() devuelve el número correcto de participantes.
    @Test
    public void testCantidadParticipantes() {
        // Arrange
        RegistroFake registro = new RegistroFake();
        Concurso concurso = new Concurso(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10), registro);
        Participante participante1 = new Participante("Juan", 0);
        Participante participante2 = new Participante("Maria", 0);
        concurso.inscribirParticipante(participante1, LocalDate.of(2024, 1, 1));
        concurso.inscribirParticipante(participante2, LocalDate.of(2024, 1, 2));
        // Act
        int cantidad = concurso.cantidadParticipantes();
        // Assert
        assertEquals(2, cantidad);
        assertEquals(2, registro.lineasGuardadas().size());
    }

    //5. prueba para verificar que el método obtenerGanador() 
    // devuelve al participante con la mayor cantidad de puntos como ganador.
    @Test
    public void testObtenerGanador() {
        // Arrange
        RegistroFake registro = new RegistroFake(); 
        Concurso concurso = new Concurso(LocalDate.of(2024, 1, 2), LocalDate.of(2024, 1, 10), registro);
        Participante participante1 = new Participante("Juan", 0);
        Participante participante2 = new Participante("Maria", 0);
        concurso.inscribirParticipante(participante1, LocalDate.of(2024, 1, 2));
        concurso.inscribirParticipante(participante2, LocalDate.of(2024, 1, 3));
        participante2.ganarPuntos(5); //Juan tiene más puntos que Maria 
        // Act
        Participante ganador = concurso.obtenerGanador();
        // Assert
        assertEquals("Juan", ganador.nombre());
    }
}