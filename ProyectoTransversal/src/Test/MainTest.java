package Test;
import AccesoADatos.AlumnoData;
import AccesoADatos.MateriaData;
import Entidades.Alumno;
import Entidades.Materia;
import java.time.LocalDate;
import java.time.Month;



public class MainTest {
    public static void main(String[] args) {
        
        System.out.println("///////////////////// PRUEBAS ALUMNO:");
        
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
        
        System.out.println("");
        
        System.out.println("///////////////////// PRUEBAS MATERIA:");
        
        MateriaData md = new MateriaData();
        Materia materia1 = new Materia("matematicas 1", 2, true);
        

        
        System.out.println("/////// guardar materia:");
        
        md.guardarMateria(materia1);
        
        Materia materia2 = md.buscarMateria(materia1.getIdMateria());
        
        System.out.println("/////// buscar materia:");
        
        System.out.println(materia1.toString());
        System.out.println("");
        System.out.println(materia2.toString());
        
        System.out.println("/////// listar materias:");
        
        Materia materia3 = new Materia("lab 2", 3, true);
        Materia materia4 = new Materia("web 1", 2, true);
        
        md.guardarMateria(materia3);
        md.guardarMateria(materia4);
        
        for (Materia a : md.listarMaterias()) {
            System.out.println(a.toString());
        }
        
        System.out.println("/////// modificar materia:");
        
        Materia materia5 = new Materia(materia1.getIdMateria(),"matematicas introductorias", 1, true);;
        
        md.modificarMateria(materia5);
        
        for (Materia a : md.listarMaterias()) {
            System.out.println(a.toString());
        }
        
        System.out.println("/////// eliminar materia:");
   
        md.eliminarMateria(materia3.getIdMateria());
        
        for (Materia a : md.listarMaterias()) {
            System.out.println(a.toString());
        }
    }
}
