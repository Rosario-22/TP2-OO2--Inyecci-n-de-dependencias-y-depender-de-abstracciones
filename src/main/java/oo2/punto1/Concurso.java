package oo2.punto1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Concurso {
    public static int contador= 0;
    private int idConcurso; 
    private List<Participante> participantes= new ArrayList<>();
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    RegistroInscripcion registro; 
   
    public Concurso(LocalDate fechaInicio, LocalDate fechaFin, RegistroInscripcion registro) {
        contador++;
        this.idConcurso=contador; 
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.registro = registro; 
    }

    //metodo para inscribir a un participante en el concurso, 
    //verificando que la fecha de inscripción sea válida y otorgando puntos si se inscribe el primer día
    public void  inscribirParticipante(Participante participante, LocalDate fechaActualInscripcion){
        //Verifico si ya pasó la fecha de inscripción, si es así, muestro un mensaje. 
        if(fechaActualInscripcion.isAfter(fechaFin)){
            throw new ValidacionFechaException("La fecha de inscripción del concurso ha finalizado.");
        } 
        if (fechaActualInscripcion.isBefore(fechaInicio)) {
            throw new ValidacionFechaException("Aún no comienza el período de inscripción al concurso.");
        }
        participantes.add(participante);
        if (fechaActualInscripcion.isEqual(fechaInicio)) {
            participante.ganarPuntos(10);
        }
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String linea = fechaActualInscripcion.format(f)
                        + ", " + participante.id() 
                        + ", " + this.idConcurso;        
        registro.guardar(linea);
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
        .max(Comparator.comparingInt(Participante::cantidadDePuntos))
        .orElse(null);
    }
}
