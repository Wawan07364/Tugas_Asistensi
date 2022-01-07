package Entity;

import Entity.AnggotaEntity;
import Entity.BukuEntity;
import java.util.Date;

public class PeminjamanEntity {
     private String idPeminjaman;
     private BukuEntity buku;
     private AnggotaEntity anggota;
     private Date tglPeminjaman;
     private Date tglPengembalian;
     private boolean statusPeminjaman;

    public PeminjamanEntity(BukuEntity buku, AnggotaEntity anggota) {
        this.buku = buku;
        this.anggota = anggota;
    }

    public PeminjamanEntity() {
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public BukuEntity getBuku() {
        return buku;
    }

    public void setBuku(BukuEntity buku) {
        this.buku = buku;
    }

    public AnggotaEntity getAnggota() {
        return anggota;
    }

    public void setAnggota(AnggotaEntity anggota) {
        this.anggota = anggota;
    }

    public Date getTglPeminjaman() {
        return tglPeminjaman;
    }

    public void setTglPeminjaman(Date tglPeminjaman) {
        this.tglPeminjaman = tglPeminjaman;
    }

    public Date getTglPengembalian() {
        return tglPengembalian;
    }

    public void setTglPengembalian(Date tglPengembalian) {
        this.tglPengembalian = tglPengembalian;
    }

    public boolean isStatusPeminjaman() {
        return statusPeminjaman;
    }

    public void setStatusPeminjaman(boolean statusPeminjaman) {
        this.statusPeminjaman = statusPeminjaman;
    }
}
