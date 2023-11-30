package GestVet.Turno.DAO;

import GestVet.persistencia.TurnoJpaController;
import GestVet.persistencia.exceptions.NonexistentEntityException;
import GestVet.turnos.Turno;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TurnoRepositorio implements TurnoDAO {

    public TurnoJpaController turnoJPA;

    public TurnoRepositorio() {
        this.turnoJPA = new TurnoJpaController();
    }
    
    @Override
    public Turno encontrarTurno(long id) {
        return turnoJPA.findTurno(id);
    }

    @Override
    public List<Turno> traerTodosLosTurnos() {
       return turnoJPA.findTurnoEntities();
    }

    @Override
    public void crearTurno(Turno turno) {
        turnoJPA.create(turno);
    }

    @Override
    public void editarTurno(Turno turno) {
        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(TurnoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void borrarTurno(long id) {
        try {
            turnoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(TurnoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
