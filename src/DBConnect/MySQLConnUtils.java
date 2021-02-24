package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnUtils {

    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {
        String hostName = "localhost";//tên host
        String dbName = "banhang";//tên database trong CSDL
        String userName = "root";//mặc định
        String password = "";//để rỗng
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
            String userName, String password) throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        //dường dẫn và chỉnh để hiện tiếng việt:?useUnicode=true&characterEncoding=utf-8
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName+""
                + "?useUnicode=true&characterEncoding=utf-8";

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}