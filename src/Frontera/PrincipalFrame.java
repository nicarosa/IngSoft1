/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import Entidad.EmployeeEntity;
import Entidad.CandidatesList;
import Entidad.EmployeesList;
import Entidad.PositionEntity;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nicolas
 */
public class PrincipalFrame extends javax.swing.JFrame {

    public static EmployeesList listaEmpleados = new EmployeesList();
    public static CandidatesList listaCandidatos = new CandidatesList();

    public PrincipalFrame() {
        initComponents();
        inicializar();

    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void addRowtoJtable() {
        DefaultTableModel model = (DefaultTableModel) RosterView.listaT.getModel();
        Object rowData[] = new Object[11];
        for (int i = 0; i < listaEmpleados.size(); i++) {
            rowData[0] = listaEmpleados.sacar(i).getNombre();
            rowData[1] = listaEmpleados.sacar(i).getApellido();
            rowData[2] = listaEmpleados.sacar(i).getId();
            rowData[3] = listaEmpleados.sacar(i).getEdad();
            rowData[4] = listaEmpleados.sacar(i).getARL();
            rowData[5] = listaEmpleados.sacar(i).getEPS();
            rowData[6] = listaEmpleados.sacar(i).getContactoDeEmergencia();
            rowData[7] = listaEmpleados.sacar(i).getDireccion();
            rowData[8] = listaEmpleados.sacar(i).getCargo().getNombre();
            rowData[9] = listaEmpleados.sacar(i).getCargo().getSueldo();
            rowData[10] = listaEmpleados.sacar(i).isActivo();
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        novedadesB = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        contratacionB = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        retirarB = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        listarB = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HR System");
        setSize(new java.awt.Dimension(500, 1000));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setMargin(new java.awt.Insets(10, 10, 10, 10));

        novedadesB.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        novedadesB.setText("Novedades");
        novedadesB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        novedadesB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novedadesBActionPerformed(evt);
            }
        });
        jToolBar1.add(novedadesB);
        jToolBar1.add(jSeparator1);

        contratacionB.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        contratacionB.setText("Contratacion");
        contratacionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contratacionBActionPerformed(evt);
            }
        });
        jToolBar1.add(contratacionB);
        jToolBar1.add(jSeparator2);

        retirarB.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        retirarB.setText("Retirar Empleado");
        retirarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirarBActionPerformed(evt);
            }
        });
        jToolBar1.add(retirarB);
        jToolBar1.add(jSeparator3);

        listarB.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        listarB.setText("Listar Empleados");
        listarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarBActionPerformed(evt);
            }
        });
        jToolBar1.add(listarB);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelPrincipal.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método para actualizar el contenido del panelPrincipal
    private void ActualizarGUI(JComponent component1, JComponent component2) {
        component1.removeAll();
        component1.add(component2);
        cleanButtonStyles();
        component1.revalidate();
        component1.repaint();
    }

    private void paintButtonActive(JButton button) {
        button.requestFocus();
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
    }

    private void cleanButtonStyles() {
        for (int i = 0; i < 7; i++) {
            Component comp = jToolBar1.getComponent(i);
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                button.setFont(new Font("SansSerif", Font.PLAIN, 14));
            }
        }
    }

    private void novedadesBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novedadesBActionPerformed
        NoveltySearchView buscarN = new NoveltySearchView();
        javax.swing.SwingUtilities.invokeLater(() -> {
            ActualizarGUI(panelPrincipal, buscarN);
            paintButtonActive(novedadesB);
        });

    }//GEN-LAST:event_novedadesBActionPerformed

    private void retirarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirarBActionPerformed
        RemoveView retirar = new RemoveView();
        javax.swing.SwingUtilities.invokeLater(() -> {
            ActualizarGUI(panelPrincipal, retirar);
            paintButtonActive(retirarB);
        });
    }//GEN-LAST:event_retirarBActionPerformed

    private void listarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarBActionPerformed
        RosterView nomina = new RosterView();
        javax.swing.SwingUtilities.invokeLater(() -> {
            ActualizarGUI(panelPrincipal, nomina);
            paintButtonActive(listarB);
            addRowtoJtable();
        });
    }//GEN-LAST:event_listarBActionPerformed

    private void contratacionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contratacionBActionPerformed
        //Acá el constructor de la vista está modificado para propagar el panel principal a todos los nodos hijos. Esto podría ser fácilmente evitable
        //usando interfaces, sin embargo, Swing es una shit y no conozco muy bien su AST como para meterle mano
        SelectView elegircargo = new SelectView(panelPrincipal);
        javax.swing.SwingUtilities.invokeLater(() -> {
            ActualizarGUI(panelPrincipal, elegircargo);
            paintButtonActive(contratacionB);
        });
    }//GEN-LAST:event_contratacionBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void inicializar() {

        EmployeeEntity uno = new EmployeeEntity();
        EmployeeEntity dos = new EmployeeEntity();
        EmployeeEntity tres = new EmployeeEntity();

        PositionEntity Chef = new PositionEntity();
        PositionEntity Janitor = new PositionEntity();
        PositionEntity Dishwasher = new PositionEntity();

        Chef.setNombre("Head Chef");
        Chef.setSueldo(2000000);

        Janitor.setNombre("Conserje");
        Janitor.setSueldo(1000000);

        Dishwasher.setNombre("Lava Platos");
        Dishwasher.setSueldo(800000);

        uno.setARL("1020");
        uno.setActivo(true);
        uno.setApellido("CHAVES");
        uno.setContactoDeEmergencia(305612321);
        uno.setDireccion("Avenida calle 22#15-69");
        uno.setEPS("SaludCoop");
        uno.setEdad(21);
        uno.setId("1030685411");
        uno.setNombre("ANDRES");
        uno.setPensiones(900000);
        uno.getNovedades().setHorasTrabajadas(1440);
        uno.setCargo(Dishwasher);

        dos.setARL("1030");
        dos.setActivo(true);
        dos.setApellido("CASTAÑEDA");
        dos.setCesantias(24);
        dos.setContactoDeEmergencia(306798545);
        dos.setDireccion("AVENIDA LAS FERIAS#70-05");
        dos.setEPS("SALUDTOTAL");
        dos.setEdad(19);
        dos.setId("1019146963");
        dos.setNombre("SEBASTIAN");
        dos.setPensiones(900000);
        dos.setCargo(Janitor);

        tres.setARL("1040");
        tres.setActivo(true);
        tres.setApellido("CARO");
        tres.setCesantias(25);
        tres.setContactoDeEmergencia(10232131);
        tres.setDireccion("AV.PRIMERADEMAYO#70-22");
        tres.setEPS("VIVASALUD");
        tres.setEdad(25);
        tres.setId("1013647467");
        tres.setNombre("NICOLAS");
        tres.setPensiones(1200000);
        tres.setCargo(Chef);

        listaEmpleados.AñadirEmpleado(uno);
        listaEmpleados.AñadirEmpleado(dos);
        listaEmpleados.AñadirEmpleado(tres);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contratacionB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton listarB;
    private javax.swing.JButton novedadesB;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JButton retirarB;
    // End of variables declaration//GEN-END:variables
}
