
package DAOFrame;

import DAOGUI.DAONghiepvu;
import DBConnect.MySQLConnUtils;
import OBJFrame.Nv_nhaphang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAONghiepvu_nhaphang {
    //Nhập hàng
    public boolean ThemHang(Nv_nhaphang hang){
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO hang (Ma_hang,Ten_hang,Ma_loaihang,Ma_dvt) VALUES (?,?,?,?)");
            statement.setString(1, hang.getMa_hang());
            statement.setString(2, hang.getTen_hang());
            statement.setString(3, hang.getMa_loaihang());
            statement.setInt(4, hang.getMa_dvt());
 
            
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu_nhaphang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu_nhaphang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean ThemHoadonN(Nv_nhaphang hd){
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO hoadonnhap (Ma_HDN,Ngay_nhap,Ma_NV,Ma_NCC,Chietkhau,Da_tra,Thanhtiennhap) VALUES (null,?,?,?,?,?,?)");
            statement.setString(1, hd.getNgay_nhap());
            statement.setString(2, hd.getMa_NV());
            statement.setString(3, hd.getMa_NCC());
            statement.setInt(4, hd.getChietkhau());
            statement.setInt(5, hd.getDa_tra());
            statement.setInt(6, hd.getThanhtiennhap());
            
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu_nhaphang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu_nhaphang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean ThemCTnhap(Nv_nhaphang ctiet){
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO chitietnhap (Ma_CTN,SoluongN,DongiaN,Giaban,Ma_HDN,Ma_hang) VALUES (null,?,?,?,?,?)");
            statement.setInt(1, ctiet.getSoluongN());
            statement.setInt(2, ctiet.getDongiaN());
            statement.setInt(3, ctiet.getGiaban());
            statement.setInt(4, ctiet.getMa_HDN()); 
            statement.setString(5, ctiet.getMa_hang());
            
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu_nhaphang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu_nhaphang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Nv_nhaphang TimHang(String ma_hang) {
        Nv_nhaphang hang = new Nv_nhaphang(); // khai báo biến
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM hang,loaihang,donvitinh,chitietnhap,hoadonnhap,nhacungcap "
                    + "WHERE hang.Ma_loaihang=loaihang.Ma_loaihang AND donvitinh.Ma_dvt=hang.Ma_dvt AND hang.Ma_hang=chitietnhap.Ma_hang "
                    + "AND hoadonnhap.Ma_HDN=chitietnhap.Ma_HDN AND nhacungcap.Ma_NCC=chitietnhap.Ma_NCC AND Ma_hang = ?");
            stm.setString(1, ma_hang);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                hang.setMa_hang(rs.getString("Ma_hang"));
                hang.setTen_hang(rs.getString("Ten_hang"));
                hang.setGiaban(rs.getInt("Giaban"));
                hang.setDongiaN(rs.getInt("DongiaN"));
                hang.setMa_loaihang(rs.getString("Ma_loaihang"));
                hang.setTen_loaihang(rs.getString("Ten_loaihang"));
                hang.setMa_dvt(rs.getInt("Ma_dvt"));
                hang.setTen_dvt(rs.getString("Ten_dvt"));
                hang.setMa_NCC(rs.getString("Ma_NCC"));
                hang.setTen_NCC(rs.getString("Ten_NCC"));
                hang.setMa_NV(rs.getString("Ma_NV"));
                hang.setSoluongN(rs.getInt("SoluongN"));
                hang.setNgay_nhap(rs.getString("Ngay_nhap"));
                
                return hang;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu_nhaphang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu_nhaphang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hang;
    }
    public Nv_nhaphang TimTenhang(String tenhang) {
        Nv_nhaphang hang = new Nv_nhaphang(); // khai báo biến
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM hang,loaihang,donvitinh,chitietnhap,hoadonnhap,nhacungcap "
                    + "WHERE hang.Ma_loaihang=loaihang.Ma_loaihang AND donvitinh.Ma_dvt=hang.Ma_dvt AND hang.Ma_hang=chitietnhap.Ma_hang "
                    + "AND hoadonnhap.Ma_HDN=chitietnhap.Ma_HDN AND nhacungcap.Ma_NCC=chitietnhap.Ma_NCC AND Ten_hang = ?");
            stm.setString(1, tenhang);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                hang.setMa_hang(rs.getString("Ma_hang"));
                hang.setTen_hang(rs.getString("Ten_hang"));
                hang.setGiaban(rs.getInt("Giaban"));
                hang.setDongiaN(rs.getInt("DongiaN"));
                hang.setMa_loaihang(rs.getString("Ma_loaihang"));
                hang.setTen_loaihang(rs.getString("Ten_loaihang"));
                hang.setMa_dvt(rs.getInt("Ma_dvt"));
                hang.setTen_dvt(rs.getString("Ten_dvt"));
                hang.setMa_NCC(rs.getString("Ma_NCC"));
                hang.setTen_NCC(rs.getString("Ten_NCC"));
                hang.setMa_NV(rs.getString("Ma_NV"));
                hang.setSoluongN(rs.getInt("SoluongN"));
                hang.setNgay_nhap(rs.getString("Ngay_nhap"));
                
                return hang;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONghiepvu_nhaphang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONghiepvu_nhaphang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hang;
    }
    
}
