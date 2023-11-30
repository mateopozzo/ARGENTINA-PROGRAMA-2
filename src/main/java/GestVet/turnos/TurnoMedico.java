package GestVet.turnos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table (name = "turnos_atendidos")
public class TurnoMedico extends Turno implements Serializable {
    
    @Column(name = "veterinario")
    private String veterinario_nombre;
    
    @Column(name = "diagnostico")
    private String diagnostico;
    
    @Column(name = "solucion")
    private String solucion;

    public TurnoMedico() {
    }

    public TurnoMedico(String veterinario_nombre, String diagnostico, String solucion, long nro_turno, long mascota_id) {
        super(nro_turno, mascota_id);
        this.veterinario_nombre = veterinario_nombre;
        this.diagnostico = diagnostico;
        this.solucion = solucion;
    }

    public String getVeterinario_nombre() {
        return veterinario_nombre;
    }

    public void setVeterinario_nombre(String veterinario_nombre) {
        this.veterinario_nombre = veterinario_nombre;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }    
    
}
