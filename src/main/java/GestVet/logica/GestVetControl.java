package GestVet.logica;

import GestVet.Mascota.DAO.MascotaDAO;
import GestVet.Mascota.DAO.MascotaRepositorio;
import GestVet.Turno.DAO.TurnoDAO;
import GestVet.Turno.DAO.TurnoRepositorio;
import GestVet.mascotas.Gato;
import GestVet.mascotas.Mascota;
import GestVet.mascotas.Perro;
import GestVet.turnos.Turno;
import GestVet.turnos.TurnoCliente;
import GestVet.turnos.TurnoMedico;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestVetControl {

    public void menuPrincipal() {
        
        Character opcion;
        Scanner cin = new Scanner(System.in);
        
        do{
            
            System.out.println("Ingresa alguna opcion disponible\n1 - Cargar tu mascota\n2 - Reservar un turno\n3 - Atencion de una mascota\n4 - Mostrar mis mascotas\n5 - Borrar mascota\nx - Cerrar");
            opcion = cin.nextLine().charAt(0);
            
            
            switch(opcion){
                
                case '1' :
                    System.out.println("Tu mascota es perro o gato?\n1 - Perro\n2 - Gato");
                    int opcion_masc;
                    
                    do{
                        opcion_masc = cin.nextInt();
                    }while(opcion_masc != 2 && opcion_masc != 1);
                    
                    if(opcion_masc == 1)
                        registrarPerro();
                    else
                        registrarGato();
                    break;
                    
                case '2' : reservarTurno(); break;
                    
                case '3' : atenderTurnoMedico(); break;   
                
                case '4' : mostrarTodasMisMascotas(); break;
                
                case '5': borrarMascota(); break;
                    
            }
            
            
        }while(opcion != 'x');
        
    }

    public void mostrarTodasMisMascotas(){
        
        Scanner cin = new Scanner(System.in);
        System.out.println("Ingrese su nombre");
        
        String nombre = cin.nextLine();
        
        MascotaDAO masc_dao = new MascotaRepositorio();
        
        List<Mascota> lista_mascotas = masc_dao.traerMascotasPorNombre(nombre);
        
        lista_mascotas.forEach((mascota) -> System.out.println(mascota.getId() + " - " + mascota.getMascota_nombre() + "\n")); 
        
    }

    public void registrarMascota(Mascota mascota_registrar) {
        Scanner cin = new Scanner(System.in);

        System.out.println("Ingrese datos de la mascota");

        System.out.println("Nombre de la mascota: ");
        String mascota_nombre = cin.nextLine();

        System.out.println("Sexo de la mascota: ");
        String sexo = cin.nextLine();

        int edad = 0;
        boolean edadValida = false;

        while (!edadValida) {
            try {
                System.out.println("Edad de la mascota: ");
                String edad_s = cin.nextLine();
                edad = Integer.parseInt(edad_s);
                edadValida = true; // Si la conversión fue exitosa, salimos del bucle
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido para la edad.");
            }
        }

        System.out.println("Tu nombre (o del responsable de la mascota): ");
        String dueño_nombre = cin.nextLine();

        mascota_registrar.setMascota_nombre(mascota_nombre);
        mascota_registrar.setSexo(sexo);
        mascota_registrar.setEdad(edad);
        mascota_registrar.setDueño_nombre(dueño_nombre);

        // Reviso que la mascota no esté ya registrada
        List<Mascota> lista_mascotas = new ArrayList<>();
        MascotaDAO mascota_dao = new MascotaRepositorio();
        lista_mascotas = mascota_dao.traerTodasLasMascotas();

        boolean cargar = true;
        long id_aux = 0;

        while (cargar && !lista_mascotas.isEmpty()) {
            Mascota mascotaAux = lista_mascotas.getLast();

            if (mascota_registrar.getMascota_nombre().equals(mascotaAux.getMascota_nombre()) &&
                    mascotaAux.getDueño_nombre().equals(mascota_registrar.getDueño_nombre())) {
                cargar = false;
                id_aux = mascotaAux.getId();
                
            }
            
            lista_mascotas.removeLast();
            
        }

        if (cargar) {
            mascota_dao.crearMascota(mascota_registrar);
            System.out.println("Se registró a " + mascota_registrar.getMascota_nombre() + " en el sistema");
        } else {
            System.out.println("La mascota ya está registrada, su id es: " + id_aux);
        }
        
        cin.nextLine();
        
    }

    public void registrarGato() {
        
        Gato gato_registrar = new Gato();
        Scanner cin = new Scanner(System.in);

        System.out.println("Ingrese datos de su gato");

        System.out.println("Color del pelo: ");
        String color_pelo = cin.nextLine();

        System.out.println("Color de ojos: ");
        String color_ojos = cin.nextLine();

        gato_registrar.setColor_pelo(color_pelo);
        gato_registrar.setColor_ojos(color_ojos);

        // Llamamos a la función genérica para registrar mascotas
        registrarMascota(gato_registrar);
        
    }

    public void registrarPerro() {
        
        Perro perro_registrar = new Perro();
        Scanner cin = new Scanner(System.in);

        System.out.println("Ingrese datos de su perro");

        System.out.println("Tamaño del perro: ");
        String tamaño = cin.nextLine();

        System.out.println("Raza del perro: ");
        String raza = cin.nextLine();

        System.out.println("Color del pelo: ");
        String pelo_color = cin.nextLine();

        perro_registrar.setTamanho(tamaño);
        perro_registrar.setRaza(raza);
        perro_registrar.setPelo_color(pelo_color);

        // Llamamos a la función genérica para registrar mascotas
        registrarMascota(perro_registrar);
        
    }
    
    public void registrarTurno(Turno turno){
        
        Scanner cin = new Scanner(System.in);
        
        TurnoDAO turno_dao = new TurnoRepositorio();
        
        turno_dao.crearTurno(turno);
            
    }
    
    public void editarTurno(Turno turno){
        TurnoDAO turno_dao = new TurnoRepositorio();
        
        turno_dao.editarTurno(turno);
    }
    
    public Turno encontrarTurno(long id){
        TurnoDAO turno_dao = new TurnoRepositorio();
        
        return turno_dao.encontrarTurno(id);
    }
    
    public void atenderTurnoMedico(){
        
        String veterinario, diagnostico, solucion;
        long legajo_mascota;
        
        Scanner cin = new Scanner(System.in);
        
        System.out.println("Nombre del que atiende: ");
        veterinario = cin.nextLine();
                
        boolean flag = false;        

        System.out.println("Legajo de la mascota atendida: ");
        legajo_mascota = cin.nextLong();
        
        System.out.println("Diagnostico de la situacion : ");
        diagnostico = cin.nextLine();
        diagnostico = cin.nextLine();
        
        System.out.println("Solucion implementada: ");
        solucion = cin.nextLine();
        
        TurnoMedico turno_vet = new TurnoMedico();
        
        turno_vet.setVeterinario_nombre(veterinario);
        turno_vet.setMascota_id(legajo_mascota);
        turno_vet.setDiagnostico(diagnostico);
        turno_vet.setSolucion(solucion);
        
        registrarTurno(turno_vet);
        
    }
    
    public void reservarTurno(){
        
        String motivo;
        Scanner cin = new Scanner(System.in);
        
        System.out.println("Ingresa el motivo de la consulta");
        motivo = cin.nextLine();        
        
        TurnoCliente turno_clt = new TurnoCliente();
        
        turno_clt.setMotivo(motivo);
        
        long mascota_id;
        
        System.out.println("Ingresa el Id de tu mascota: ");
        
        mascota_id = cin.nextLong();
        
        turno_clt.setMascota_id(mascota_id);
        
        registrarTurno(turno_clt);
        
        System.out.println("Su numero de turno es: " + turno_clt.getNro_turno());
        
    }    
    
    public void borrarMascota(){
        
        Scanner cin = new Scanner(System.in);
        
        System.out.println("Ingresa el Id de la mascota que quieres borrar");
        
        long legajo_borrar = cin.nextLong();
        
        MascotaDAO mascota_dao = new MascotaRepositorio();
        
        mascota_dao.borrarMascota(legajo_borrar);
        
        System.out.println("Su mascota fue borrada del sistema.\n\n");
        
    }

}
