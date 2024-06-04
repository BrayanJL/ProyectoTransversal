package Entidades;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alumno {
    private int idAlumno;
    private int dni;
    private String apellido, nombre;
    private LocalDate fechaNac;
    private boolean activo;
    
    public Alumno(){}
    public Alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }
    public Alumno(int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }
    
    // Constructor from string
    public Alumno(String str) {
        Pattern pattern = Pattern.compile("Alumno\\{idAlumno=(\\d+), apellido=(.+), nombre=(.+), fechaNac=(\\d{4}-\\d{2}-\\d{2}), activo=(true|false)\\}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            this.idAlumno = Integer.parseInt(matcher.group(1));
            this.apellido = matcher.group(2);
            this.nombre = matcher.group(3);
            this.fechaNac = LocalDate.parse(matcher.group(4)); // Assuming the date format is yyyy-MM-dd
            this.activo = Boolean.parseBoolean(matcher.group(5));
        } else {
            throw new IllegalArgumentException("Invalid Alumno string format");
        }
    }
    
    public int getIdAlumno(){
        return idAlumno;
    }
    public void setIdAlumno(int idAlumno){
        this.idAlumno = idAlumno;
    }
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public LocalDate getFechaNac(){
        return fechaNac;
    }
    public void setFechaNac(LocalDate fechaNac){
        this.fechaNac = fechaNac;
    }
    public boolean isActivo(){
        return activo;
    }
    public void setActivo(boolean activo){
        this.activo = activo;
    }
    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", activo=" + activo + '}';
    }
}
