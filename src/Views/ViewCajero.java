/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.ClienteController;
import Controllers.EmpleadoController;
import Controllers.ProductoController;
import Controllers.ProveedorController;
import Controllers.VentaController;
import Models.Cliente;
import Models.DetalleVenta;
import Models.Empleados.Cajero;
import Models.Productos.Producto;
import Models.Venta;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Simón David Cruz S
 */
public class ViewCajero extends javax.swing.JFrame {

    /**
     * Creates new form ViewCajero
     */
    Cajero cajero; 
    ProductoController pc;
    EmpleadoController ec;
    ClienteController cc;
    ProveedorController pvC;
    VentaController vc;
    
    public ViewCajero(Cajero cajero, ProductoController pc, EmpleadoController ec, ClienteController cc, ProveedorController pvC) {
        initComponents();
        setLocationRelativeTo(this);
        
        this.cajero = cajero;
        this.pc =pc;
        this.ec =ec;
        this.cc =cc;
        this.pvC =pvC;
        this.vc = new VentaController();
        listarClientes();
        listarProductos();
        listarTabla();
        validarCarritoVacio();
    }
    
    public void validarCarritoVacio(){
        if(cajero.getCarrito().isEmpty()){
            CCliente.setEnabled(true);
        }else{
            CCliente.setEnabled(false);
        }
    }
    
    public String buscarIdCliente(String texto){
        String regex = "^(\\d+)\\.\\s.*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        
        if (matcher.find()) {
            String idCliente = matcher.group(1);
            return idCliente;
        }
        return null;
    }
    
    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < cajero.getCarrito().size(); i++) {
            total += cajero.getCarrito().get(i).getProducto().getPrecio() * cajero.getCarrito().get(i).getCantidad();
        }
        LabelTotal.setText("TOTAL $" + total);
        return total;
    }
    
    public void ajustarStock(Producto producto){
        int cantidadTotal = 0;
        for (int i = 0; i < cajero.getCarrito().size(); i++) {
            if(cajero.getCarrito().get(i).getProducto().getCodigoProducto() == producto.getCodigoProducto()){
                cantidadTotal +=  cajero.getCarrito().get(i).getCantidad();
            }
        }
        producto.setStock(producto.getStock()-cantidadTotal);
    }
    
    public void listarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Producto","Cantidad","Precio"});

        for (int i = 0; i < cajero.getCarrito().size(); i++) {
            model.addRow(new Object[]{
                cajero.getCarrito().get(i).getProducto().getNombreProducto(),
                cajero.getCarrito().get(i).getCantidad(),
                cajero.getCarrito().get(i).getProducto().getPrecio() * cajero.getCarrito().get(i).getCantidad()
            });
        }
        tabla.setModel(model);
    }

    public void listarClientes(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for (int i = 0; i < cc.getClientes().size(); i++) {
            model.addElement(cc.getClientes().get(i).getIdCliente() + ". " + cc.getClientes().get(i).getNombreCompleto());
        }      
        CCliente.setModel(model);
    }
    
    public void listarProductos(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for (int i = 0; i < pc.getProductos(0, false).size(); i++) {
            model.addElement(pc.getProductos(0, false).get(i).getNombreProducto());
        }
        listarCantidad(pc.getProductos(0, false).get(0));
        CProducto.setModel(model);
    }
    
    public void listarCantidad(Producto producto){
        ajustarStock(producto);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 0; i < producto.getStock(); i++) {
            model.addElement(i+1);
        }
        CCantidad.setModel(model);
        valorUnidad.setText("VALOR UNIDAD --> $" + producto.getPrecio());
        descuento.setText("DESCUENTO --> %" + producto.getDescuento() );
    }
    private void notificarStockBajo() {
        String notis = "";
        for (int i=0; i < cajero.getCarrito().size(); i++) {
            Producto producto = cajero.getCarrito().get(i).getProducto();
            if (producto.getStock() <= 15) {
                notis += "El producto '" + producto.getNombreProducto() + "' tiene un stock de: " + producto.getStock() + "\n";
            }
        }
        if (!notis.isBlank()) {
            JOptionPane.showMessageDialog(this, "----------- ALERTA STOCKS BAJOS ---------------\n\n" + notis);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        LabelTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CCliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        CProducto = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CCantidad = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        valorUnidad = new javax.swing.JLabel();
        descuento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("CARRITO");

        jButton4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton4.setText("Cerrar sesion");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        LabelTotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        LabelTotal.setText("TOTAL $ 0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(LabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(26, 26, 26))
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("PRODUCTO");

        CCliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        CCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CClienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("CLIENTE");

        CProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CProductoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Finalizar Compra");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setText("Agregar al carrito");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("CANTIDAD");

        CCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCantidadActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setText("Vaciar Carrito");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        valorUnidad.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        valorUnidad.setText("VALOR UNIDAD --> ");

        descuento.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        descuento.setText("DESCUENTO -->");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CCantidad, 0, 127, Short.MAX_VALUE)
                            .addComponent(CCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(valorUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(descuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(valorUnidad)
                .addGap(18, 18, 18)
                .addComponent(descuento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            int idCliente = Integer.parseInt(buscarIdCliente(CCliente.getSelectedItem() + ""));
            Cliente cliente = cc.buscarClientePorId(idCliente);
            double total = calcularTotal();

            Venta venta = new Venta(cliente, cajero, total, cajero.getCarrito());
            vc.agregarVenta(venta, venta.getDetallesVenta()); 
            JOptionPane.showMessageDialog(null, "Compra realizada con exito");
            notificarStockBajo();
            
            cajero.getCarrito().clear();
            CCliente.setEnabled(true);
            listarTabla();
            listarProductos();
        }catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cajero.getCarrito().clear();
        Producto producto = pc.buscarProductoNombre(CProducto.getSelectedItem() + "");
        listarCantidad(producto);
        listarTabla();
        calcularTotal();
        CCliente.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            int idCliente = Integer.parseInt(buscarIdCliente(CCliente.getSelectedItem() + ""));
            String productoNombre = (String) CProducto.getSelectedItem();
            int cantidad = Integer.parseInt(CCantidad.getSelectedItem() + "");
            
            Producto producto = pc.buscarProductoNombre(productoNombre);
            cajero.getCarrito().add(new DetalleVenta(producto, cantidad));
            
            listarCantidad(producto);
            listarTabla();
            
            CCliente.setEnabled(false);
            calcularTotal();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "NO HA SIDO POSIBLE AGREGAR ESTE PRODUCTO");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        PrincipalView pv = new PrincipalView(pc,ec,cc,pvC);
        pv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CProductoActionPerformed
        String nombre = CProducto.getSelectedItem() + "";
        Producto producto = pc.buscarProductoNombre(nombre);
        listarCantidad(producto);
    }//GEN-LAST:event_CProductoActionPerformed

    private void CClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CClienteActionPerformed

    }//GEN-LAST:event_CClienteActionPerformed

    private void CCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CCantidadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CCantidad;
    private javax.swing.JComboBox<String> CCliente;
    private javax.swing.JComboBox<String> CProducto;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel descuento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel valorUnidad;
    // End of variables declaration//GEN-END:variables
}
