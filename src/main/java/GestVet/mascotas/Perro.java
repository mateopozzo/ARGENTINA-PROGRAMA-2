package GestVet.mascotas;

import GestVet.mascotas.Mascota;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table (name = "perros")
public class Perro extends Mascota {

    @Column(name = "tamaño")
    private String tamaño;
    
    @Column(name = "raza")
    private String raza;
    
    @Column(name = "color_pelo")
    private String pelo_color;
    
    public Perro() {
    }

    public Perro(String tamaño, String raza, String pelo_color, String mascota_nombre, String dueño_nombre, String sexo, int edad) {
        super(mascota_nombre, dueño_nombre, sexo, edad);
        this.tamaño = tamaño;
        this.raza = raza;
        this.pelo_color = pelo_color;
    }

    
    
    public String getTamanho() {
        return tamaño;
    }

    public void setTamanho(String tamanho) {
        this.tamaño = tamanho;
    }


    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPelo_color() {
        return pelo_color;
    }

    public void setPelo_color(String pelo_color) {
        this.pelo_color = pelo_color;
    }
    
}
