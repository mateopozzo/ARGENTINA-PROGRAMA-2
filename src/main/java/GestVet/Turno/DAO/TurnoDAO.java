package GestVet.Turno.DAO;

import GestVet.turnos.Turno;
import java.util.List;

public interface TurnoDAO {
    Turno encontrarTurno(long id);
    List<Turno> traerTodosLosTurnos();
    void crearTurno(Turno turno);
    void editarTurno(Turno turno);
    void borrarTurno(long id);
}
