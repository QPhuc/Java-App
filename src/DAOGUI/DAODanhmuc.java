
package DAOGUI;

import DBConnect.MySQLConnUtils;
import OBJGUI.Danhmuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAODanhmuc {
    public boolean ThemNhanvien(Danhmuc nhanvien){
        boolean check = false;
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO nhanvien (Ma_NV,Hoten,Diachi,Gioitinh,Ngaysinh,SDT) "
                    + "VALUES (?,?,?,?,?,?)");
            statement.setString(1, nhanvien.getMa_NV());
            statement.setString(2, nhanvien.getHoten());
            statement.setString(3, nhanvien.getDiachi());
            statement.setInt(4, nhanvien.getGioitinh());
            statement.setString(5, nhanvien.getNgaysinh());
            statement.setInt(6, nhanvien.getSDT());

            int rs = statement.executeUpdate();
            if(rs > 0){
                check = true;
            } 
            
        } catch(Exception e){
            
        }
        return check;
    }
    public Danhmuc TimNhanvien(String ma_nv) {
        Danhmuc danhmuc = new Danhmuc(); // khai báo biến
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM nhanvien WHERE Ma_NV = ?");// câu lện truy vấn đến mã sinh viên mà bạn muốn tìm
            stm.setString(1, ma_nv);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                danhmuc.setMa_NV(rs.getString("Ma_NV"));
                danhmuc.setHoten(rs.getString("Hoten"));
                danhmuc.setDiachi(rs.getString("Diachi"));
                danhmuc.setGioitinh(rs.getInt("Gioitinh"));
                danhmuc.setNgaysinh(rs.getString("Ngaysinh"));
                danhmuc.setSDT(rs.getInt("SDT"));
                return danhmuc;//trả về thông tin sinh viên đã tìm được
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhmuc;
    }
    
    public boolean SuaNhanVien(Danhmuc danhmuc) {
        try {
             //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE nhanvien SET Hoten=?,Diachi=?,Gioitinh=?,Ngaysinh=?,"
                    + "SDT=?  WHERE Ma_NV=? ");
            
            statement.setString(1, danhmuc.getHoten());
            statement.setString(2, danhmuc.getDiachi());
            statement.setInt(3, danhmuc.getGioitinh());
            statement.setString(4, danhmuc.getNgaysinh());
            statement.setInt(5, danhmuc.getSDT());
            statement.setString(6, danhmuc.getMa_NV());
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean XoaNhanVien(String danhmuc) {
        try {
            //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM nhanvien WHERE Ma_NV = ?");
            statement.setString(1, danhmuc);
            statement.execute();//thực hiện yêu cầu truy vấn 

            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
