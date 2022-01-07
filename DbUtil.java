package Helper;
import java.sql.*;

public class DbUtil {
    public static Connection getConnection(){
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver"; 
        String url = "jdbc:mysql://localhost:3306/db_perpus07364";  
        String user = "root";
        String pass = "";
        try{
            Class.forName(driver);                              
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Berhasil Koneksi database");
        }catch(Exception e){   
            System.out.println("Gagal Koneksi database");
            e.printStackTrace(); 
        }
        return conn;
    }
}
