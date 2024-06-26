/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author N
 */
public class frmInscripciones extends javax.swing.JInternalFrame {
    AlumnoData alumnoData = new AlumnoData();
    InscripcionData inscripcionData = new InscripcionData();
    MateriaData materiaData = new MateriaData();
    DefaultTableModel modelo;
    
    
    /**
     * Creates new form AbmInscripciones
     */
    public frmInscripciones() {
        initComponents();
        //jtMaterias.setModel(modelo);
        modelo = (DefaultTableModel) jtMaterias.getModel();
        cargarAlumnos();
        llenarTabla();
    }
    
    private void cargarAlumnos(){
        List<Alumno> alumnos = alumnoData.listarAlumnosActivos();
        alumnos.forEach(alumno ->jcbAlumno.addItem(alumno.toString()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgFiltroMaterias = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlAlumno = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jrbMateriasInscriptas = new javax.swing.JRadioButton();
        jrbMateriasNoInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jbGuardarInscripcion = new javax.swing.JButton();
        jbBorrarInscripcionMateriaAlumno = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlAlumno.setText("Alumno");

        jcbAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAlumnoItemStateChanged(evt);
            }
        });

        bgFiltroMaterias.add(jrbMateriasInscriptas);
        jrbMateriasInscriptas.setSelected(true);
        jrbMateriasInscriptas.setText("Materias Inscriptas");
        jrbMateriasInscriptas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrbMateriasInscriptasStateChanged(evt);
            }
        });

        bgFiltroMaterias.add(jrbMateriasNoInscriptas);
        jrbMateriasNoInscriptas.setText("Materias no inscriptas");

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Año"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtMaterias.setColumnSelectionAllowed(true);
        jtMaterias.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtMaterias);
        jtMaterias.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jbGuardarInscripcion.setText("Inscribir");
        jbGuardarInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarInscripcionActionPerformed(evt);
            }
        });

        jbBorrarInscripcionMateriaAlumno.setText("Anular Inscripcion");
        jbBorrarInscripcionMateriaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarInscripcionMateriaAlumnoActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlAlumno)
                        .addGap(18, 18, 18)
                        .addComponent(jcbAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrbMateriasInscriptas)
                        .addGap(18, 18, 18)
                        .addComponent(jrbMateriasNoInscriptas)
                        .addGap(0, 332, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbGuardarInscripcion)
                        .addGap(18, 18, 18)
                        .addComponent(jbBorrarInscripcionMateriaAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlAlumno))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMateriasInscriptas)
                    .addComponent(jrbMateriasNoInscriptas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardarInscripcion)
                    .addComponent(jbBorrarInscripcionMateriaAlumno)
                    .addComponent(jbSalir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarInscripcionActionPerformed
        int fila = jtMaterias.getSelectedRow();
        
        if (fila != -1 && jrbMateriasNoInscriptas.isSelected()){
            int idMateria = (int)jtMaterias.getValueAt(fila, 0);
            Materia materia = materiaData.buscarMateria(idMateria);
            Alumno alumno = new Alumno((String)jcbAlumno.getSelectedItem());

            Inscripcion inscripcion = new Inscripcion(alumno,materia);
            inscripcionData.guardarInscripcion(inscripcion);
        }
        llenarTabla();
    }//GEN-LAST:event_jbGuardarInscripcionActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbAlumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAlumnoItemStateChanged
        llenarTabla();
    }//GEN-LAST:event_jcbAlumnoItemStateChanged

    private void jrbMateriasInscriptasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jrbMateriasInscriptasStateChanged
        llenarTabla();
    }//GEN-LAST:event_jrbMateriasInscriptasStateChanged

    private void jbBorrarInscripcionMateriaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarInscripcionMateriaAlumnoActionPerformed
        int fila = jtMaterias.getSelectedRow();
        
        if (fila != -1 && jrbMateriasInscriptas.isSelected()){
            int idMateria = (int)jtMaterias.getValueAt(fila, 0);
            Alumno alumno = new Alumno((String)jcbAlumno.getSelectedItem());
            inscripcionData.borrarInscripcionMateriaAlumno(alumno.getIdAlumno(),idMateria);
        }
        limpiarTabla();
        llenarTabla();
    }//GEN-LAST:event_jbBorrarInscripcionMateriaAlumnoActionPerformed
    
    private void limpiarTabla(){
        for (int i = modelo.getRowCount(); i>0; i--)
            modelo.removeRow(0);
    }
    
    private void llenarTabla(){
        limpiarTabla();
        List<Materia> materias;
        String alumnoString = (String)jcbAlumno.getSelectedItem();
        
        if (alumnoString!=null && !alumnoString.isEmpty()){
            Alumno alumno = new Alumno(alumnoString);

            if (jrbMateriasInscriptas.isSelected()){
                materias = inscripcionData.obtenerMateriasCursadas(alumno.getIdAlumno());
            }else{
                materias = inscripcionData.obtenerMateriasNOCursadas(alumno.getIdAlumno());
            }

            for(Materia m: materias) {
                modelo.addRow(new Object[]{
                    m.getIdMateria(),
                    m.getNombre(),
                    m.getAnioMateria()
                });

            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInscripciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgFiltroMaterias;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBorrarInscripcionMateriaAlumno;
    private javax.swing.JButton jbGuardarInscripcion;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbAlumno;
    private javax.swing.JLabel jlAlumno;
    private javax.swing.JRadioButton jrbMateriasInscriptas;
    private javax.swing.JRadioButton jrbMateriasNoInscriptas;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables
}
