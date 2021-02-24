
package DAOFrame;

import DBConnect.MySQLConnUtils;
import OBJFrame.Dm_khachhang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAODanhmuc_khachhang {
        public boolean ThemKhachhang(Dm_khachhang khachhang){
        boolean check = false;
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO khachhang (Ma_KH,Ten_KH,Diachi,SDT,No_dau) VALUES (null,?,?,?,0)");
//            statement.setInt(1, khachhang.getMa_KH());
            statement.setString(1, khachhang.getTen_KH());
            statement.setString(2, khachhang.getDiachi());
            statement.setInt(3, khachhang.getSDT());

            int rs = statement.executeUpdate();
            if(rs > 0){
                check = true;
            } 
            
        } catch(Exception e){
            
        }
        return check;
    }
    public Dm_khachhang TimKhachhang(String ma_kh) {
        Dm_khachhang khachhang = new Dm_khachhang(); // khai báo biến
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM khachhang WHERE Ma_KH = ?");
            stm.setString(1, ma_kh);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                khachhang.setMa_KH(rs.getInt("Ma_KH"));
                khachhang.setTen_KH(rs.getString("Ten_KH"));
                khachhang.setDiachi(rs.getString("Diachi"));
                khachhang.setSDT(rs.getInt("SDT"));
                khachhang.setNo_dau(rs.getInt("No_dau"));
                return khachhang;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_khachhang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_khachhang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachhang;
    }
    public boolean XoaKhachhang(String kh) {
        try {
            //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM khachhang WHERE Ma_KH = ?");
            statement.setString(1, kh);

            statement.execute();//thực hiện yêu cầu truy vấn 

            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_khachhang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_khachhang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        public boolean SuaKhachhang(Dm_khachhang khachhang) {
        try {
             //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE khachhang SET Ten_KH=?,Diachi=?,SDT=? WHERE Ma_KH=? ");
            
            statement.setString(1, khachhang.getTen_KH());
            statement.setString(2, khachhang.getDiachi());
            statement.setInt(3, khachhang.getSDT());
            statement.setInt(4, khachhang.getMa_KH());
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_khachhang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_khachhang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
