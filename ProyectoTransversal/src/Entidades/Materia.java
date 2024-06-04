package Entidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Materia {
    private int idMateria;
    private String nombre;
    private int añoMateria;
    private boolean activo;
    
    public Materia(){}
    public Materia(int idMateria, String Nombre, int anioMateria, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = Nombre;
        this.añoMateria = anioMateria;
        this.activo = activo;
    }
    public Materia(String Nombre, int anioMateria, boolean activo) {
        this.nombre = Nombre;
        this.añoMateria = anioMateria;
        this.activo = activo;
    }
    
    // Constructor from string
    public Materia(String str) {
        Pattern pattern = Pattern.compile("Materia\\{idMateria=(\\d+), nombre=(.+), añoMateria=(\\d+), activo=(true|false)\\}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            this.idMateria = Integer.parseInt(matcher.group(1));
            this.nombre = matcher.group(2);
            this.añoMateria = Integer.parseInt(matcher.group(3));
            this.activo = Boolean.parseBoolean(matcher.group(4));
        } else {
            throw new IllegalArgumentException("Invalid Materia string format");
        }
    }
    
    public int getIdMateria() {
        return idMateria;
    }
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
    public int getAnioMateria() {
        return añoMateria;
    }
    public void setAnioMateria(int anioMateria) {
        this.añoMateria = anioMateria;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + ", añoMateria=" + añoMateria + ", activo=" + activo + '}';
    }
}
