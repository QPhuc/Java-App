
package DAOFrame;

import DBConnect.MySQLConnUtils;
import OBJFrame.Dm_nhacc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAODanhmuc_nhacc {
        public boolean ThemNhaCC(Dm_nhacc nhacc){
        boolean check = false;
        try {
            
            //kết nối đến cơ sở dữ liệu
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            //thực hiện câu lệnh truy vấn
            PreparedStatement statement = conn.prepareStatement("INSERT INTO nhacungcap (Ma_NCC,Ten_NCC,Diachi_NCC,SDT_NCC,Nghi_CCap,No_NCC) VALUES (?,?,?,?,?,0)");
            statement.setString(1, nhacc.getMa_NCC());
            statement.setString(2, nhacc.getTen_NCC());
            statement.setString(3, nhacc.getDiachi_NCC());
            statement.setInt(4, nhacc.getSDT_NCC());
            statement.setInt(5, nhacc.getNghi_CCap());

            int rs = statement.executeUpdate();
            if(rs > 0){
                check = true;
            } 
            
        } catch(Exception e){
            
        }
        return check;
    }
    public Dm_nhacc TimNhacc(String ma_nhacc) {
        Dm_nhacc nhacc = new Dm_nhacc(); // khai báo biến
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM nhacungcap WHERE Ma_NCC = ?");
            stm.setString(1, ma_nhacc);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                nhacc.setMa_NCC(rs.getString("Ma_NCC"));
                nhacc.setTen_NCC(rs.getString("Ten_NCC"));
                nhacc.setDiachi_NCC(rs.getString("Diachi_NCC"));
                nhacc.setSDT_NCC(rs.getInt("SDT_NCC"));
                nhacc.setNghi_CCap(rs.getInt("Nghi_CCap"));
                nhacc.setNo_NCC(rs.getInt("No_NCC"));
                return nhacc;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_nhacc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_nhacc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhacc;
    }
    public boolean XoaNhacungcap(String cungcap) {
        try {
            //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM nhacungcap WHERE Ma_NCC = ?");
            statement.setString(1, cungcap);

            statement.execute();//thực hiện yêu cầu truy vấn 

            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_nhacc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_nhacc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean SuaNhaCC(Dm_nhacc nhacc) {
        try {
             //Kết nối CSDL
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE nhacungcap SET Ten_NCC=?,Diachi_NCC=?,SDT_NCC=?,Nghi_CCap=? "
                    + "WHERE Ma_NCC=? ");
            
            statement.setString(1, nhacc.getTen_NCC());
            statement.setString(2, nhacc.getDiachi_NCC());
            statement.setInt(3, nhacc.getSDT_NCC());
            statement.setInt(4, nhacc.getNghi_CCap());
            statement.setString(5, nhacc.getMa_NCC());
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAODanhmuc_nhacc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAODanhmuc_nhacc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
