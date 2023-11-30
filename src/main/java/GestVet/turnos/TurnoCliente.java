package GestVet.turnos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table (name = "turnos_reservados")
public class TurnoCliente extends Turno implements Serializable {
    
    @Column(name = "motivo")
    private String motivo;

    public TurnoCliente(long nro_turno, long mascota_id, String motivo) {
        super(nro_turno, mascota_id);
        this.motivo = motivo;
    }

    public TurnoCliente() {
    }
    
    
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
}
