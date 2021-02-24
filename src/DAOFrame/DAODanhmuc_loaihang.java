
package DAOFrame;

import DBConnect.MySQLConnUtils;
import OBJFrame.Dm_loaihang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAODanhmuc_loaihang {
    public boolean ThemLoaihang(Dm_loaihang lhang){
        boolean check = false;
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO loaihang (Ma_loaihang,Ten_loaihang) VALUES (?,?)");
            statement.setString(1, lhang.getMa_loaihang());
            statement.setString(2, lhang.getTen_loaihang());

            int rs = statement.executeUpdate();
            if(rs > 0){
                check = true;
            } 
            
        } catch(Exception e){
            
        }
        return check;
    }
    public Dm_loaihang TimLoaihang(String ma_lhang) {
        Dm_loaihang lhang = new Dm_loaihang(); // khai báo biến
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM loaihang WHERE Ma_loaihang = ?");
            stm.setString(1, ma_lhang);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                lhang.setMa_loaihang(rs.getString("Ma_loaihang"));
                lhang.setTen_loaihang(rs.getString("Ten_loaihang"));

                return lhang;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_loaihang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_loaihang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lhang;
    }
    
    public boolean XoaLoaihang(String lhang) {
        try {
            //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM loaihang WHERE Ma_loaihang = ?");
            statement.setString(1, lhang);

            statement.execute();//thực hiện yêu cầu truy vấn 

            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_loaihang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_loaihang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    } 
    public boolean SuaLhang(Dm_loaihang loaihang) {
        try {
             //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE loaihang SET Ten_loaihang=? WHERE Ma_loaihang=? ");
            
            statement.setString(1, loaihang.getTen_loaihang());
            statement.setString(2, loaihang.getMa_loaihang());

            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_loaihang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_loaihang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
