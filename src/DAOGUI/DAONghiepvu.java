
package DAOGUI;

import DBConnect.MySQLConnUtils;
import OBJFrame.Dm_khohang;
import OBJGUI.Nghiepvu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAONghiepvu {

    //Bán hàng
        public boolean ThemHoadonX(Nghiepvu hd){
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO hoadonxuat (Ma_HDX,Ngay_xuat,thanhtienxuat,Da_tra,Ma_NV,Ma_KH) VALUES (null,?,?,?,?,?)");
            statement.setString(1, hd.getNgay_xuat());
            statement.setInt(2, hd.getThanhtienxuat());
            statement.setInt(3, hd.getDa_tra());
            statement.setString(4, hd.getMa_NV());
            statement.setString(5, hd.getMa_KH()); 
            
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean Xoahang(Dm_khohang slkho) {
        try {
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE chitietkho SET SL_tonkho=SL_tonkho -? WHERE Ma_hang=? ");
            
            statement.setInt(1, slkho.getSL_tonkho());
            statement.setString(2, slkho.getMa_hang());

            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }        
    
    public boolean ThemCTxuat(Nghiepvu ctietX){
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO chitietxuat (Ma_CTX,SoluongX,Ma_HDX,Giam_gia,Ma_hang) VALUES (null,?,?,?,?)");
            statement.setInt(1, ctietX.getSoluongX());
            statement.setInt(2, ctietX.getMa_HDX());
            statement.setInt(3, ctietX.getGiam_gia());
            statement.setString(4, ctietX.getMa_hang());
            
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Nghiepvu Timhoadonmoi(String mahd) {
        Nghiepvu nghiepvu = new Nghiepvu(); // khai báo biến
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM `hoadonxuat` ORDER BY hoadonxuat.Ma_HDX DESC LIMIT 0,1");
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                nghiepvu.setMa_HDX(rs.getInt("Ma_HDX"));
 

                return nghiepvu;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nghiepvu;
    }    
}
