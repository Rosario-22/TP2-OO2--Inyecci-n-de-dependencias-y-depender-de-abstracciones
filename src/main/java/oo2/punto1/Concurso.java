package oo2.punto1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Concurso {
    private List<Participante> participantes= new ArrayList<>();
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
   
    public Concurso(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    //metodo para inscribir a un participante en el concurso, 
    //verificando que la fecha de inscripción sea válida y otorgando puntos si se inscribe el primer día
    public boolean inscribirParticipante(Participante participante, LocalDate fechaActualInscripcion){
        //Verifico si ya pasó la fecha de inscripción, si es así, muestro un mensaje. 
        if(fechaActualInscripcion.isAfter(fechaFin)){
            System.out.println("El período de inscripción ha finalizado.");
            return false;
        } 
        if (fechaActualInscripcion.isBefore(fechaInicio)) {
            return false;
        }
        participantes.add(participante);
        if (fechaActualInscripcion.isEqual(fechaInicio)) {
            participante.ganarPuntos(10);
        }
        return true;
    }

   // Método para obtener la cantidad de paeticipantes inscritos en el concurso
    public int cantidadParticipantes() {
    return participantes.size();
    }
    
    // Método para verificar si un participante específico está inscrito en el concurso
    public boolean estaInscripto(Participante participante) {
        return participantes.contains(participante);
    }

    //Metodo para obtener al ganador del concurso,(el que contenga màs puntos)
    public Participante obtenerGanador() {
       return participantes.stream()
        .max(Comparator.comparingInt(Participante::getCantidadDePuntos))
        .orElse(null);
    }
}
