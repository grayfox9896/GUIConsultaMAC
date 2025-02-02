/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.wifi;

import analisis.wifi.Entities.Router;
import analisis.wifi.Entities.Station;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joel
 */
public class Analisis extends javax.swing.JFrame {

    /**
     * Creates new form Analisis
     */
    public Analisis() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        cmbxFilter = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtMAC = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Análisis de redes WIFI");

        jLabel1.setText("Busqueda por:");

        cmbxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dispositivos presentes en varias redes", "Número de clientes por red", "Dispositivo en todas la redes (por MAC)", "Clientes asociados a una red (por MAC)", "Clientes asociados a una red (por Nombre)", "Redes relacionadas (que comparten dispositivos) (por MAC)", "Redes relacionadas (que comparten dispositivos) (por Nombre)" }));

        jLabel2.setText("MAC:");

        jLabel3.setText("Nombre:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(txtMAC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Exportar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Seleccionar BD");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//  File f= new File("./Requerimientos.db");
//        if (!f.exists()) {
//            System.out.print("No existe la BD");
//           ConnectionLite.CreaDB();
//       }
        JFileChooser choo= new JFileChooser();
        FileNameExtensionFilter fn= new FileNameExtensionFilter("SQLite DB", "db");
        choo.setAcceptAllFileFilterUsed(false);
        choo.addChoosableFileFilter(fn);        
        choo.showOpenDialog(null);
        if (choo.accept(choo.getSelectedFile()))
        {
          try {
            Files.copy(choo.getSelectedFile().toPath(),new File("./MAC.db").toPath(),StandardCopyOption.REPLACE_EXISTING);
          } catch (Exception ex) {
              Logger.getLogger(Analisis.class.getName()).log(Level.SEVERE, null, ex);
          }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
//Dispositivo en en todas la redes (por MAC)
//Dispositivos presentes en varias redes
//Número de clientes por red
//Clientes asociados a una red (por MAC)
//Clientes asociados a una red (por Nombre)
//Redes relacionadas (que comparten dispositivos) (por MAC)
//Redes relacionadas (que comparten dispositivos) (por Nombre)
        File f= new File("MAC.db");
        if (!f.exists()) {
            System.out.print("No existe la BD");
           return;
       }
        switch (this.cmbxFilter.getSelectedItem().toString()){
           case "Dispositivo en todas la redes (por MAC)":
               SearchDevice(txtMAC.getText());       
               break;
           case "Dispositivos presentes en varias redes":        
               searchDeviceInMultipleAP();
                   break;
           case "Número de clientes por red":
                   getCountClientsByAP();
                   break;
           case "Clientes asociados a una red (por MAC)":
           case"Clientes asociados a una red (por Nombre)":
               getClientsAsosiatedToAP(txtMAC.getText(),this.txtName.getText());
               break;
               
           case "Redes relacionadas (que comparten dispositivos) (por MAC)":
           case "Redes relacionadas (que comparten dispositivos) (por Nombre)":
               getRelatedNetworks(txtMAC.getText(),this.txtName.getText());
               break;
       }
              
       
       
                
        
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row= jTable1.getSelectedRow();        
        this.txtMAC.setText(jTable1.getModel().getValueAt(row,0).toString());        
    }//GEN-LAST:event_jTable1MouseClicked
public void getRelatedNetworks(String MAC,String Name){
    List<Router> req= new ArrayList<Router>();
    req=ConnectionLite.getRelatedNetworks(MAC,Name);
     Object columnNames[] = { "MAC Router","Red Asociada","Fabricante del Dispositivo"};
      DefaultTableModel model = new DefaultTableModel(columnNames, 0);
      
      String[] reg=new String[3];      
        for (Router r : req){
            reg[0]=String.valueOf(r.Router_MAC);
            reg[2]=String.valueOf(r.Router_Vendor);
            reg[1]=r.Router_Nombre;            
             model.addRow(reg);
        }            
      jTable1.setModel(model);
      jTable1.getColumn(columnNames[0]).setPreferredWidth(10);
        jTable1.getColumn(columnNames[1]).setPreferredWidth(20);
        jTable1.getColumn(columnNames[2]).setPreferredWidth(60);                  
    }
    public void SearchDevice(String device){
    List<Router> req= new ArrayList<Router>();
    req=ConnectionLite.searchDeviceInDB(device);
     Object columnNames[] = { "Router MAC", "Nombre Router", "Fecha Dispositivo","Fabricante"};
      DefaultTableModel model = new DefaultTableModel(columnNames, 0);
      String[] reg=new String[4];      
        for (Router r : req){
            reg[0]=String.valueOf(r.Router_MAC);
            reg[1]=String.valueOf(r.Router_Nombre);
            reg[2]=r.Fecha;
            reg[3]=r.Router_Vendor;
             model.addRow(reg);
        }            
        jTable1.setModel(model);
        jTable1.getColumn(columnNames[0]).setPreferredWidth(30);
        jTable1.getColumn(columnNames[1]).setPreferredWidth(80);
        jTable1.getColumn(columnNames[2]).setPreferredWidth(60);
        jTable1.getColumn(columnNames[3]).setPreferredWidth(60);        
    }
public void searchDeviceInMultipleAP(){
    List<Station> req= new ArrayList<Station>();
    req=ConnectionLite.searchDeviceInMultipleAP();
     Object columnNames[] = { "Dispositivo MAC", "Redes asociadas","Fabricante del Dispositivo"};
      DefaultTableModel model = new DefaultTableModel(columnNames, 0);
      
      String[] reg=new String[3];      
        for (Station r : req){
            reg[0]=String.valueOf(r.Device_MAC);
            reg[1]=String.valueOf(r.helperInt);            
            reg[2]=r.Station_Vendor;
             model.addRow(reg);
        }            
      jTable1.setModel(model);
      jTable1.getColumn(columnNames[0]).setPreferredWidth(10);
        jTable1.getColumn(columnNames[1]).setPreferredWidth(20);
        jTable1.getColumn(columnNames[2]).setPreferredWidth(60);                  
    }

///dice que es ROUTER, pero en realidad son estaciones
public void getClientsAsosiatedToAP(String MAC,String Name){
    List<Router> req= new ArrayList<Router>();
    req=ConnectionLite.getAsociatedClientToAP(MAC,Name);
     Object columnNames[] = { "MAC de Dispositivo", "Fabricante del Dispositivo","Red Asociada","Fecha"};
      DefaultTableModel model = new DefaultTableModel(columnNames, 0);
      
      String[] reg=new String[4];      
        for (Router r : req){
            reg[0]=String.valueOf(r.Router_MAC);
            reg[1]=String.valueOf(r.Router_Vendor);
            reg[2]=r.Router_Nombre;
            reg[3]=r.Fecha;
             model.addRow(reg);
        }            
      jTable1.setModel(model);
      jTable1.getColumn(columnNames[0]).setPreferredWidth(10);
        jTable1.getColumn(columnNames[1]).setPreferredWidth(20);
        jTable1.getColumn(columnNames[2]).setPreferredWidth(60);                  
    }
public void getCountClientsByAP(){
    List<Router> req= new ArrayList<Router>();

    req=ConnectionLite.getCountClientsByAP();
     Object columnNames[] = { "Router MAC", "SSID","Clientes","Fabricante del Router"};
      DefaultTableModel model = new DefaultTableModel(columnNames, 0);
      
      String[] reg=new String[4];      
        for (Router r : req){
            reg[0]=String.valueOf(r.Router_MAC);
            reg[1]=String.valueOf(r.Router_Nombre);
            reg[2]=String.valueOf(r.helperInt);            
            reg[3]=r.Router_Vendor;
             model.addRow(reg);
        }            
      jTable1.setModel(model);
      jTable1.getColumn(columnNames[0]).setPreferredWidth(10);
        jTable1.getColumn(columnNames[1]).setPreferredWidth(20);
        jTable1.getColumn(columnNames[2]).setPreferredWidth(60);                  
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
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analisis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cmbxFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtMAC;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
