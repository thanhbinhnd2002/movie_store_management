// Author: Nghiem Hong Dang

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class MySqlService {
    // Các thuộc tính
    public Connection conn;

    // Triển khai phương thức khởi tạo
    public MySqlService(){
        try{
            String strConn = "jdbc:mysql://localhost/film_management.sql";
            Properties pro = new Properties();
            pro.put("user", "root");
            pro.put("password", "");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/film_management", "root","");

        } catch (Exception e){
            conn = null;
        }
    }
}