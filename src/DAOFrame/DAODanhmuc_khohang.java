
package DAOFrame;

import DBConnect.MySQLConnUtils;
import OBJFrame.Dm_khohang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAODanhmuc_khohang {
    public boolean ThemKhohang(Dm_khohang khohang){
        boolean check = false;
        try {
            //kết nối đến cơ sở dữ liệu
            
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO khohang (Ma_khohang,Ten_khohang) VALUES (?,?)");
            statement.setString(1, khohang.getMa_khohang());
            statement.setString(2, khohang.getTen_khohang());
    
            int rs = statement.executeUpdate();
            if(rs > 0){
                check = true;
            } 
            
        } catch(Exception e){
            
        }
        return check;
    }

    public Dm_khohang TimKhohang(String makho) {
        Dm_khohang nguoidung = new Dm_khohang(); // khai báo biến
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM khohang WHERE Ma_khohang = ?");
            stm.setString(1, makho);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                nguoidung.setMa_khohang(rs.getString("Ma_khohang"));
                nguoidung.setTen_khohang(rs.getString("Ten_khohang"));

                return nguoidung;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_khohang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_khohang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nguoidung;
    }
    
    public boolean SuaKhohang(Dm_khohang khohang) {
        try {
             //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE khohang SET Ten_khohang=?  WHERE Ma_khohang=? ");
            
            statement.setString(1, khohang.getMa_khohang());
            statement.setString(2, khohang.getTen_khohang());

            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_khohang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_khohang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean XoaKhohang(String tk) {
        try {
            //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM khohang WHERE Ma_khohang = ?");
            statement.setString(1, tk);

            statement.execute();//thực hiện yêu cầu truy vấn 

            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_khohang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_khohang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    

        public boolean ThemCTkho(Dm_khohang ctietkho){
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO chitietkho (Ma_CTkho,Ma_khohang,Ma_hang,SL_tonkho) VALUES (null,?,?,?)");
            statement.setString(1, ctietkho.getMa_khohang());
            statement.setString(2, ctietkho.getMa_hang());
            statement.setInt(3, ctietkho.getSL_tonkho());

            
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_khohang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_khohang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
