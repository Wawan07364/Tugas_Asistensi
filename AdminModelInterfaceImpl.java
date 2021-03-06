package Model;

import java.sql.*;
import java.sql.ResultSet;

public class AdminModelInterfaceImpl implements AdminModelInterface{

    @Override
    public boolean login(String nama, String password) {
        boolean login = false;
        try {
            String sql = "SELECT * FROM admin Where admin_nama =? AND admin_password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
             if(rs.next()){
                login = true;
            }else {
                login = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }    
}
