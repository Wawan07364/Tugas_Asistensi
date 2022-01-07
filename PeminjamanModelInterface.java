package Model;

import Entity.PeminjamanEntity;
import Helper.DbUtil;
import java.sql.Connection;
import java.util.ArrayList;

public interface PeminjamanModelInterface {
    Connection conn = DbUtil.getConnection();

    void add(PeminjamanEntity peminjaman);
    void verifPengembalian(String idPeminjaman);
    ArrayList<PeminjamanEntity> getAll();
    ArrayList<PeminjamanEntity> getByPeminjaman(int id);
}
