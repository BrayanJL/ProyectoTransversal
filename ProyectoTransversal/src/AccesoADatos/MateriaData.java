package AccesoADatos;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MateriaData {
    private Connection con = null;
    
    public MateriaData() {
        con = Conexion.GetConexion();
    }
    
    public void guardarMateria(Materia materia) {
        
        String sql = "INSERT INTO materia (nombre, año, estado) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se agrego la materia exitosamente");
            }
            ps.close();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla materia "+e.getMessage());
        }
    }
    
    public Materia buscarMateria(int id) {
        
        Materia materia = null;
        String sql = "SELECT nombre, año, estado FROM materia WHERE idMateria = ? ";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setActivo(rs.getBoolean("estado"));
                
            } else JOptionPane.showMessageDialog(null, "No existe materia con el ID que solicito");
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla materia "+e.getMessage());
        }
        
        return materia;
    }
    
    public void modificarMateria(Materia materia) {
            
        String sql = "UPDATE materia SET nombre = ? , año = ?, estado = ? WHERE idmateria = ? ";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.setInt(4, materia.getIdMateria());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La materia fue modificada exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla materia "+e.getMessage());
        }
    }
    
    public void eliminarMateria(int id) {
            
        try {
            String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino la materia exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla materia "+e.getMessage());
        }
            
    }
        
    public List<Materia> listarMaterias() {
            
        List<Materia> materias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM materia";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setNombre(rs.getString("nombre"));
                materia.setActivo(rs.getBoolean("estado"));
                materias.add(materia);
            }
            ps.close();
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla materia "+e.getMessage());
        }
            
        return materias;
    }
    
    public List<Materia> listarMateriasActivas() {
        List<Materia> materias = listarMaterias();
        materias.removeIf(materia -> materia.isActivo() == false);
       
        return materias;
    }
}
