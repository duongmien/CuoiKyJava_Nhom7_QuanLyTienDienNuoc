/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import account.HoaDon;
import account.KhachHangTK;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import servicecuaHa.ServiceH;
/**
 *
 * @author PC
 */
public class ThongKeForm extends javax.swing.JFrame {
ServiceH serviceH;
    DefaultTableModel defaultTableModelTTKH;
    DefaultTableModel defaultTableModel;
    DefaultTableModel defaultTableModelTK;
    String lenh;

    /**
     * Creates new form ThongKeForm
     */
    public ThongKeForm() {
        initComponents();
        serviceH = new ServiceH();
        defaultTableModelTTKH = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableChiTiet1.setModel(defaultTableModelTTKH);

        defaultTableModelTTKH.addColumn("Ngày Tạo");
        defaultTableModelTTKH.addColumn("Tên Quận");
        defaultTableModelTTKH.addColumn("Tổng Tiêu Thụ");
        
        lenh = "select ngaytao, tenquan, sum(tongtiendien+tongtiennuoc) as tong from tblhoadon as hd, khachhang as kh, (select ngaytaohd as ngaytao, idhd from tblhoadon) as tam  where hd.makh=kh.makh and tam.idhd=hd.idhd group by tenquan, ngaytao";
        setDataThongKe3(serviceH.getAllHoaDon(lenh));
        
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableChiTiet2.setModel(defaultTableModel);

        defaultTableModel.addColumn("Mã KH");
        defaultTableModel.addColumn("Ngày Tạo");
        defaultTableModel.addColumn("Tên Khách Hàng");
        defaultTableModel.addColumn("Tổng Tiêu Thụ");
        
        lenh = "select ngaytao , kh.tenkh, kh.makh, sum(tongtiendien+tongtiennuoc) as tong from tblhoadon as hd, khachhang as kh, (select ngaytaohd as ngaytao, idhd from tblhoadon) as tam  where hd.makh=kh.makh and tam.idhd=hd.idhd group by ngaytao , kh.tenkh, kh.makh";
        setDataThongKe4(serviceH.getAllKH(lenh));
        
        defaultTableModelTK = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableTongTien.setModel(defaultTableModelTK);

        defaultTableModelTK.addColumn("Thời Gian");
        defaultTableModelTK.addColumn("Tổng Tiêu Thụ");
        lenh = "select ngaytao, ngaytao as tenquan,sum(tongtiendien+tongtiennuoc) as tong from tblhoadon as hd, (select ngaytaohd as ngaytao, idhd from tblhoadon) as tam  where  tam.idhd=hd.idhd group by ngaytao";
        setDataThongKe2(serviceH.getAllHoaDon(lenh));
    }
    //table thống kê
    private void setDataThongKe2(List<HoaDon> khachHangs) {
        for (HoaDon khachHang : khachHangs) {
            defaultTableModelTK.addRow(new Object[]{khachHang.getNgaytao(), khachHang.getTong()});
        }
    }

    private void setDataThongKe3(List<HoaDon> khachHangs) {
        for (HoaDon khachHang : khachHangs) {
            defaultTableModelTTKH.addRow(new Object[]{khachHang.getNgaytao(), khachHang.getTenquan(), khachHang.getTong()});
        }
    }
    
    private void setDataThongKe4(List<KhachHangTK> khachHangs) {
        for (KhachHangTK khachHang : khachHangs) {
            defaultTableModel.addRow(new Object[]{khachHang.getMakh(), khachHang.getNgaytao(), khachHang.getTenkh(), khachHang.getTong()});
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

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ClearTK = new javax.swing.JButton();
        dsThongKe = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableChiTiet1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableChiTiet2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTongTien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        back5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setBackground(new java.awt.Color(255, 102, 102));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 51));
        jLabel3.setText("THỐNG KÊ");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 51));
        jLabel4.setText("Thống Kê Theo:");

        ClearTK.setBackground(new java.awt.Color(255, 102, 0));
        ClearTK.setText("Clear");
        ClearTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearTKActionPerformed(evt);
            }
        });

        dsThongKe.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dsThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống Kê Theo Tháng", "Thống Kê Theo Năm", " " }));
        dsThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsThongKeActionPerformed(evt);
            }
        });

        tableChiTiet1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableChiTiet1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Khu Vực", jPanel1);

        tableChiTiet2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableChiTiet2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Khách Hàng", jPanel3);

        tableTongTien.setModel(new javax.swing.table.DefaultTableModel(
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
        tableTongTien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTongTienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableTongTien);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dsThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ClearTK, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(40, 40, 40)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dsThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClearTK, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs_QLTD/tien.png"))); // NOI18N

        back5.setBackground(new java.awt.Color(255, 255, 255));
        back5.setText("Trở lại");
        back5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back5MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs_QLTD/x.png"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back5)
                        .addGap(44, 44, 44)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ClearTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearTKActionPerformed
        // TODO add your handling code here:
        defaultTableModelTTKH.setRowCount(0);
        
        defaultTableModelTK.setRowCount(0);
    }//GEN-LAST:event_ClearTKActionPerformed

    private void dsThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsThongKeActionPerformed
        // TODO add your handling code here:
        String loai = String.valueOf(dsThongKe.getSelectedItem());
        switch (loai) {
            case "Thống Kê Theo Tháng":
                lenh = "select ngaytao, ngaytao as tenquan,sum(tongtiendien+tongtiennuoc) as tong from tblhoadon as hd, (select concat(month(ngaytaohd),'/',year(ngaytaohd)) as ngaytao, idhd from tblhoadon) as tam  where  tam.idhd=hd.idhd group by ngaytao";
                defaultTableModelTK.setRowCount(0);
                setDataThongKe2(serviceH.getAllHoaDon(lenh));
                break;
            case "Thống Kê Theo Năm":
                lenh = "select ngaytao, ngaytao as tenquan, sum(tongtiendien+tongtiennuoc) as tong from tblhoadon as hd, (select year(ngaytaohd) as ngaytao, idhd from tblhoadon) as tam  where  tam.idhd=hd.idhd group by ngaytao";
                defaultTableModelTK.setRowCount(0);
                setDataThongKe2(serviceH.getAllHoaDon(lenh));
                break;
        }
    }//GEN-LAST:event_dsThongKeActionPerformed

    private void tableTongTienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTongTienMouseClicked
        // TODO add your handling code here:
        int row = tableTongTien.getSelectedRow();
        String tg = String.valueOf(tableTongTien.getValueAt(row, 0));
        String loai = String.valueOf(dsThongKe.getSelectedItem());
        switch (loai) {
            case "Thống Kê Theo Tháng":
                lenh = "select ngaytao, tenquan, sum(tongtiendien+tongtiennuoc) as tong from tblhoadon as hd, khachhang as kh, (select concat(month(ngaytaohd),'/',year(ngaytaohd)) as ngaytao, idhd from tblhoadon) as tam  where hd.makh=kh.makh and tam.idhd=hd.idhd and ngaytao = '"+tg+"' group by tenquan, ngaytao ";
                defaultTableModelTTKH.setRowCount(0);
                setDataThongKe3(serviceH.getAllHoaDon(lenh));
                
                lenh = "select ngaytao, kh.makh, kh.tenkh ,sum(tongtiendien+tongtiennuoc) as tong from tblhoadon as hd, khachhang as kh, (select concat(month(ngaytaohd),'/',year(ngaytaohd)) as ngaytao, idhd from tblhoadon) as tam  where hd.makh=kh.makh and tam.idhd=hd.idhd and ngaytao = '"+tg+"' group by  ngaytao , kh.tenkh, kh.makh";
                defaultTableModel.setRowCount(0);
                setDataThongKe4(serviceH.getAllKH(lenh));
                break;
            case "Thống Kê Theo Năm":
                lenh = "select ngaytao, tenquan, sum(tongtiendien+tongtiennuoc) as tong from tblhoadon as hd, khachhang as kh, (select year(ngaytaohd) as ngaytao, idhd from tblhoadon) as tam  where hd.makh=kh.makh and tam.idhd=hd.idhd  and ngaytao = '"+tg+"' group by tenquan, ngaytao";
                defaultTableModelTTKH.setRowCount(0);
                setDataThongKe3(serviceH.getAllHoaDon(lenh));          
                lenh = "select ngaytao, kh.makh, kh.tenkh ,sum(tongtiendien+tongtiennuoc) as tong from tblhoadon as hd, khachhang as kh, (select year(ngaytaohd) as ngaytao, idhd from tblhoadon) as tam  where hd.makh=kh.makh and tam.idhd=hd.idhd and ngaytao = '"+tg+"' group by  ngaytao , kh.tenkh, kh.makh";
                defaultTableModel.setRowCount(0);
                setDataThongKe4(serviceH.getAllKH(lenh));
                break;
        }
    }//GEN-LAST:event_tableTongTienMouseClicked

    private void back5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back5MouseClicked
        // TODO add your handling code here:
        new TrangChuNhanVien().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back5MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

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
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearTK;
    private javax.swing.JButton back5;
    private javax.swing.JComboBox<String> dsThongKe;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableChiTiet1;
    private javax.swing.JTable tableChiTiet2;
    private javax.swing.JTable tableTongTien;
    // End of variables declaration//GEN-END:variables
}
