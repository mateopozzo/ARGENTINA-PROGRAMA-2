package GestVet.Mascota.DAO;

import GestVet.mascotas.Mascota;
import java.util.List;

public interface MascotaDAO {
    public Mascota encontrarMascota(long id);
    List<Mascota> traerTodasLasMascotas();
    void crearMascota(Mascota mascota);
    void editarMascota(Mascota mascota);
    void borrarMascota(long id);
    List<Mascota> traerMascotasPorNombre(String nombre);
}
