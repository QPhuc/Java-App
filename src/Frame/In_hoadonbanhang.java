
package Frame;

import DBConnect.MySQLConnUtils;
import GUI.GUIBaocao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class In_hoadonbanhang extends javax.swing.JFrame {
    public In_hoadonbanhang() {
        initComponents();
        loadData();
        table();
        setLocationRelativeTo(null);
    }
    Connection dbConnection = null;
    Statement statement = null;
    public void loadData() {
        // Clear table
        tbl_data.setModel(new DefaultTableModel());
        // Model for Table
        DefaultTableModel model = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return String.class;
                case 4:
                    return String.class;
                case 5:
                    return String.class;
                default:
                    return String.class;        
              }
            }
        };
        tbl_data.setModel(model);

        // Add Column
        model.addColumn("STT");
        model.addColumn("Tên hàng hóa, dịch vụ");
        model.addColumn("Đơn vị tính");
        model.addColumn("Số lượng");
        model.addColumn("Đơn giá");
        model.addColumn("Thành tiền");

        String sql = "SELECT * FROM hang,donvitinh,chitietxuat,chitietnhap "
                + "WHERE donvitinh.Ma_dvt=hang.Ma_dvt AND chitietxuat.Ma_hang=hang.Ma_hang "
                + "AND chitietnhap.Ma_hang=hang.Ma_hang";
        try {
            dbConnection = MySQLConnUtils.getMySQLConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            int row = 0;
            while ((rs != null) && (rs.next())) {
                int thanhtien=Integer.parseInt(rs.getString("SoluongX"))*Integer.parseInt(rs.getString("Giaban"));
                model.addRow(new Object[0]);
                model.setValueAt(row+1, row, 0);
                model.setValueAt(rs.getString("Ten_hang"), row, 1);
                model.setValueAt(rs.getString("Ma_dvt"), row, 2);
                model.setValueAt(rs.getString("SoluongX"), row, 3);
                model.setValueAt(rs.getString("Giaban"), row, 4);
                model.setValueAt(thanhtien, row, 5);

                row++;
                }
        } catch (Exception e) {
           e.printStackTrace();
       }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel42 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("In hóa đơn");

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Print_30px.png"))); // NOI18N
        jLabel15.setText("In hóa đơn");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setMinimumSize(new java.awt.Dimension(660, 900));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("(Ký, ghi rõ họ, tên)");
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 770, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel17.setText("Mẫu số: ");
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 17, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Liên 1 : Lưu");
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 39, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel20.setText("01GTKT/001");
        jPanel11.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 17, -1, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel21.setText("Ký hiệu:");
        jPanel11.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 41, -1, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel22.setText("ET/17P");
        jPanel11.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 41, -1, -1));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel23.setText("Số:");
        jPanel11.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 68, -1, -1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 0, 0));
        jLabel24.setText("0000129");
        jPanel11.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 62, -1, -1));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel25.setText("Ngày ..... tháng ....... năm 20.....");
        jPanel11.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 76, -1, -1));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel26.setText("Số tài khoản:...................................................................................................................................");
        jPanel11.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setText("1702082414");
        jPanel11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel27.setText("Đơn vị bán hàng:");
        jPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 111, -1, -1));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel29.setText("Mã số thuế: ");
        jPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel30.setText("Địa chỉ: Số 03 Hùng Vương, phường Vĩnh Thanh Vân, thành phố Rạch Giá, tỉnh Kiên Giang, Việt Nam");
        jPanel11.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel31.setText("Điện thoại: 0918.027.499");
        jPanel11.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel32.setText("CÔNG TY TNHH MỘT THÀNH VIÊN EN TƠ KIÊN GIANG");
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 111, -1, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_data.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_data.setGridColor(new java.awt.Color(102, 102, 102));
        tbl_data.setSelectionBackground(new java.awt.Color(247, 99, 12));
        jScrollPane2.setViewportView(tbl_data);

        jPanel12.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 640, 270));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel33.setText("Hình thức thanh toán: .................................. Số tài khoản: ......................................................................");
        jPanel12.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel34.setText("Họ tên người mua hàng:");
        jPanel12.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel35.setText("Tên đơn vị:");
        jPanel12.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel36.setText("Mã số thuế:");
        jPanel12.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel37.setText("Số tiền viết bằng chữ: ............................................................................................................................");
        jPanel12.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel38.setText("Địa chỉ:");
        jPanel12.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel40.setText("Thuế suất GTGT:");
        jPanel12.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel41.setText("Tiền thuế GTGT:");
        jPanel12.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));
        jPanel12.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 640, -1));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel42.setText("Tổng cộng tiền thanh toán:");
        jPanel12.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, -1, -1));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel45.setText("Cộng tiền hàng:");
        jPanel12.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel12.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 120, 20));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel12.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 350, 20));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel12.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 120, 20));

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel12.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 120, 20));

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel12.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 270, 20));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel12.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 320, 20));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel12.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 260, 20));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel12.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 120, 20));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 640, 510));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Người mua hàng");
        jPanel11.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 750, -1, -1));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("Người bán hàng");
        jPanel11.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 750, -1, -1));

        jLabel19.setText("(Ký, đóng dấu, ghi rõ họ, tên)");
        jPanel11.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 770, -1, -1));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel11.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 890, 120, 20));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel54.setText("HÓA ĐƠN BÁN HÀNG");
        jPanel11.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 11, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void table(){
        for(int i=0;i<6;i++){
            TableColumn column = null;
            column=tbl_data.getColumnModel().getColumn(i);
            if(i==0&&i==2)
                column.setPreferredWidth(100);
            if(i==1)
                column.setPreferredWidth(300);
        }
    }
    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        GUI.GUIBaocao baocao= new GUIBaocao();
        baocao.PrintRecord(jPanel11);
    }//GEN-LAST:event_jPanel10MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(In_hoadonbanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(In_hoadonbanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(In_hoadonbanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(In_hoadonbanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new In_hoadonbanhang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables
}
