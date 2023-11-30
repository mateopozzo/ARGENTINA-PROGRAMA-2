package GestVet.mascotas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Mascota implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "legajo")
    private long id;
    
    @Column(name="nombre")
    private String mascota_nombre;
    
    @Column(name="dueño")
    private String dueño_nombre;
    
    @Column(name="sexo")
    private String sexo;
    
    @Column(name="edad")
    private int edad;

    public Mascota() {
    }

    public Mascota(String mascota_nombre, String dueño_nombre, String sexo, int edad) {
        this.mascota_nombre = mascota_nombre;
        this.dueño_nombre = dueño_nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMascota_nombre() {
        return mascota_nombre;
    }

    public void setMascota_nombre(String mascota_nombre) {
        this.mascota_nombre = mascota_nombre;
    }

    public String getDueño_nombre() {
        return dueño_nombre;
    }

    public void setDueño_nombre(String dueño_nombre) {
        this.dueño_nombre = dueño_nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
