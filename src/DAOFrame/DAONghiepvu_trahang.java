
package DAOFrame;

import DBConnect.MySQLConnUtils;
import OBJFrame.Dm_khohang;
import OBJFrame.Nv_trahang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAONghiepvu_trahang {
    public boolean ThemHoadonT(Nv_trahang hd){
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO hoadontra (Ma_HDT,Ngay_tra,Ma_NV,Ma_NCC,Da_tra,Thanhtientra) VALUES (null,?,?,?,?,?)");
            statement.setString(1, hd.getNgay_tra());
            statement.setString(2, hd.getMa_NV());
            statement.setString(3, hd.getMa_NCC());
            statement.setInt(4, hd.getDa_tra());
            statement.setInt(5, hd.getThanhtientra());
            
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu_trahang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu_trahang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }  

    public boolean Xoahang(Dm_khohang trahang) {
        try {
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE chitietkho SET SL_tonkho=SL_tonkho -?  WHERE Ma_hang=? ");
            
            statement.setInt(1, trahang.getSL_tonkho());
            statement.setString(2, trahang.getMa_hang());

            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu_trahang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu_trahang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }     
    
    public boolean ThemCTtra(Nv_trahang ctietT){
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO chitiettra (Ma_CTT,Ma_hang,Ma_HDT,SoluongT) VALUES (null,?,?,?)");
            statement.setString(1, ctietT.getMa_hang());
            statement.setInt(2, ctietT.getMa_HDT());
            statement.setInt(3, ctietT.getSoluongT()); 
            
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu_trahang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu_trahang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    
}
