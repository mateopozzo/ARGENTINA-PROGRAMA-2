package GestVet.turnos;

import GestVet.Turno.DAO.TurnoDAO;
import GestVet.Turno.DAO.TurnoRepositorio;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turno")
public class Turno implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nro_turno")
    private long nro_turno;
    
    @Column(name = "legajo_paciente")
    private long mascota_id;

    public Turno() {
    }

    public Turno(long nro_turno, long mascota_id) {
        this.nro_turno = nro_turno;
        this.mascota_id = mascota_id;
    }

    public long getNro_turno() {
        return nro_turno;
    }

    public void setNro_turno(long nro_turno) {
        this.nro_turno = nro_turno;
    }

    public long getMascota_id() {
        return mascota_id;
    }

    public void setMascota_id(long mascota_id) {
        this.mascota_id = mascota_id;
    }    
    
    
}
