/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontera;

import Control.ValidarLogin;
import Entidad.Usuario;
import Frontera.PrincipalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Ingreso extends javax.swing.JPanel {

    /**
     * Creates new form Ingreo
     */
    public Ingreso() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        contraseñaTF = new javax.swing.JTextField();
        aceptarB = new javax.swing.JButton();
        
        jLabel1.setText("Nombre");
        
        jLabel2.setText("Contraseña");
        
        nombreTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTFActionPerformed(evt);
            }
        });
        
        aceptarB.setText("Aceptar");
        aceptarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(contraseñaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel2))
                                .addContainerGap(135, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aceptarB)
                                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(contraseñaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(aceptarB)
                                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void nombreTFActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }    
    
    private void aceptarBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Usuario usuario = new Usuario();
        usuario.setNombre(nombreTF.getText());
        usuario.setPassword(contraseñaTF.getText());
        
        ValidarLogin validar = new ValidarLogin();
        
        String resultado = validar.verificarLogin(usuario);
        if (resultado.equals("Bienvenido")) {
            PrincipalFrame p = new PrincipalFrame();
            p.setVisible(true);
            LoginFrame.n.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, resultado);
        }
        
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton aceptarB;
    private javax.swing.JTextField contraseñaTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nombreTF;
    // End of variables declaration                   
}
