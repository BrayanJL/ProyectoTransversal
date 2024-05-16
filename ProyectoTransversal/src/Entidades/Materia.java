package Entidades;

public class Materia {
    private int idMateria;
    private String Nombre;
    private int anioMateria;
    private boolean activo;
    
    public Materia(){}
    public Materia(int idMateria, String Nombre, int anioMateria, boolean activo) {
        this.idMateria = idMateria;
        this.Nombre = Nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }
    public Materia(String Nombre, int anioMateria, boolean activo) {
        this.Nombre = Nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }
    
    public int getIdMateria() {
        return idMateria;
    }
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public int getAnioMateria() {
        return anioMateria;
    }
    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", Nombre=" + Nombre + ", anioMateria=" + anioMateria + ", activo=" + activo + '}';
    }
}
