
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
import javax.swing.table.TableColumn;

public class Nghiepvu_hoadontrahang extends javax.swing.JPanel {

    public Nghiepvu_hoadontrahang() {
        initComponents();
        loadData();
        ngayhientai();
    }
    
    Connection dbConnection = null;
    Statement statement = null;
    public void loadData() {
    // Clear table
    tbl_data1.setModel(new DefaultTableModel());
    
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
    tbl_data1.setModel(model);

    // Add Column
    model.addColumn("STT");
    model.addColumn("Mã hóa đơn");
    model.addColumn("Nhà cung cấp");
    model.addColumn("Tổng tiền");
    model.addColumn("Thanh toán");
    model.addColumn("Nhân viên");
    model.addColumn("Ngày trả");
    String sql = "SELECT * FROM nhanvien ,nhacungcap,hoadonnhap,hoadontra,chitiettra,hang "
            + "WHERE nhacungcap.Ma_NCC = hoadonnhap.Ma_NCC AND chitiettra.Ma_hang=hang.Ma_hang AND "
            + "hang.Ma_hang=chitiettra.Ma_hang AND chitiettra.Ma_HDT=hoadontra.Ma_HDT AND nhacungcap.Ma_NCC= hoadontra.Ma_NCC "
            + "Group by hoadontra.Ma_HDT "
            + "ORDER BY hoadontra.Ngay_tra,hoadontra.Ma_HDT";
    try {
        dbConnection = MySQLConnUtils.getMySQLConnection();
        statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        int row = 0;
        
        while ((rs != null) && (rs.next())) {
            model.addRow(new Object[0]);
            model.setValueAt(row+1, row, 0);
            model.setValueAt(rs.getString("Ma_HDT"), row, 1);
            model.setValueAt(rs.getString("Ten_NCC"), row, 2);
            model.setValueAt(rs.getString("Thanhtientra"), row, 3);           
            model.setValueAt(rs.getString("Da_tra"), row, 4);
            model.setValueAt(rs.getString("Hoten"), row, 5);
            model.setValueAt(rs.getString("Ngay_tra"), row, 6);
            
            row++;            
            }
        } catch (Exception e) {
            e.printStackTrace();
       }
    }
 
    public void loadData2() {
        // Clear table
        tbl_data2.setModel(new DefaultTableModel());

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
        tbl_data2.setModel(model);
        // Add Column
        model.addColumn("STT");
        model.addColumn("Tên hàng");
        model.addColumn("ĐVT");
        model.addColumn("Số lượng");
        model.addColumn("Giá nhập");
        model.addColumn("Thành tiền");

        String ma_hd = tbl_data1.getValueAt(tbl_data1.getSelectedRow(), 1).toString();
        
        String sql = "SELECT * FROM chitietnhap,hang,donvitinh,chitiettra,hoadontra"
                + " WHERE hang.Ma_dvt=donvitinh.Ma_dvt AND chitietnhap.Ma_hang=hang.Ma_hang AND "
                + "chitiettra.Ma_HDT=hoadontra.Ma_HDT AND chitiettra.Ma_hang=hang.Ma_hang AND hoadontra.Ma_HDT="+ma_hd;

        try {
            dbConnection = MySQLConnUtils.getMySQLConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            int row = 0;
            while ((rs != null) && (rs.next())) {
                int thanhtien=Integer.parseInt(rs.getString("DongiaN"))*Integer.parseInt(rs.getString("SoluongT"));
                model.addRow(new Object[0]);
                model.setValueAt(row+1, row, 0);
                model.setValueAt(rs.getString("Ten_hang"), row, 1);
                model.setValueAt(rs.getString("Ten_dvt"), row, 2);
                model.setValueAt(rs.getString("SoluongT"), row, 3);
                model.setValueAt(rs.getString("DongiaN"), row, 4);
                model.setValueAt(thanhtien, row, 5);

                row++;
            }
        } catch (Exception e) {
            e.printStackTrace();
       }
    }    
        public void loadDatatheongay() {
    // Clear table
    tbl_data1.setModel(new DefaultTableModel());
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
    tbl_data1.setModel(model);

    // Add Column
    model.addColumn("STT");
    model.addColumn("Mã hóa đơn");
    model.addColumn("Nhà cung cấp");
    model.addColumn("Tổng tiền");
    model.addColumn("Thanh toán");
    model.addColumn("Nhân viên");
    model.addColumn("Ngày trả");
    String sql = "SELECT * FROM nhanvien ,nhacungcap,hoadonnhap,hoadontra,chitiettra,hang "
            + "WHERE nhacungcap.Ma_NCC = hoadonnhap.Ma_NCC AND chitiettra.Ma_hang=hang.Ma_hang AND "
            + "hang.Ma_hang=chitiettra.Ma_hang AND chitiettra.Ma_HDT=hoadontra.Ma_HDT AND nhacungcap.Ma_NCC= hoadontra.Ma_NCC "
            + "AND hoadontra.Ngay_tra BETWEEN '"+dateInputfrom+"' AND '"+dateInputto+"' "
            + "Group by hoadontra.Ma_HDT";
    try {
        dbConnection = MySQLConnUtils.getMySQLConnection();
        statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        int row = 0;
        
        while ((rs != null) && (rs.next())) {
            model.addRow(new Object[0]);
            model.setValueAt(row+1, row, 0);
            model.setValueAt(rs.getString("Ma_HDT"), row, 1);
            model.setValueAt(rs.getString("Ten_NCC"), row, 2);
            model.setValueAt(rs.getString("Thanhtientra"), row, 3);           
            model.setValueAt(rs.getString("Da_tra"), row, 4);
            model.setValueAt(rs.getString("Hoten"), row, 5);
            model.setValueAt(rs.getString("Ngay_tra"), row, 6);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_data2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        r_ngay = new javax.swing.JRadioButton();
        r_nhacc = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbfrom = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cbto = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_data1.setForeground(new java.awt.Color(154, 0, 137));
        tbl_data1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_data1.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_data1.setSelectionBackground(new java.awt.Color(154, 0, 137));
        tbl_data1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_data1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 850, 220));

        tbl_data2.setForeground(new java.awt.Color(154, 0, 137));
        tbl_data2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên hàng", "ĐVT", "Số lượng", "Giá nhập", "Thành tiền"
            }
        ));
        tbl_data2.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_data2.setSelectionBackground(new java.awt.Color(154, 0, 137));
        jScrollPane2.setViewportView(tbl_data2);
        if (tbl_data2.getColumnModel().getColumnCount() > 0) {
            tbl_data2.getColumnModel().getColumn(1).setPreferredWidth(300);
            tbl_data2.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 850, 170));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(154, 0, 137));
        jLabel2.setText("Chi tiết hóa đơn");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(154, 0, 137));
        jLabel7.setText("Xem theo");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        r_ngay.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        r_ngay.setForeground(new java.awt.Color(154, 0, 137));
        r_ngay.setText("Ngày");
        add(r_ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        r_nhacc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        r_nhacc.setForeground(new java.awt.Color(154, 0, 137));
        r_nhacc.setText("Nhà cung cấp");
        add(r_nhacc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jPanel6.setBackground(new java.awt.Color(154, 0, 137));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("HÓA ĐƠN TRẢ HÀNG");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 80));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(154, 0, 137));
        jLabel6.setText("Tìm kiếm theo ngày nhập");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(154, 0, 137));
        jLabel8.setText("Từ ngày");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        cbfrom.setBackground(new java.awt.Color(255, 255, 255));
        cbfrom.setForeground(new java.awt.Color(154, 0, 137));
        cbfrom.setDateFormatString("yyyy-MM-dd");
        cbfrom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        add(cbfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 130, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(154, 0, 137));
        jLabel4.setText("đến");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        cbto.setBackground(new java.awt.Color(255, 255, 255));
        cbto.setForeground(new java.awt.Color(154, 0, 137));
        cbto.setDateFormatString("yyyy-MM-dd");
        cbto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        add(cbto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 110, 20));

        jPanel1.setBackground(new java.awt.Color(154, 0, 137));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 90, 40));

        jPanel2.setBackground(new java.awt.Color(154, 0, 137));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Reset");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, 40));

        jPanel3.setBackground(new java.awt.Color(154, 0, 137));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("In hóa dơn");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, -1, -1));
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
            Logger.getLogger(Nghiepvu_hoadontrahang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void tbl_data1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_data1MousePressed
        loadData2();
        TableColumn column = null;
        for(int i=0;i<5;i++){
            column=tbl_data2.getColumnModel().getColumn(i);
            if(i==1)
                column.setPreferredWidth(300);
        }    
    }//GEN-LAST:event_tbl_data1MousePressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        loadDatatheongay();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        loadData();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        new In_hoadonbanhang().setVisible(true);
    }//GEN-LAST:event_jPanel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser cbfrom;
    private com.toedter.calendar.JDateChooser cbto;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton r_ngay;
    private javax.swing.JRadioButton r_nhacc;
    private javax.swing.JTable tbl_data1;
    private javax.swing.JTable tbl_data2;
    // End of variables declaration//GEN-END:variables
}
