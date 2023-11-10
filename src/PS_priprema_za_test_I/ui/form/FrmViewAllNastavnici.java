/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package PS_priprema_za_test_I.ui.form;

import PS_priprema_za_test_I.domain.Nastavnik;
import PS_priprema_za_test_I.repository.DatabaseRepository;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aleks
 */
public class FrmViewAllNastavnici extends javax.swing.JDialog {

    private List<Nastavnik> nastavnici;

    /**
     * Creates new form FrmViewAllNastavnici
     */
    public FrmViewAllNastavnici(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblNastavnici = new javax.swing.JTable();
        btnDetalji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblNastavnici.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ime", "Prezime", "Zvanje"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNastavnici);

        btnDetalji.setText("Detalji");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnDetalji)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        int selected = tblNastavnici.getSelectedRow();
        Nastavnik nastavnik;
        if (selected != -1){
            nastavnik = nastavnici.get(selected);
            new FrmDetalji(null, true, nastavnik).setVisible(true);
        }
    }//GEN-LAST:event_btnDetaljiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNastavnici;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        try {
            nastavnici = new DatabaseRepository().getAllNastavnici();
            nastavnici.sort(new Comparator<Nastavnik>() {
                @Override
                public int compare(Nastavnik o1, Nastavnik o2) {
                    return o1.getZvanje().getNaziv().compareToIgnoreCase(o2.getZvanje().getNaziv());
                }
            });
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblNastavnici.getModel();
            Object[] rowData = new Object[3];
            for (Nastavnik nastavnik : nastavnici) {
                rowData[0] = nastavnik.getIme();
                rowData[1] = nastavnik.getPrezime();
                rowData[2] = nastavnik.getZvanje().getNaziv();
                defaultTableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmViewAllNastavnici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
