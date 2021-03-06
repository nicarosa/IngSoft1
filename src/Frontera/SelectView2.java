/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas
 */
public class SelectView2 extends javax.swing.JPanel {

    private SelectNewCandidateView candidato;
    private SelectExistingCandidateView candidatos;
    private NuevoEmpleadoView empleado;

    private JPanel ParentPanel;

    /**
     * Creates new form seleccionE
     */
    public SelectView2(JPanel panel) {
        ParentPanel = panel;
        candidato = new SelectNewCandidateView(ParentPanel);
        candidatos = new SelectExistingCandidateView(ParentPanel);
        empleado = new NuevoEmpleadoView(panel);
        initComponents();
    }

    private void ActualizarGUI(JComponent component1, JComponent component2) {
        component1.removeAll();
        component1.add(component2);
        component1.revalidate();
        component1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        NuevoEmpleado = new javax.swing.JButton();
        buscarB = new javax.swing.JButton();
        nuevopB1 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        NuevoEmpleado.setText("Nuevo Empleado");
        NuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoEmpleadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 78;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 100, 61, 109);
        add(NuevoEmpleado, gridBagConstraints);

        buscarB.setText("Buscar en candidatos registrados");
        buscarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(48, 100, 0, 109);
        add(buscarB, gridBagConstraints);

        nuevopB1.setText("Nuevo perfil de candidato");
        nuevopB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevopB1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(72, 100, 0, 109);
        add(nuevopB1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoEmpleadoActionPerformed
        javax.swing.SwingUtilities.invokeLater(() -> ActualizarGUI(ParentPanel, empleado));    
    }//GEN-LAST:event_NuevoEmpleadoActionPerformed

    private void buscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBActionPerformed
        javax.swing.SwingUtilities.invokeLater(() -> ActualizarGUI(ParentPanel, candidatos));
    }//GEN-LAST:event_buscarBActionPerformed

    private void nuevopB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevopB1ActionPerformed
            javax.swing.SwingUtilities.invokeLater(() -> ActualizarGUI(ParentPanel, candidato));
    
    }//GEN-LAST:event_nuevopB1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NuevoEmpleado;
    private javax.swing.JButton buscarB;
    private javax.swing.JButton nuevopB1;
    // End of variables declaration//GEN-END:variables
}
