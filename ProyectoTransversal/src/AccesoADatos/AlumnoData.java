package AccesoADatos;
import Entidades.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlumnoData {
    private Connection con = null;
    
    public AlumnoData() {
        con = Conexion.GetConexion();
    }
    
    public void guardarAlumno(Alumno alumno) {
        
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se agrego el alumno exitosamente");
            }
            ps.close();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Alumno "+e.getMessage());
        }
    }
    
    public Alumno buscarAlumno(int id) {
        
        Alumno alumno = null;
        String sql = "SELECT * FROM alumno WHERE idAlumno = ? ";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                
            } else JOptionPane.showMessageDialog(null, "No existe alumno con el ID que solicito");
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Alumno "+e.getMessage());
        }
        
        return alumno;
    }
    
    public Alumno buscarAlumnoPorDNI(int dni) {
        
        Alumno alumno = null;
        String sql = "SELECT * FROM alumno WHERE dni = ? ";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                
            }// else JOptionPane.showMessageDialog(null, "No existe alumno con el DNI que solicito");
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Alumno "+e.getMessage());
        }
        
        return alumno;
    }
        
    public List<Alumno> listarAlumnos() {
            
        List<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alumno";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Alumno "+e.getMessage());
        }
            
        return alumnos;
    }
    
    public List<Alumno> listarAlumnosActivos() {
        List<Alumno> alumnos = listarAlumnos();
        alumnos.removeIf(alumno -> alumno.isActivo() == false);
        
        return alumnos;
    }
        
   public void modificarAlumno(Alumno alumno) {
            
        String sql = "UPDATE alumno SET apellido = ? , nombre = ? , fechaNacimiento = ?, estado = ? WHERE dni = ? ";
        PreparedStatement ps = null;
  
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, alumno.getApellido());
            ps.setString(2, alumno.getNombre());
            ps.setDate(3, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(4, alumno.isActivo());
            ps.setInt(5, alumno.getDni());
            //ps.setInt(5, alumno.getIdAlumno());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El alumno fue modificado exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Alumno " + e.getMessage());
        }
    }
        
    public void eliminarAlumno(int dni) {

        try {
            String sql = "UPDATE alumno SET estado = 0 WHERE dni = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino el alumno");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Alumno " + e.getMessage());
        }

    }        
        
}
