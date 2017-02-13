/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perkembangannilai;

import java.io.InputStream;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import koneksi.databaseconnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Brilliant
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    Connection koneksi;
    DefaultTableModel dtm = new DefaultTableModel(
    ){
    @Override
    public boolean isCellEditable(int row,int column){
            return false;
            };
    };
    public MainMenu(String kelas) {
        initComponents();
        jTable2.setModel(dtm);
        dtm.addColumn("No");
        dtm.addColumn("NIS");
        dtm.addColumn("Nama");
        dtm.addColumn("Tanggal Lahir");
        dtm.addColumn("Kelas");
        koneksi = databaseconnection.getKoneksi("localhost", "3306", "root", 
                "", "db_pbo_report_nilai");
        UpdateTable(kelas);
        jLabel2.setText(kelas);
    }
    
    
    public void UpdateTable(String kelas){
        dtm.getDataVector().removeAllElements();
        dtm.fireTableDataChanged();
        int i = 1;
        try{
        Statement s = koneksi.createStatement();
        String sql = "SELECT * FROM t_siswa WHERE kelas = '"+kelas+"' ORDER BY nama ASC";
        ResultSet r = s.executeQuery(sql);
        while(r.next()){
               Object [] o = new Object[5];
               o[0] = i;
               o[1] = r.getString("nis");
               o[2] = r.getString("nama");
               o[3] = r.getString("tanggal_lahir");
               o[4] = r.getString("kelas");
               dtm.addRow(o);
               i++;
            }
        r.close();
        s.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Koneksi" + e);
        }
    }
    
    private List getData(String nis) {
        List dataSiswa = new ArrayList();
        
        String tampilData = "SELECT * FROM t_siswa INNER JOIN t_nilai ON t_siswa.nis = t_nilai.nis WHERE t_siswa.nis = '"+nis+"'";
        
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet res = stmt.executeQuery(tampilData);
            
            if (res != null) {
                res.next();
                String nama = res.getString("nama");
                String kelas = res.getString("kelas");
                String ttl = res.getString("tanggal_lahir");
                String kk = res.getString("kk");
                Float pai1 = res.getFloat("pai1");
                Float pai2 = res.getFloat("pai2");
                Float pai3 = res.getFloat("pai3");
                Float pai4 = res.getFloat("pai4");
                Float pai5 = res.getFloat("pai5");
                Float pai6 = res.getFloat("pai6");
                
                Float pkn1 = res.getFloat("pkn1");
                Float pkn2 = res.getFloat("pkn2");
                Float pkn3 = res.getFloat("pkn3");
                Float pkn4 = res.getFloat("pkn4");
                Float pkn5= res.getFloat("pkn5");
                Float pkn6 = res.getFloat("pkn6");
                
                Float ind1 = res.getFloat("bind1");
                Float ind2 = res.getFloat("bind2");
                Float ind3 = res.getFloat("bind3");
                Float ind4 = res.getFloat("bind4");
                Float ind5 = res.getFloat("bind5");
                Float ind6 = res.getFloat("bind6");
                
                Float ing1 = res.getFloat("bing1");
                Float ing2 = res.getFloat("bing2");
                Float ing3 = res.getFloat("bing3");
                Float ing4 = res.getFloat("bing4");
                Float ing5 = res.getFloat("bing5");
                Float ing6 = res.getFloat("bing6");
                
                
                Float mtk1 = res.getFloat("mtk1");
                Float mtk2 = res.getFloat("mtk2");
                Float mtk3 = res.getFloat("mtk3");
                Float mtk4 = res.getFloat("mtk4");
                Float mtk5 = res.getFloat("mtk5");
                Float mtk6 = res.getFloat("mtk6");
                
                Float pjok1 = res.getFloat("pjok1");
                Float pjok2 = res.getFloat("pjok2");
                Float pjok3 = res.getFloat("pjok3");
                Float pjok4 = res.getFloat("pjok4");
                Float pjok5 = res.getFloat("pjok5");
                Float pjok6 = res.getFloat("pjok6");
                
                Float kwu1 = res.getFloat("kwu1");
                Float kwu2 = res.getFloat("kwu2");
                Float kwu3 = res.getFloat("kwu3");
                Float kwu4 = res.getFloat("kwu4");
                Float kwu5 = res.getFloat("kwu5");
                Float kwu6 = res.getFloat("kwu6");
                
                Float prod1 = res.getFloat("pro1");
                Float prod2 = res.getFloat("pro2");
                Float prod3 = res.getFloat("pro3");
                Float prod4 = res.getFloat("pro4");
                Float prod5 = res.getFloat("pro5");
                Float prod6 = res.getFloat("pro6");
                
                PerkembanganNilai obj = new PerkembanganNilai();
                    
                obj.setNAMA(nama);
                obj.setKELAS(kelas);
                obj.setTTL(ttl);
                obj.setKK(kk);
                
                obj.setPAI1(pai1);
                obj.setPAI2(pai2);
                obj.setPAI3(pai3);
                obj.setPAI4(pai4);
                obj.setPAI5(pai5);
                obj.setPAI6(pai6);
                
                obj.setPKN1(pkn1);
                obj.setPKN2(pkn2);
                obj.setPKN3(pkn3);
                obj.setPKN4(pkn4);
                obj.setPKN5(pkn5);
                obj.setPKN6(pkn6);
                
                obj.setIND1(ind1);
                obj.setIND2(ind2);
                obj.setIND3(ind3);
                obj.setIND4(ind4);
                obj.setIND5(ind5);
                obj.setIND6(ind6);
                
                obj.setING1(ing1);
                obj.setING2(ing2);
                obj.setING3(ing3);
                obj.setING4(ing4);
                obj.setING5(ing5);
                obj.setING6(ing6);
                
                obj.setMTK1(mtk1);
                obj.setMTK2(mtk2);
                obj.setMTK3(mtk3);
                obj.setMTK4(mtk4);
                obj.setMTK5(mtk5);
                obj.setMTK6(mtk6);
                
                obj.setPJOK1(pjok1);
                obj.setPJOK2(pjok2);
                obj.setPJOK3(pjok3);
                obj.setPJOK4(pjok4);
                obj.setPJOK5(pjok5);
                obj.setPJOK6(pjok6);
                
                obj.setKWU1(kwu1);
                obj.setKWU2(kwu2);
                obj.setKWU3(kwu3);
                obj.setKWU4(kwu4);
                obj.setKWU5(kwu5);
                obj.setKWU6(kwu6);
                
                obj.setPROD1(prod1);
                obj.setPROD2(prod2);
                obj.setPROD3(prod3);
                obj.setPROD4(prod4);
                obj.setPROD5(prod5);
                obj.setPROD6(prod6);
                
                dataSiswa.add(obj);
            } else {
                JOptionPane.showMessageDialog(null, "Data Kosong");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return dataSiswa;
    }
    
    private void callReport(String nis) {
        try {
            JRBeanCollectionDataSource dataSource = 
                new JRBeanCollectionDataSource(getData(nis), false);
        
            HashMap param = new HashMap();

            String reportName = "PerkembanganNilai.jasper";

            ClassLoader cl = getClass().getClassLoader();
            InputStream inReportFile = cl.getResourceAsStream(reportName);

            JasperPrint print = JasperFillManager.fillReport(inReportFile, param, dataSource);

            JasperViewer.viewReport(print, false);
        } catch(Exception e) {
            e.printStackTrace();
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

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnLihat = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perkembangan Nilai Siswa");
        setResizable(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih Kelas--", "XII-AVI1", "XII-AVI2", "XII-AVI3", "XII-TITL1", "XII-TITL2", "XII-TOI1", "XII-TOI2", "XII-TKJ1", "XII-RPL1", "XII-RPL2", "XII-RPL3", "XII-MM1" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel1.setText("Perkembangan Nilai Siswa SMKN 4 Bandung Angkatan 2012 - 2013");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("jLabel2");

        btnLihat.setText("Lihat Laporan");
        btnLihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatActionPerformed(evt);
            }
        });

        jMenu3.setText("Theme");

        jMenuItem1.setText("MacWin");
        jMenuItem1.setName("MacWin"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("HifiLook");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Acryl");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Mint Look");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(551, 551, 551)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 312, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(122, 122, 122)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnLihat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLihat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String tema = "mcwin.McWinLookAndFeel";

        changeTheme(tema);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String tema = "hifi.HiFiLookAndFeel";
        
        changeTheme(tema);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String tema = "acryl.AcrylLookAndFeel";
        changeTheme(tema);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String tema = "mint.MintLookAndFeel";
        changeTheme(tema);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String kelas = (String) jComboBox1.getSelectedItem();
        UpdateTable(kelas);
        
        super.dispose();
        MainMenu m = new MainMenu(kelas);
        
        m.setVisible(true);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void btnLihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatActionPerformed
         int row = jTable2.getSelectedRow();
         Object nis = jTable2.getValueAt(row, 1);
        
        callReport(nis.toString());
    }//GEN-LAST:event_btnLihatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
        UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        SwingUtilities.updateComponentTreeUI(new MainMenu("XII-AVI1"));
    } catch (Exception e){
 
    }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu("XII-AVI1").setVisible(true);
            }
        });
    }
    
    public void changeTheme(String nameTheme){
        try {
        
        UIManager.setLookAndFeel("com.jtattoo.plaf."+nameTheme);
        SwingUtilities.updateComponentTreeUI(new MainMenu("XII-AVI1"));
        
    } catch (Exception e){
    }
        super.dispose();
        MainMenu m = new MainMenu("XII-AVI1");
        
        m.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLihat;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
