package Test;
import AccesoADatos.AlumnoData;
import Entidades.Alumno;
import java.time.LocalDate;
import java.time.Month;



public class MainTest {
    public static void main(String[] args) {
        
        AlumnoData ad = new AlumnoData();
        Alumno alumno1 = new Alumno(40123123,"Ramirez", "Joseph", LocalDate.of(2023, Month.MARCH, 12), true);
        
        System.out.println("/////// guardar alumno:");
        
        ad.guardarAlumno(alumno1);
        
        Alumno alumno2 = ad.buscarAlumno(alumno1.getIdAlumno());
        
        System.out.println("/////// buscar alumno:");
        
        System.out.println(alumno1.toString());
        System.out.println("");
        System.out.println(alumno2.toString());
        
        System.out.println("/////// buscar alumno por dni");
        Alumno alumno3 = ad.buscarAlumnoPorDNI(alumno1.getDni());
        
        
        System.out.println(alumno1.toString());
        System.out.println("");
        System.out.println(alumno3.toString());
        
        System.out.println("/////// listar alumnos:");
        
        Alumno alumno4 = new Alumno(40456456,"Jefferson", "Juan", LocalDate.of(2022, Month.MAY, 27), true);
        Alumno alumno5 = new Alumno(40789789,"Nazario", "Franccesco", LocalDate.of(2023, Month.MARCH, 12), true);
        
        ad.guardarAlumno(alumno4);
        ad.guardarAlumno(alumno5);
        
        for (Alumno a : ad.listarAlumnos()) {
            System.out.println(a.toString());
        }
        
        System.out.println("/////// modificar alumno:");
        
        Alumno alumno6 = new Alumno(alumno1.getIdAlumno(), 40123123, "Josephson", "Ramiro", LocalDate.of(2024, Month.APRIL, 23), true);
        
        ad.modificarAlumno(alumno6);
        
        for (Alumno a : ad.listarAlumnos()) {
            System.out.println(a.toString());
        }
        
        System.out.println("/////// eliminar alumno:");
   
        ad.eliminarAlumno(alumno4.getIdAlumno());
        
        for (Alumno a : ad.listarAlumnos()) {
            System.out.println(a.toString());
        }
        
    }
}
