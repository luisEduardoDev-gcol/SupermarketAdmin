/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.ProductoController;
import Controllers.EmpleadoController;
import Controllers.ClienteController;
import Controllers.ProveedorController;
import Models.Empleados.Empleado;

import java.awt.Color;

/**
 *
 * @author Simón David Cruz S
 */
public class ViewGerente extends javax.swing.JFrame {

    /**
     * Creates new form ViewGerente
     */
   
    ProductoController pc;
    EmpleadoController ec;
    ClienteController cc;
    ProveedorController pvC;
    Empleado empleado;
    
    public ViewGerente(ProductoController pc, EmpleadoController ec, ClienteController cc, ProveedorController pvC, Empleado empleado) {
        initComponents();
        setLocationRelativeTo(this);
        
        // Controladores por el momento aca en view gerente
        this.pc = pc;
        this.ec = ec;
        this.cc = cc;
        this.pvC = pvC;
        this.empleado = empleado;

        this.setResizable(false);
        //estilarElementos();

        txtNombreUsuario.setText(this.empleado.getNombreCompleto());
        txtNombreUsuario.setEnabled(false);
    }
    
    public void estilarElementos(){
        btnSesion.setBackground(new Color(46, 134, 193));
        
        btnProductos.setForeground(new Color(0, 189, 145));
        btnProductos.setBackground(new Color(200, 230, 200));
        
        btnProveedores.setForeground(new Color(0, 0, 139));
        btnProveedores.setBackground(new Color(173, 216, 230));
        
        btnClientes.setForeground(new Color(128, 0 ,128));
        btnClientes.setBackground(new Color(221, 160, 221));
        
        btnEmpleados.setForeground(new Color(139, 0, 0));
        btnEmpleados.setBackground(new Color(244, 182, 193));
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
        btnProductos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnSesion = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnProductos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnProductos.setText("GESTION PRODUCTOS");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnClientes.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnClientes.setText("GESTION CLIENTES");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnEmpleados.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEmpleados.setText("GESTION EMPLEADOS");
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        jButton5.setText("CONFIGURACION");

        btnProveedores.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnProveedores.setText("GESTION PROVEEDORES");
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnSesion.setText("Cerrar Sesion");
        btnSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionActionPerformed(evt);
            }
        });

        lblUsuario.setText("Usuario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario)
                .addGap(18, 18, 18)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(242, 242, 242)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(541, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSesion)
                            .addComponent(lblUsuario)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(129, Short.MAX_VALUE))))
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

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        GestionProveedoresView gp = new GestionProveedoresView(pc,ec,cc,pvC,this.empleado);
         gp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        GestionProductosView vp = new GestionProductosView(pc,ec,cc,pvC,this.empleado);
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        GestionClientesView gc = new GestionClientesView(pc,ec,cc,pvC,this.empleado);
        gc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        GestionEmpleadosView ge = new GestionEmpleadosView(pc,ec,cc,pvC,this.empleado);
        ge.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSesionActionPerformed
        PrincipalView pv = new PrincipalView(pc,ec,cc,pvC);
        pv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSesionActionPerformed

    
    /**
     * @param args the command line arguments
     * GERENTE SERIA LA PRUEBA ESTE MAIN PARA NO LOGEAR SIEMPRE
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnSesion;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
