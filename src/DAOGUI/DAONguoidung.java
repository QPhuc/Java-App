
package DAOGUI;

import DBConnect.MySQLConnUtils;
import OBJGUI.Nguoidung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAONguoidung {
    public boolean ThemNguoidung(Nguoidung nguoidung){
        boolean check = false;
        try {
            //kết nối đến cơ sở dữ liệu
            
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO nguoidung (Taikhoan,Matkhau,quyen) VALUES (?,?,?)");
            statement.setString(1, nguoidung.getTaikhoan());
            statement.setString(2, nguoidung.getMatkhau());
            statement.setInt(3, nguoidung.getquyen()); 
            int rs = statement.executeUpdate();
            if(rs > 0){
                check = true;
            } 
            
        } catch(Exception e){
            
        }
        return check;
    }

    public Nguoidung TimNguoidung(String taikhoan) {
        Nguoidung nguoidung = new Nguoidung(); // khai báo biến
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM nguoidung WHERE Taikhoan = ?");
            stm.setString(1, taikhoan);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                nguoidung.setTaikhoan(rs.getString("Taikhoan"));
                nguoidung.setMatkhau(rs.getString("Matkhau"));
                nguoidung.setquyen(rs.getInt("quyen"));
                return nguoidung;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONguoidung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONguoidung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nguoidung;
    }
    
    public boolean SuaNguoidung(Nguoidung nguoidung) {
        try {
             //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE nguoidung SET Matkhau=?,quyen=?  WHERE Taikhoan=? ");
            
            statement.setString(1, nguoidung.getMatkhau());
            statement.setInt(2, nguoidung.getquyen());
            statement.setString(3, nguoidung.getTaikhoan());

            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONguoidung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONguoidung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean XoaNguoidung(String tk) {
        try {
            //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM nguoidung WHERE Taikhoan = ?");
            statement.setString(1, tk);

            statement.execute();//thực hiện yêu cầu truy vấn 

            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONguoidung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONguoidung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean Doimatkhau(Nguoidung nguoidung) {
        try {
             //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE nguoidung SET Matkhau=?  WHERE Taikhoan=? ");
            
            statement.setString(1, nguoidung.getMatkhau());
            statement.setString(2, nguoidung.getTaikhoan());

            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONguoidung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONguoidung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
