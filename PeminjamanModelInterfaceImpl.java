package Model;

import Entity.AnggotaEntity;
import Entity.BukuEntity;
import Entity.PeminjamanEntity;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;

public class PeminjamanModelInterfaceImpl implements PeminjamanModelInterface{
    
    private String generateIdPeminjaman(){
    String newId = null;
    String data;
        try {
            String sql = "SELECT peminjaman_id FROM peminjaman ORDER BY peminjaman_id DESC LIMIT 1";
            Statement stat =conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()){
                data = rs.getString("peminjaman_id");
            }else{
                data = "PJM000";
            }
            int angka = Integer.parseInt(data.substring(3));
            angka++;
            newId = "PJM"+String.format("%03d",angka);
        }catch(Exception e){
            e.printStackTrace();
        }
        return newId;
    }
    
    @Override
    public void add(PeminjamanEntity peminjaman) {
        try {
            String sql = "INSERT INTO peminjaman(peminjaman_id, buku_isbn, anggota_id, peminjaman_tgl, status) values (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,generateIdPeminjaman());
            statement.setString(2,peminjaman.getBuku().getIsbn());
            statement.setInt(3,peminjaman.getAnggota().getId());
            statement.setDate(4,Date.valueOf(LocalDate.now()));
            statement.setBoolean(5,false);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void verifPengembalian(String idPeminjaman) {
        try {
            String sql = "UPDATE peminjaman SET pengembalian_tgl = ?, status = true WHERE peminjaman_id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(2, idPeminjaman);
            stat.setDate(1, Date.valueOf(LocalDate.now()));
            stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<PeminjamanEntity> getAll() {
    ArrayList<PeminjamanEntity> listPeminjaman = new ArrayList<>();
        try {
            String sql = "SELECT p.*,  b.buku_judul, a.anggota_nama, a.anggota_password\n"
                          + "FROM peminjaman p\n" 
                          + "JOIN anggota a on p.anggota_id = a.anggota_id\n"
                          + "JOIN buku b on p.buku_isbn = b.buku_isbn\n" 
                          + "ORDER BY peminjaman_id";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                PeminjamanEntity peminjaman = new PeminjamanEntity();
                peminjaman.setIdPeminjaman(rs.getString("peminjaman_id"));
                BukuEntity buku = new BukuEntity();
                buku.setJudul(rs.getString("buku_judul"));
                buku.setIsbn(rs.getString("buku_isbn"));
                peminjaman.setBuku(buku);
                AnggotaEntity anggota = new AnggotaEntity(rs.getString("anggota_nama"),
                                                          rs.getString("anggota_password"));
                peminjaman.setAnggota(anggota);
                peminjaman.setTglPeminjaman(rs.getDate("peminjaman_tgl"));
                peminjaman.setTglPengembalian(rs.getDate("pengembalian_tgl"));
                peminjaman.setStatusPeminjaman(rs.getBoolean("status"));
                listPeminjaman.add(peminjaman);
            }
        } catch (SQLException e) {
            e.printStackTrace();                  
        }
        return listPeminjaman;
    }

    @Override
    public ArrayList<PeminjamanEntity> getByPeminjaman(int id) {
        ArrayList<PeminjamanEntity> peminjamanByUSer = new ArrayList<>();
        try {
            String sql = "SELECT p.*, b.buku_judul FROM peminjaman p "
                  + "Join buku b on p.buku_isbn = b.buku_isbn "
                  + "WHERE anggota_id = ? "
                  + "ORDER BY peminjaman_tgl ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                PeminjamanEntity peminjaman = new PeminjamanEntity();
                peminjaman.setIdPeminjaman(rs.getString("peminjaman_id"));
                BukuEntity buku = new BukuEntity();
                buku.setJudul(rs.getString("buku_judul"));
                buku.setIsbn(rs.getString("buku_isbn"));
                peminjaman.setBuku(buku);
                               
                peminjaman.setTglPeminjaman(rs.getDate("peminjaman_tgl"));
                peminjaman.setTglPengembalian(rs.getDate("pengembalian_tgl"));
                peminjaman.setStatusPeminjaman(rs.getBoolean("status"));
                peminjamanByUSer.add(peminjaman);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peminjamanByUSer;
    }    
}