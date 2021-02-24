
package Frame;

import DBConnect.MySQLConnUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Baocao_nhaphang extends javax.swing.JPanel {

    public Baocao_nhaphang() {
        initComponents();
        loadData();
        ngayhientai();
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
                case 6:
                    return String.class;
                default:
                    return String.class;        
              }
            }
        };
        tbl_data.setModel(model);

        // Add Column
        model.addColumn("STT");
        model.addColumn("Hóa đơn nhập");
        model.addColumn("Nhà cung cấp");
        model.addColumn("Ngày nhập");
        model.addColumn("Tổng tiền");
        model.addColumn("Chiết khấu");
        model.addColumn("Đã thanh toán");

        String sql = "SELECT * FROM hoadonnhap,chitietnhap,nhacungcap "
                + "WHERE hoadonnhap.Ma_HDN=chitietnhap.Ma_HDN AND nhacungcap.Ma_NCC=hoadonnhap.Ma_NCC "
                + "Group by hoadonnhap.Ma_HDN "
                + "ORDER BY hoadonnhap.Ngay_nhap";
        try {
            dbConnection = MySQLConnUtils.getMySQLConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            int row = 0;
            while ((rs != null) && (rs.next())) {
                model.addRow(new Object[0]);
                model.setValueAt(row+1, row, 0);
                model.setValueAt(rs.getString("Ma_HDN"), row, 1);
                model.setValueAt(rs.getString("Ten_NCC"), row, 2);
                model.setValueAt(rs.getString("Ngay_nhap"), row, 3);
                model.setValueAt(rs.getString("Thanhtiennhap"), row, 4);
                model.setValueAt(rs.getString("Chietkhau"), row, 5);
                model.setValueAt(rs.getString("Da_tra"), row, 6);


                row++;
                }
        } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public void loadDatatheongay() {
        // Clear table
        tbl_data.setModel(new DefaultTableModel());
        Date datefrom = cbfrom.getDate();
        String dateInputfrom = new SimpleDateFormat("yyyy-MM-dd").format(datefrom);
        Date dateto = cbto.getDate();
        String dateInputto = new SimpleDateFormat("yyyy-MM-dd").format(dateto);
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
                case 6:
                    return String.class;
                default:
                    return String.class;        
              }
            }
        };
        tbl_data.setModel(model);

        // Add Column
        model.addColumn("STT");
        model.addColumn("Hóa đơn nhập");
        model.addColumn("Nhà cung cấp");
        model.addColumn("Ngày nhập");
        model.addColumn("Tổng tiền");
        model.addColumn("Chiết khấu");
        model.addColumn("Đã thanh toán");

        String sql = "SELECT * FROM hoadonnhap,chitietnhap,nhacungcap "
                + "WHERE hoadonnhap.Ma_HDN=chitietnhap.Ma_HDN AND nhacungcap.Ma_NCC=hoadonnhap.Ma_NCC"
                + " AND hoadonnhap.Ngay_nhap BETWEEN '"+dateInputfrom+"' AND '"+dateInputto+"' "
                + "Group by hoadonnhap.Ma_HDN "
                + "ORDER BY hoadonnhap.Ngay_nhap";
        try {
            dbConnection = MySQLConnUtils.getMySQLConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            int row = 0;
            while ((rs != null) && (rs.next())) {
                model.addRow(new Object[0]);
                model.setValueAt(row+1, row, 0);
                model.setValueAt(rs.getString("Ma_HDN"), row, 1);
                model.setValueAt(rs.getString("Ten_NCC"), row, 2);
                model.setValueAt(rs.getString("Ngay_nhap"), row, 3);
                model.setValueAt(rs.getString("Thanhtiennhap"), row, 4);
                model.setValueAt(rs.getString("Chietkhau"), row, 5);
                model.setValueAt(rs.getString("Da_tra"), row, 6);

                row++;
                }
        } catch (Exception e) {
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

        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbfrom = new com.toedter.calendar.JDateChooser();
        cbto = new com.toedter.calendar.JDateChooser();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(247, 99, 12));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("BÁO CÁO NHẬP HÀNG");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel29.setText("Mã số thuế: ");
        jPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setText("1702082414");
        jPanel11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));
        jPanel11.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 132, 660, 10));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setText("CÔNG TY TNHH MỘT THÀNH VIÊN EN TƠ KIÊN GIANG");
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        tbl_data.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
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
        jScrollPane1.setViewportView(tbl_data);

        jPanel11.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 660, 350));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel34.setText("Điện thoại: 0918.027.499");
        jPanel11.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel32.setText("BÁO CÁO NHẬP HÀNG");
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel36.setText("Tháng");
        jPanel11.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, -1, -1));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel30.setText("Địa chỉ: Số 03 Hùng Vương, phường Vĩnh Thanh Vân, thành phố Rạch Giá, tỉnh Kiên Giang, Việt Nam");
        jPanel11.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel37.setText("Ngày ");
        jPanel11.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, -1, -1));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel31.setText("Năm");
        jPanel11.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, -1, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel38.setText("Người lập báo cáo");
        jPanel11.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 600, -1, -1));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPanel11.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 740, 100, 20));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel40.setText("(Ký, ghi rõ họ tên)");
        jPanel11.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 620, -1, -1));

        jScrollPane2.setViewportView(jPanel11);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 650, 390));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(247, 99, 12));
        jLabel16.setText("Tìm kiếm theo ngày nhập");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(247, 99, 12));
        jLabel18.setText("Từ ngày");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        cbfrom.setBackground(new java.awt.Color(255, 255, 255));
        cbfrom.setForeground(new java.awt.Color(247, 99, 12));
        cbfrom.setDateFormatString("yyyy-MM-dd");
        cbfrom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        add(cbfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 120, 20));

        cbto.setBackground(new java.awt.Color(255, 255, 255));
        cbto.setForeground(new java.awt.Color(247, 99, 12));
        cbto.setDateFormatString("yyyy-MM-dd");
        cbto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        add(cbto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 120, 20));

        jPanel12.setBackground(new java.awt.Color(247, 99, 12));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 90, 40));

        jPanel9.setBackground(new java.awt.Color(247, 99, 12));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Xuất báo cáo");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(247, 99, 12));
        jLabel19.setText("đến");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    private void ngayhientai(){
        cbfrom.setDateFormatString("dd/MM/yyyy");
        cbto.setDateFormatString("dd/MM/yyyy");
        GregorianCalendar calendar = new GregorianCalendar();
        int ngay=calendar.get(Calendar.DATE);
        int thang=calendar.get(Calendar.MONTH)+1;
        int nam=calendar.get(Calendar.YEAR);
        String ngaythang=nam+"-"+thang+"-"+ngay;
        try {
            Date date= new SimpleDateFormat("yyyy-MM-dd").parse(ngaythang);
            cbfrom.setDate(date);
            cbto.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(Baocao_nhaphang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        loadDatatheongay();
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        new GUI.GUIBaocao().PrintRecord(jPanel11);
    }//GEN-LAST:event_jPanel9MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser cbfrom;
    private com.toedter.calendar.JDateChooser cbto;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables
}
