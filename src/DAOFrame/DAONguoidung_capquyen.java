
package DAOFrame;

import DAOGUI.DAONguoidung;
import DBConnect.MySQLConnUtils;
import OBJFrame.Nd_capquyen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAONguoidung_capquyen {
    public Nd_capquyen TimPhanhe(String ma_phanhe) {
        Nd_capquyen phanhe = new Nd_capquyen(); // khai báo biến
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM phanhe WHERE Ma_phanhe = ?");
            stm.setString(1, ma_phanhe);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                phanhe.setMa_phanhe(rs.getString("Ma_phanhe"));
                phanhe.setTen_phanhe(rs.getString("Ten_phanhe"));

                return phanhe;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAONguoidung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAONguoidung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phanhe;
    }
}
