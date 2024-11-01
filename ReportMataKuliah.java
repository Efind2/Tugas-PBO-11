/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugasjasper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Achmad
 */
public class ReportMataKuliah extends javax.swing.JFrame {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/Perkuliahan";
    String user = "postgres";
    String password = "123";

    /**
     * Creates new form ReportMataKuliah
     */
    public ReportMataKuliah() {
        initComponents();
        tampil();
    }

    public void tampil() {

        try {
            // TODO code application logi
            Class.forName(driver);
            String sql = "SELECT * FROM mataKuliah";
            conn = DriverManager.getConnection(koneksi, user, password);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {

                ResultSet rs = stmt.executeQuery(sql);
                this.tabelMatakuliah.setModel(DbUtils.resultSetToTableModel(rs));
                while (rs.next()) {
                    System.out.println(String.valueOf(rs.getObject(1)) + " " + String.valueOf(rs.getObject(2)) + " " + String.valueOf(rs.getObject(3)) + " " + String.valueOf(rs.getObject(4)));
                }
                conn.close();
            }

            stmt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
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
        txtKodemk = new javax.swing.JTextField();
        txtSKS = new javax.swing.JTextField();
        txtNamaMk = new javax.swing.JTextField();
        txtSemesterAjar = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMatakuliah = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("KODE MK");

        jLabel2.setText("SKS");

        jLabel3.setText("NAMA MK");

        jLabel4.setText("SEMESTER AJAR");

        txtKodemk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodemkActionPerformed(evt);
            }
        });

        txtSKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSKSActionPerformed(evt);
            }
        });

        txtNamaMk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaMkActionPerformed(evt);
            }
        });

        txtSemesterAjar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSemesterAjarActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        tabelMatakuliah.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelMatakuliah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMatakuliahMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelMatakuliah);

        jLabel5.setText("DATA MATA KULIAH");

        jButton1.setText("Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSemesterAjar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKodemk, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSKS, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamaMk, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnhapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(btnCetak))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtKodemk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNamaMk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSemesterAjar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnUpdate)
                            .addComponent(btnhapus)
                            .addComponent(btnCetak))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKodemkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodemkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodemkActionPerformed

    private void txtSKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSKSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSKSActionPerformed

    private void txtNamaMkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaMkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaMkActionPerformed

    private void txtSemesterAjarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSemesterAjarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSemesterAjarActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            conn = DriverManager.getConnection(koneksi, user, password);
            String sql = "select * from matakuliah";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            File alamat = new File(".");
            System.out.println(alamat.getCanonicalPath());
            //String dir = "/src/bayuJasper/";
            File jasperFile = new File(alamat.getCanonicalPath() + "/src/tugasjasper/" + "mataKuliah.jrxml");
            JasperDesign jd = JRXmlLoader.load(jasperFile);
            JRResultSetDataSource jds = new JRResultSetDataSource(rs);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, new HashMap<String, Object>(), jds);
            //String jrxmlFile = "src/pbopertemuan6/mahasiswa.jrxml";
            //FileInputStream inputStream = new FileInputStream(jrxmlFile);
            //JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, new HashMap<String, Object>(), conn);
            //JasperPrint jp = (JasperPrint) JasperFillManager.fillReportToFile(jr, null, conn);
            JasperViewer.viewReport(jp);
        } catch (SQLException ex) {
            Logger.getLogger(ReportMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReportMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (txtKodemk.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Kode MK belum diisi !");
        } else if (txtSKS.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, SKS belum diisi !");
        } else if (txtNamaMk.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Nama Mk belum diisi !");
        } else if (txtSemesterAjar.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Semester Ajar belum diisi !");
        } else {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(koneksi, user, password);
                conn.setAutoCommit(false);
                String sql = "INSERT INTO matakuliah VALUES(?,?,?,?)";
                pstmt = conn.prepareStatement(sql);

                int semesterajar = Integer.parseInt(txtSemesterAjar.getText());
                int sks = Integer.parseInt(txtSKS.getText());
                String kodemk, namamk;
                kodemk = txtKodemk.getText();
                namamk = txtNamaMk.getText();

                pstmt.setString(1, kodemk);
                pstmt.setInt(2, sks);
                pstmt.setString(3, namamk);
                pstmt.setInt(4, semesterajar);
                pstmt.executeUpdate();
                conn.commit();
                pstmt.close();
                conn.close();

            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, JOptionPane.INFORMATION_MESSAGE);
            }

        }
        tampil();
        reset();

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tabelMatakuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMatakuliahMouseClicked
        // TODO add your handling code here:
        int row = tabelMatakuliah.getSelectedRow();
        txtKodemk.setText(tabelMatakuliah.getValueAt(row, 0).toString());
        txtSKS.setText(tabelMatakuliah.getValueAt(row, 1).toString());
        txtNamaMk.setText(tabelMatakuliah.getValueAt(row, 2).toString());
        txtSemesterAjar.setText(tabelMatakuliah.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tabelMatakuliahMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int semesterajar = Integer.parseInt(txtSemesterAjar.getText());
        int sks = Integer.parseInt(txtSKS.getText());
        String kodemk, namamk;
        kodemk = txtKodemk.getText();
        namamk = txtNamaMk.getText();
        if (txtKodemk.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Kode Mk belum diisi !");
        } else if (txtSKS.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, SKS belum diisi !");
        } else if (txtNamaMk.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Nama mk belum diisi !");
        } else if (txtSemesterAjar.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Semester Ajar belum diisi !");
        } else {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(koneksi, user, password);
                String sql = "UPDATE matakuliah SET sks = ? , namamk = ? , semesterajar = ? WHERE kodemk = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, sks);
                pstmt.setString(2, namamk);
                pstmt.setInt(3, semesterajar);
                pstmt.setString(4, kodemk);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
                    pstmt.close();
                    conn.close();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "TERJADI KESALAHAN" + ex.getMessage());
            }

        }
        tampil();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        String kodemk = txtKodemk.getText();
        if (kodemk.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode Mk tidak boleh kosong");
            tabelMatakuliah.requestFocus();
        } else if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus data ini?",
                "Informasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.OK_OPTION) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(koneksi, user, password);
                Statement stt = conn.createStatement();
                stt.executeUpdate("DELETE FROM matakuliah WHERE kodemk ='" + kodemk + "'");
                reset();
                tampil();
                JOptionPane.showMessageDialog(this, "Data berhasil di hapus", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Delete data gagal\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            System.out.println("yang dipilih : " + filePilihan.getAbsolutePath());
            try {
                BufferedReader br = new BufferedReader(new FileReader(filePilihan));
                String baris = new String("");
                String pemisah = ";";
                while ((baris = br.readLine()) != null) //returns a Boolean value
                {
                    String[] dataMhs = baris.split(pemisah);
                    String kodemk = dataMhs[0];
                    String sks = dataMhs[1];
                    String namamk = dataMhs[2];
                    String semester = dataMhs[3];
                    
                    if (!kodemk.isEmpty() && !namamk.isEmpty()) {
                        conn = DriverManager.getConnection(koneksi, user, password);
                        conn.setAutoCommit(false);
                        String sql = "INSERT INTO matakuliah VALUES(?,?,?,?)";
                        pstmt = conn.prepareStatement(sql);
  
                        pstmt.setString(1, kodemk);
                        pstmt.setInt(2, Integer.parseInt(sks));
                        pstmt.setString(3, namamk);
                        pstmt.setInt(4, Integer.parseInt(semester));
                        pstmt.executeUpdate();
                        conn.commit();
                        pstmt.close();
                        conn.close();

                    }
                    
                }
                JOptionPane.showMessageDialog(null, "Data berhasil diupload");
                tampil();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReportMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReportMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ReportMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    public void reset() {
        txtKodemk.setText("");
        txtSKS.setText("");
        txtNamaMk.setText("");
        txtSemesterAjar.setText("");
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
            java.util.logging.Logger.getLogger(ReportMataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportMataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportMataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportMataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportMataKuliah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelMatakuliah;
    private javax.swing.JTextField txtKodemk;
    private javax.swing.JTextField txtNamaMk;
    private javax.swing.JTextField txtSKS;
    private javax.swing.JTextField txtSemesterAjar;
    // End of variables declaration//GEN-END:variables
}
