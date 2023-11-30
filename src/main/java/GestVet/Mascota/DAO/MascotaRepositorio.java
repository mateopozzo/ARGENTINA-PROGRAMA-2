package GestVet.Mascota.DAO;

import GestVet.mascotas.Mascota;
import GestVet.persistencia.MascotaJpaController;
import GestVet.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateo
 */
public class MascotaRepositorio implements MascotaDAO {
    
    public MascotaJpaController mascotaJPA;

    public MascotaRepositorio() {
        this.mascotaJPA = new MascotaJpaController();
    }    

    @Override
    public Mascota encontrarMascota(long id) {
        return mascotaJPA.findMascota(id);
    }

    @Override
    public List<Mascota> traerTodasLasMascotas() {
        return mascotaJPA.findMascotaEntities();
    }

    @Override
    public void crearMascota(Mascota mascota) {
        mascotaJPA.create(mascota);
    }

    @Override
    public void editarMascota(Mascota mascota) {
        try {
            mascotaJPA.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(MascotaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void borrarMascota(long id) {
        try {
            mascotaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MascotaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Mascota> traerMascotasPorNombre(String nombre){
        List<Mascota> lista_mascotas = new ArrayList<>();
        List<Mascota> lista_final = new ArrayList<>();
        
        lista_mascotas = mascotaJPA.findMascotaEntities();
        
        for(Mascota mascota: lista_mascotas){
            if(mascota.getDueño_nombre().equals(nombre))
                lista_final.add(mascota);
        }
        
        return lista_final;
    }
  
    
}

/*

codigo viejo que funcionaba por si pasa algo

package com.mycompany.gestionveterinaria.mascotas;

import com.mycompany.gestionveterinaria.persistencia.MascotaJpaController;

import com.mycompany.gestionveterinaria.persistencia.exceptions.NonexistentEntityException;
import java.util.List;

public class ControlPersistenciaMascotas {
    
    MascotaJpaController mascotaJPA = new MascotaJpaController();       

    public ControlPersistenciaMascotas() {
    }
    
    
    public void crearMascota(Mascota mascota) {

        mascotaJPA.create(mascota);
    
    }
    
    public void editarMascota(Mascota mascota) throws Exception {

        mascotaJPA.edit(mascota);
    
    }
    
    public void borrarMascota(long id) throws NonexistentEntityException {
    
        mascotaJPA.destroy(id);
    
    }
    
    public void encontrarMascota(long id) throws Exception {
        
        mascotaJPA.findMascota(id);
    
    }
    
    public List<Mascota> traerTodasLasMascotas(){
        
        return mascotaJPA.findMascotaEntities();
    
    }
    
    
}
*/
