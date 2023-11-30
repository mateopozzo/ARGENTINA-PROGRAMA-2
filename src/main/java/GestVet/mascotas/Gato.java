package GestVet.mascotas;

import GestVet.mascotas.Mascota;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table (name = "gatos")
public class Gato extends Mascota {
    
    @Column(name = "color_pelo")
    private String color_pelo;
    
    @Column(name = "color_ojos")
    private String color_ojos;

    public Gato() {
    }

    public Gato(String color_pelo, String color_ojos, String mascota_nombre, String dueño_nombre, String sexo, int edad) {
        super(mascota_nombre, dueño_nombre, sexo, edad);
        this.color_pelo = color_pelo;
        this.color_ojos = color_ojos;
    }
    
    public String getColor_pelo() {
        return color_pelo;
    }

    public void setColor_pelo(String color_pelo) {
        this.color_pelo = color_pelo;
    }

    public String getColor_ojos() {
        return color_ojos;
    }

    public void setColor_ojos(String color_ojos) {
        this.color_ojos = color_ojos;
    }
    
}
