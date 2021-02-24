
package GUI;

import DBConnect.MySQLConnUtils;
import Frame.Baocao_khohang;
import Frame.Baocao_nhaphang;
import Frame.Baocao_trahang;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sun.print.PSPrinterJob;

public class GUIBaocao extends javax.swing.JFrame {

    public GUIBaocao() {
        initComponents();
        setLocationRelativeTo(null);
        loadData();
        table();
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
                default:
                    return String.class;        
              }
            }
        };
        tbl_data.setModel(model);

        // Add Column
        model.addColumn("STT");
        model.addColumn("Hóa đơn bán hàng");
        model.addColumn("Khách hàng");
        model.addColumn("Ngày bán");
        model.addColumn("Tổng tiền");
        model.addColumn("Đã thanh toán");

        String sql = "SELECT * FROM hoadonxuat,chitietxuat,khachhang "
                + "WHERE hoadonxuat.Ma_HDX=chitietxuat.Ma_HDX AND khachhang.Ma_KH=hoadonxuat.Ma_KH "
                + "Group by hoadonxuat.Ma_HDX "
                + "ORDER BY hoadonxuat.Ngay_xuat";
        try {
            dbConnection = MySQLConnUtils.getMySQLConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            int row = 0;
            while ((rs != null) && (rs.next())) {
                model.addRow(new Object[0]);
                model.setValueAt(row+1, row, 0);
                model.setValueAt(rs.getString("Ma_HDX"), row, 1);
                model.setValueAt(rs.getString("Ten_KH"), row, 2);
                model.setValueAt(rs.getString("Ngay_xuat"), row, 3);
                model.setValueAt(rs.getString("Thanhtienxuat"), row, 4);
                model.setValueAt(rs.getString("Da_tra"), row, 5);

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
                default:
                    return String.class;        
              }
            }
        };
        tbl_data.setModel(model);

        // Add Column
        model.addColumn("STT");
        model.addColumn("Hóa đơn bán hàng");
        model.addColumn("Khách hàng");
        model.addColumn("Ngày bán");
        model.addColumn("Tổng tiền");
        model.addColumn("Đã thanh toán");

        String sql = "SELECT * FROM hoadonxuat,chitietxuat,khachhang "
                + "WHERE hoadonxuat.Ma_HDX=chitietxuat.Ma_HDX AND khachhang.Ma_KH=hoadonxuat.Ma_KH "
                + "AND hoadonxuat.Ngay_xuat BETWEEN '"+dateInputfrom+"' AND '"+dateInputto+"' "
                + "Group by hoadonxuat.Ma_HDX "
                + "ORDER BY hoadonxuat.Ngay_xuat";
        try {
            dbConnection = MySQLConnUtils.getMySQLConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            int row = 0;
            while ((rs != null) && (rs.next())) {
                model.addRow(new Object[0]);
                model.setValueAt(row+1, row, 0);
                model.setValueAt(rs.getString("Ma_HDX"), row, 1);
                model.setValueAt(rs.getString("Ten_KH"), row, 2);
                model.setValueAt(rs.getString("Ngay_xuat"), row, 3);
                model.setValueAt(rs.getString("Thanhtienxuat"), row, 4);
                model.setValueAt(rs.getString("Da_tra"), row, 5);

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

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lbexit = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnbanhang = new javax.swing.JPanel();
        ind2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btntrahang = new javax.swing.JPanel();
        ind3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnnhaphang = new javax.swing.JPanel();
        ind4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnkhohang = new javax.swing.JPanel();
        ind7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
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
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbfrom = new com.toedter.calendar.JDateChooser();
        cbto = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(247, 99, 12));

        jPanel6.setBackground(new java.awt.Color(247, 99, 12));

        lbexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Delete_32px_1.png"))); // NOI18N
        lbexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbexitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbexitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbexitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbexit))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lbexit)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(247, 99, 12));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Expand_Arrow_32px_1.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 590, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 650, 40));

        jPanel2.setBackground(new java.awt.Color(72, 19, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(72, 19, 0));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Home_32px.png"))); // NOI18N
        jLabel1.setText("Trang Chủ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 200, 50));

        btnbanhang.setBackground(new java.awt.Color(133, 97, 85));
        btnbanhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnbanhangMousePressed(evt);
            }
        });

        ind2.setBackground(new java.awt.Color(255, 255, 255));
        ind2.setPreferredSize(new java.awt.Dimension(5, 45));

        javax.swing.GroupLayout ind2Layout = new javax.swing.GroupLayout(ind2);
        ind2.setLayout(ind2Layout);
        ind2Layout.setHorizontalGroup(
            ind2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        ind2Layout.setVerticalGroup(
            ind2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Sell_32px_1.png"))); // NOI18N
        jLabel6.setText("Bán Hàng");

        javax.swing.GroupLayout btnbanhangLayout = new javax.swing.GroupLayout(btnbanhang);
        btnbanhang.setLayout(btnbanhangLayout);
        btnbanhangLayout.setHorizontalGroup(
            btnbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnbanhangLayout.createSequentialGroup()
                .addComponent(ind2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        btnbanhangLayout.setVerticalGroup(
            btnbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnbanhangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ind2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnbanhangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(btnbanhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 185, 200, -1));

        btntrahang.setBackground(new java.awt.Color(72, 19, 0));
        btntrahang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btntrahangMousePressed(evt);
            }
        });

        ind3.setBackground(new java.awt.Color(255, 255, 255));
        ind3.setOpaque(false);
        ind3.setPreferredSize(new java.awt.Dimension(5, 45));

        javax.swing.GroupLayout ind3Layout = new javax.swing.GroupLayout(ind3);
        ind3.setLayout(ind3Layout);
        ind3Layout.setHorizontalGroup(
            ind3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        ind3Layout.setVerticalGroup(
            ind3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Checkout_32px.png"))); // NOI18N
        jLabel7.setText("Trả Hàng");

        javax.swing.GroupLayout btntrahangLayout = new javax.swing.GroupLayout(btntrahang);
        btntrahang.setLayout(btntrahangLayout);
        btntrahangLayout.setHorizontalGroup(
            btntrahangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btntrahangLayout.createSequentialGroup()
                .addComponent(ind3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        btntrahangLayout.setVerticalGroup(
            btntrahangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btntrahangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ind3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btntrahangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(btntrahang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 200, -1));

        btnnhaphang.setBackground(new java.awt.Color(72, 19, 0));
        btnnhaphang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnnhaphangMousePressed(evt);
            }
        });

        ind4.setBackground(new java.awt.Color(255, 255, 255));
        ind4.setOpaque(false);
        ind4.setPreferredSize(new java.awt.Dimension(5, 45));

        javax.swing.GroupLayout ind4Layout = new javax.swing.GroupLayout(ind4);
        ind4.setLayout(ind4Layout);
        ind4Layout.setHorizontalGroup(
            ind4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        ind4Layout.setVerticalGroup(
            ind4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Buy_32px.png"))); // NOI18N
        jLabel8.setText("Nhập Hàng");

        javax.swing.GroupLayout btnnhaphangLayout = new javax.swing.GroupLayout(btnnhaphang);
        btnnhaphang.setLayout(btnnhaphangLayout);
        btnnhaphangLayout.setHorizontalGroup(
            btnnhaphangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnnhaphangLayout.createSequentialGroup()
                .addComponent(ind4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        btnnhaphangLayout.setVerticalGroup(
            btnnhaphangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnnhaphangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ind4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnnhaphangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(btnnhaphang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 200, -1));

        btnkhohang.setBackground(new java.awt.Color(72, 19, 0));
        btnkhohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnkhohangMousePressed(evt);
            }
        });

        ind7.setBackground(new java.awt.Color(255, 255, 255));
        ind7.setOpaque(false);
        ind7.setPreferredSize(new java.awt.Dimension(5, 45));

        javax.swing.GroupLayout ind7Layout = new javax.swing.GroupLayout(ind7);
        ind7.setLayout(ind7Layout);
        ind7Layout.setHorizontalGroup(
            ind7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        ind7Layout.setVerticalGroup(
            ind7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Warehouse_32px.png"))); // NOI18N
        jLabel11.setText("Kho Hàng");

        javax.swing.GroupLayout btnkhohangLayout = new javax.swing.GroupLayout(btnkhohang);
        btnkhohang.setLayout(btnkhohangLayout);
        btnkhohangLayout.setHorizontalGroup(
            btnkhohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnkhohangLayout.createSequentialGroup()
                .addComponent(ind7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        btnkhohangLayout.setVerticalGroup(
            btnkhohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnkhohangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ind7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnkhohangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(btnkhohang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 200, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BÁO CÁO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 650));

        jPanel4.setLayout(new java.awt.CardLayout());

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(247, 99, 12));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("BÁO CÁO BÁN HÀNG");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        jLabel32.setText("BÁO CÁO BÁN HÀNG");
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

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 650, 390));

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

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(247, 99, 12));
        jLabel15.setText("Tìm kiếm theo ngày nhập");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(247, 99, 12));
        jLabel16.setText("đến");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        cbfrom.setBackground(new java.awt.Color(255, 255, 255));
        cbfrom.setForeground(new java.awt.Color(247, 99, 12));
        cbfrom.setDateFormatString("yyyy-MM-dd");
        cbfrom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel5.add(cbfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 120, 20));

        cbto.setBackground(new java.awt.Color(255, 255, 255));
        cbto.setForeground(new java.awt.Color(247, 99, 12));
        cbto.setDateFormatString("yyyy-MM-dd");
        cbto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel5.add(cbto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 120, 20));

        jPanel10.setBackground(new java.awt.Color(247, 99, 12));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 90, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(247, 99, 12));
        jLabel18.setText("Từ ngày");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jPanel4.add(jPanel5, "card2");

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 650, 610));

        pack();
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
            Logger.getLogger(GUIBaocao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void table(){
        for(int i=0;i<6;i++){
            TableColumn column = null;
            column=tbl_data.getColumnModel().getColumn(i);
            if(i==1)
                column.setPreferredWidth(100);
            if(i==2)
                column.setPreferredWidth(200);
        }
    }
    private void setColor(JPanel pane){
        pane.setBackground(new Color(133,97,85));
    }
    
    private void resetColor(JPanel [] pane,JPanel[] indicators){
        for(int i=0;i<pane.length;i++)
            pane[i].setBackground(new Color(72,19,0));
        for(int i=0;i<indicators.length;i++)
            indicators[i].setOpaque(false);
    }
    

    Baocao_khohang khohang=new Baocao_khohang();
    Baocao_nhaphang nhaphang=new Baocao_nhaphang();
    Baocao_trahang trahang=new Baocao_trahang();
    
    private void btnbanhangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbanhangMousePressed
        setColor(btnbanhang);//doi mau
        ind2.setOpaque(true);
        resetColor(new JPanel[]{btnkhohang,btnnhaphang,btntrahang},
                new JPanel[]{ind3,ind4,ind7});
        //doi trang
        jPanel5.setVisible(true);

        jPanel4.add(khohang, "card2");
        khohang.setVisible(false);
        jPanel4.add(nhaphang, "card2");
        nhaphang.setVisible(false);
        jPanel4.add(trahang, "card2");
        trahang.setVisible(false);
    }//GEN-LAST:event_btnbanhangMousePressed

    private void btntrahangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntrahangMousePressed
        setColor(btntrahang);//doi mau
        ind3.setOpaque(true);
        resetColor(new JPanel[]{btnkhohang,btnnhaphang,btnbanhang},
                new JPanel[]{ind2,ind4,ind7});
        //doi trang
        jPanel5.setVisible(false);

        jPanel4.add(khohang, "card2");
        khohang.setVisible(false);
        jPanel4.add(nhaphang, "card2");
        nhaphang.setVisible(false);
        jPanel4.add(trahang, "card2");
        trahang.setVisible(true);
    }//GEN-LAST:event_btntrahangMousePressed

    private void btnnhaphangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnhaphangMousePressed
        setColor(btnnhaphang);//doi mau
        ind4.setOpaque(true);
        resetColor(new JPanel[]{btnkhohang,btnbanhang,btntrahang},
                new JPanel[]{ind3,ind2,ind7});
        //doi trang
        jPanel5.setVisible(false);

        jPanel4.add(khohang, "card2");
        khohang.setVisible(false);
        jPanel4.add(nhaphang, "card2");
        nhaphang.setVisible(true);
        jPanel4.add(trahang, "card2");
        trahang.setVisible(false);
    }//GEN-LAST:event_btnnhaphangMousePressed

    private void btnkhohangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkhohangMousePressed
        setColor(btnkhohang);//doi mau
        ind7.setOpaque(true);
        resetColor(new JPanel[]{btnbanhang,btnnhaphang,btntrahang},
                new JPanel[]{ind3,ind4,ind2});
        //doi trang
        jPanel5.setVisible(false);

        jPanel4.add(khohang, "card2");
        khohang.setVisible(true);

        jPanel4.add(nhaphang, "card2");
        nhaphang.setVisible(false);
        jPanel4.add(trahang, "card2");
        trahang.setVisible(false);
    }//GEN-LAST:event_btnkhohangMousePressed

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        jPanel3.setBackground(new Color(133,97,85));
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        jPanel3.setBackground(new Color(72,19,0));
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        new Main.Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel3MousePressed

    private void lbexitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbexitMouseEntered
        lbexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Delete_32px_3.png")));
        jPanel6.setBackground(Color.WHITE);
    }//GEN-LAST:event_lbexitMouseEntered

    private void lbexitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbexitMouseExited
        lbexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Delete_32px_1.png")));
        jPanel6.setBackground(new Color(247,99,12));
    }//GEN-LAST:event_lbexitMouseExited

    private void lbexitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbexitMousePressed
        int i = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn Thoát!","Thông Báo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (i==0){
            this.dispose();
        }
    }//GEN-LAST:event_lbexitMousePressed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jPanel7.setBackground(new Color(229, 229, 229));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jPanel7.setBackground(new Color (247,99,12));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        PrintRecord(jPanel11);
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        loadDatatheongay();
        table();
    }//GEN-LAST:event_jPanel10MouseClicked
    public void PrintRecord(JPanel panel){
        PrinterJob printerJob = new PSPrinterJob();
        
        printerJob.setJobName("PrintRecord");
        printerJob.setPrintable(new Printable(){

            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex>0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D graphics2d = (Graphics2D)graphics;
                graphics2d.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
                graphics2d.scale(0.6,0.7);
                panel.paint(graphics2d);
                
                return Printable.PAGE_EXISTS;
            }
            
        });
        boolean returningResult =printerJob.printDialog();
        if(returningResult){
            try{
                printerJob.print();
            }catch(PrinterException printerException){
                JOptionPane.showMessageDialog(this, "Print Error: "+printerException.getMessage());
            }
        }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIBaocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIBaocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIBaocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIBaocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIBaocao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnbanhang;
    private javax.swing.JPanel btnkhohang;
    private javax.swing.JPanel btnnhaphang;
    private javax.swing.JPanel btntrahang;
    private com.toedter.calendar.JDateChooser cbfrom;
    private com.toedter.calendar.JDateChooser cbto;
    private javax.swing.JPanel ind2;
    private javax.swing.JPanel ind3;
    private javax.swing.JPanel ind4;
    private javax.swing.JPanel ind7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbexit;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables
}
