/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uaspbokelompok;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author iilha
 */
public class TransaksiPembayaran extends javax.swing.JFrame {

    /**
     * Creates new form TransaksiPembayaran
     */
    public TransaksiPembayaran() {
        initComponents();
        loadDataProsesPesanan();
        initComboBox();
    }
    
     public final void initComboBox() {
        jcomboboxLayanan.addItem("Motor");
        jcomboboxLayanan.addItem("Mobil");
        jcomboboxMetode.addItem("Cuci Kering");
        jcomboboxMetode.addItem("Cuci Kering + Setrika");
    }
     
    private void loadDataProsesPesanan() {
    try {
        // Koneksi ke database
        java.sql.Connection conn = KoneksiDB.konek();
        String sql = "SELECT * FROM prosespesanan"; // Query SQL untuk mengambil semua data
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery();

        // Menghapus data lama di JTable (jika ada)
        DefaultTableModel model = (DefaultTableModel) tabelProsesPesanan.getModel();
        model.setRowCount(0);

        // Iterasi data dari ResultSet ke JTable
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("order_id"),
                rs.getTimestamp("tanggalmasuk"),
                rs.getString("nama_customer"),
                rs.getString("no_telepon"),
                rs.getString("alamat"),
                rs.getString("layanan"),
                rs.getString("metode"),
                rs.getDouble("hargatotal")
            });
        }
    } catch (SQLException | ClassNotFoundException e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
    }
}
 
    private void hitungKembalian() {
    try {
        // Ambil nilai dari text field
        double hargaTotal = Double.parseDouble(txtHargaTotal.getText());
        double bayar = Double.parseDouble(txtBayar.getText());

        // Hitung kembalian
        double kembalian = bayar - hargaTotal;

        // Tampilkan hasil ke text field Kembalian
        txtKembalian.setText(String.valueOf(kembalian));

        // Tambahkan pesan sukses jika perlu
        JOptionPane.showMessageDialog(this, "Kembalian berhasil dihitung!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    } catch (NumberFormatException e) {
        // Jika input tidak valid (misalnya kosong atau bukan angka), tampilkan pesan error
        JOptionPane.showMessageDialog(this, "Masukkan angka yang valid pada field Bayar dan Harga Total!", "Error", JOptionPane.ERROR_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtOrderId = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        txtNoTelepon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelProsesPesanan = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHargaTotal = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        txtKembalian = new javax.swing.JTextField();
        buttonBack = new javax.swing.JButton();
        buttonHitung = new javax.swing.JButton();
        jcomboboxLayanan = new javax.swing.JComboBox<>();
        jcomboboxMetode = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtTanggalMasuk = new javax.swing.JTextField();
        buttonTransaksi = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel1.setText("Pembayaran");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 16, -1, -1));

        jLabel2.setText("Order ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 59, -1, -1));

        jLabel3.setText("Nama");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 96, -1, -1));

        jLabel4.setText("Alamat");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 136, -1, -1));

        jLabel5.setText("No. Telepon");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 178, -1, -1));
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 93, 150, -1));
        getContentPane().add(txtOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 53, 150, -1));
        getContentPane().add(txtAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 133, 150, -1));
        getContentPane().add(txtNoTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 175, 150, -1));

        jLabel6.setText("Layanan Antar Jemput");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jLabel7.setText("Metode Cucian");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        tabelProsesPesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Tanggal Masuk", "Nama Customer", "No. Telepon", "Alamat", "Layanan", "Metode Cuci", "Harga Total"
            }
        ));
        tabelProsesPesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelProsesPesananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelProsesPesanan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 215, 782, 200));

        jLabel8.setText("Harga Total");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 461, -1, -1));

        jLabel9.setText("Bayar");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 533, -1, -1));

        jLabel10.setText("Kembalian");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, -1, -1));
        getContentPane().add(txtHargaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 458, 150, -1));

        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 530, 150, -1));
        getContentPane().add(txtKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 150, -1));

        buttonBack.setText("Back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        getContentPane().add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 595, -1, -1));

        buttonHitung.setText("Count");
        buttonHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHitungActionPerformed(evt);
            }
        });
        getContentPane().add(buttonHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 595, -1, -1));

        jcomboboxLayanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        jcomboboxLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboboxLayananActionPerformed(evt);
            }
        });
        getContentPane().add(jcomboboxLayanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 150, -1));

        jcomboboxMetode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        jcomboboxMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboboxMetodeActionPerformed(evt);
            }
        });
        getContentPane().add(jcomboboxMetode, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 150, -1));

        jLabel11.setText("Tanggal Masuk");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));
        getContentPane().add(txtTanggalMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 150, -1));

        buttonTransaksi.setText("Transaksi");
        buttonTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(buttonTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Transaksi Pembayaran.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        // TODO add your handling code here:
        new MenuHalamanAdmin().setVisible(true); // Pergi Ke MenuHalamanAdmin
            dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void tabelProsesPesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelProsesPesananMouseClicked
        // TODO add your handling code here:
        // Ambil baris yang dipilih
    int selectedRow = tabelProsesPesanan.getSelectedRow();
    DefaultTableModel model = (DefaultTableModel) tabelProsesPesanan.getModel();

    // Pastikan ada baris yang dipilih
    if (selectedRow != -1) {
        // Isi form dengan data dari JTable
        txtOrderId.setText(model.getValueAt(selectedRow, 0).toString()); // order_id
        txtTanggalMasuk.setText(model.getValueAt(selectedRow, 1).toString()); // tanggalmasuk
        txtNama.setText(model.getValueAt(selectedRow, 2).toString()); // nama_customer
        txtNoTelepon.setText(model.getValueAt(selectedRow, 3).toString()); // no_telepon
        txtAlamat.setText(model.getValueAt(selectedRow, 4).toString()); // alamat
        jcomboboxLayanan.setSelectedItem(model.getValueAt(selectedRow, 5).toString()); // layanan
        jcomboboxMetode.setSelectedItem(model.getValueAt(selectedRow, 6).toString()); // metode
        txtHargaTotal.setText(model.getValueAt(selectedRow, 7).toString()); // hargatotal
    } else {
        JOptionPane.showMessageDialog(this, "Tidak ada baris yang dipilih!");
    }
    }//GEN-LAST:event_tabelProsesPesananMouseClicked

    private void jcomboboxLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboboxLayananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboboxLayananActionPerformed

    private void jcomboboxMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboboxMetodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboboxMetodeActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBayarActionPerformed

    private void buttonHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHitungActionPerformed
        // TODO add your handling code here:
        try {
        // Ambil nilai dari text field
        double hargaTotal = Double.parseDouble(txtHargaTotal.getText());
        double bayar = Double.parseDouble(txtBayar.getText());

        // Cek apakah nominal bayar mencukupi
        if (bayar < hargaTotal) {
            // Jika kurang, tampilkan pesan
            JOptionPane.showMessageDialog(this, "Saldo Anda kurang!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            txtKembalian.setText("0"); // Pastikan kembalian direset ke 0
        } else {
            // Hitung kembalian
            double kembalian = bayar - hargaTotal;

            // Tampilkan hasil ke text field Kembalian
            txtKembalian.setText(String.valueOf(kembalian));
        }
    } catch (NumberFormatException e) {
        // Tampilkan pesan error jika input tidak valid
        JOptionPane.showMessageDialog(this, "Masukkan angka yang valid untuk Bayar dan Harga Total!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_buttonHitungActionPerformed

    private void buttonTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTransaksiActionPerformed
        // TODO add your handling code here:
        // Mengambil data dari JTextField
    String orderID = txtOrderId.getText();
    String nama = txtNama.getText();
    String alamat = txtAlamat.getText();
    String noTelepon = txtNoTelepon.getText();
    String tanggalMasuk = txtTanggalMasuk.getText();
    String layanan = jcomboboxLayanan.getSelectedItem().toString();
    String metodeCuci = jcomboboxMetode.getSelectedItem().toString();
    String hargaTotal = txtHargaTotal.getText();
    String bayar = txtBayar.getText();
    String kembalian = txtKembalian.getText();

    // Validasi jika ada data yang kosong
    if (orderID.isEmpty() || nama.isEmpty() || alamat.isEmpty() || noTelepon.isEmpty() ||
        tanggalMasuk.isEmpty() || layanan.isEmpty() || metodeCuci.isEmpty() || hargaTotal.isEmpty() || bayar.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap isi semua data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Menampilkan notifikasi pembayaran berhasil
    String message = "Pembayaran berhasil!\n\n" +
                     "Order ID: " + orderID + "\n" +
                     "Nama: " + nama + "\n" +
                     "Alamat: " + alamat + "\n" +
                     "No. Telepon: " + noTelepon + "\n" +
                     "Tanggal Masuk: " + tanggalMasuk + "\n" +
                     "Layanan: " + layanan + "\n" +
                     "Metode Cuci: " + metodeCuci + "\n" +
                     "Harga Total: " + hargaTotal + "\n" +
                     "Bayar: " + bayar + "\n" +
                     "Kembalian: " + kembalian;
    
    JOptionPane.showMessageDialog(this, message, "Pembayaran Berhasil", JOptionPane.INFORMATION_MESSAGE);

    // Reset semua field setelah transaksi
    txtOrderId.setText("");
    txtNama.setText("");
    txtAlamat.setText("");
    txtNoTelepon.setText("");
    txtTanggalMasuk.setText("");
    jcomboboxLayanan.setSelectedIndex(0);
    jcomboboxMetode.setSelectedIndex(0);
    txtHargaTotal.setText("");
    txtBayar.setText("");
    txtKembalian.setText("");
    }//GEN-LAST:event_buttonTransaksiActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiPembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonHitung;
    private javax.swing.JButton buttonTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcomboboxLayanan;
    private javax.swing.JComboBox<String> jcomboboxMetode;
    private javax.swing.JTable tabelProsesPesanan;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHargaTotal;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoTelepon;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtTanggalMasuk;
    // End of variables declaration//GEN-END:variables
}
