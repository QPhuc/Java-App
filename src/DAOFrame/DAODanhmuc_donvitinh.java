
package DAOFrame;

import DBConnect.MySQLConnUtils;
import OBJFrame.Dm_donvitinh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAODanhmuc_donvitinh {
    public boolean ThemDVT(Dm_donvitinh dvt){
        boolean check = false;    
        try {
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO donvitinh (Ma_dvt,Ten_dvt) VALUES (?,?)");
            statement.setString(1, dvt.getMa_dvt());
            statement.setString(2, dvt.getTen_dvt());

    
            int rs = statement.executeUpdate();
            if(rs > 0){
                check = true;
            } 
            
        } catch(Exception e){
            
        }
        return check;
    }
    public Dm_donvitinh TimDVT(String ma_dvt) {
        Dm_donvitinh dvt = new Dm_donvitinh(); // khai báo biến
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM donvitinh WHERE Ma_dvt = ?");
            stm.setString(1, ma_dvt);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dvt.setMa_dvt(rs.getString("Ma_dvt"));
                dvt.setTen_dvt(rs.getString("Ten_dvt"));

                return dvt;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_donvitinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_donvitinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dvt;
    }
    
    public boolean XoaDVT(String dvt) {
        try {
            //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM donvitinh WHERE Ma_dvt = ?");
            statement.setString(1, dvt);

            statement.execute();//thực hiện yêu cầu truy vấn 

            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_donvitinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_donvitinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }     
    public boolean SuaDVT(Dm_donvitinh dvt) {
        try {
             //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE donvitinh SET Ten_dvt=? WHERE Ma_dvt=? ");
            
            statement.setString(1, dvt.getTen_dvt());
            statement.setString(2, dvt.getMa_dvt());

            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_donvitinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_donvitinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
