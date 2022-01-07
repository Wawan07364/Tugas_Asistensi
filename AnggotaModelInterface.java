package Model;
import Entity.AnggotaEntity;
import Helper.DbUtil;
import java.sql.*;
import java.util.ArrayList;

public interface AnggotaModelInterface {
    Connection conn = DbUtil.getConnection();
    
    void add(AnggotaEntity anggota);
    void remove(int id);
    int login(String nama, String password);
    ArrayList<AnggotaEntity> getAllData();
    AnggotaEntity getById (int id);
    void resetpassword(int id);
    void updatenoTelp(String noTelp, int id);
    void updateAlamat(String alamat, int id);
    void updatenPassword(String password, int id);
}
