/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PerbankanView;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import perbankan.*;
import PerbankanView.*;

/**
 *
 * @author Dukhaan
 */
public class TarikUangView extends javax.swing.JPanel {

    private javax.swing.JTable tableNasabah;
    private MainFrame mainFrame;
    private Nasabah nasabah;

    /**
     * Creates new form TarikUangView
     */
    public TarikUangView(MainFrame mainFrame, Nasabah nasabah) {
        initComponents();
        this.mainFrame = mainFrame;
        this.nasabah = nasabah;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        inputAmbilUang = new javax.swing.JTextField();
        buttonSimpanAmbil = new javax.swing.JButton();
        buttonKembaliAmbil = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Masukkan uang :");

        inputAmbilUang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAmbilUangActionPerformed(evt);
            }
        });

        buttonSimpanAmbil.setText("Simpan");
        buttonSimpanAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanAmbilActionPerformed(evt);
            }
        });

        buttonKembaliAmbil.setText("Kembali");
        buttonKembaliAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKembaliAmbilActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Ambil Uang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputAmbilUang, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonSimpanAmbil)
                        .addGap(33, 33, 33)
                        .addComponent(buttonKembaliAmbil)
                        .addGap(36, 36, 36)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputAmbilUang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpanAmbil)
                    .addComponent(buttonKembaliAmbil))
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputAmbilUangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAmbilUangActionPerformed
        Bank bank = new Bank();

        String tarikanSaldo = inputAmbilUang.getText();

        try {
            // Mengonversi tarikanSaldo menjadi tipe data integer
            int jumlahTarikan = Integer.parseInt(tarikanSaldo);
            int selectedRow = tableNasabah.getSelectedRow();

            if (selectedRow >= 0) {
                int rowIndex = tableNasabah.convertRowIndexToModel(selectedRow);
                Nasabah nasabah = bank.getNasabah(rowIndex);

                if (nasabah != null) {
                    Tabungan tabungan = nasabah.getTabungan();

                    if (jumlahTarikan <= 0) {
                        JOptionPane.showMessageDialog(this, "Jumlah saldo yang akan ditarik harus lebih dari 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (jumlahTarikan > tabungan.getSaldo()) {
                        JOptionPane.showMessageDialog(this, "Saldo tidak mencukupi untuk penarikan ini.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        tabungan.ambilUang(jumlahTarikan);

                        DefaultTableModel model = (DefaultTableModel) tableNasabah.getModel();
                        model.setValueAt(tabungan.getSaldo(), selectedRow, 3);

                        inputAmbilUang.setText("");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris Nasabah yang akan menarik saldo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah saldo yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_inputAmbilUangActionPerformed

    private void buttonSimpanAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanAmbilActionPerformed
        if (nasabah != null) {
            // Memeriksa apakah inputSaldo kosong atau tidak
            if (inputAmbilUang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Isi jumlah saldo yang akan diambil.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    // Mendapatkan jumlah saldo yang akan diambil dari inputSaldo
                    String jumlahAmbil = inputAmbilUang.getText(); // Mengubah ke String

                    // Memastikan jumlahAmbil positif
                    int saldoPengurangan = Integer.parseInt(jumlahAmbil);
                    if (saldoPengurangan <= 0) {
                        JOptionPane.showMessageDialog(this, "Jumlah saldo yang akan diambil harus lebih dari 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Mendapatkan objek Tabungan dari Nasabah
                        Tabungan tabungan = nasabah.getTabungan();

                        // Memeriksa apakah saldo mencukupi untuk pengurangan
                        if (saldoPengurangan > tabungan.getSaldo()) {
                            JOptionPane.showMessageDialog(this, "Saldo tidak mencukupi untuk pengurangan ini.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // Mengurangkan saldo sesuai dengan jumlahAmbil
                            tabungan.ambilUang(saldoPengurangan);

                            // Mengosongkan inputSaldo
                            inputAmbilUang.setText("");
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Masukkan jumlah saldo yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_buttonSimpanAmbilActionPerformed

    private void buttonKembaliAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKembaliAmbilActionPerformed
        mainFrame.showView(new BankView(mainFrame));
    }//GEN-LAST:event_buttonKembaliAmbilActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonKembaliAmbil;
    private javax.swing.JButton buttonSimpanAmbil;
    private javax.swing.JTextField inputAmbilUang;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
