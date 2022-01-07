package Controller;

import Entity.BukuEntity;
import java.util.ArrayList;

public class BukuControllerInterfaceImpl implements BukuControllerInterface{

    @Override
    public void insertBuku(String isbn, String judul, String penerbit, int terbit, int halaman) {
        AllObjectModel.bukuModel.add(new BukuEntity(isbn,judul,penerbit,terbit,halaman));
    }

    @Override
    public void deleteBuku(String isbn) {
        AllObjectModel.bukuModel.delete(isbn);
    }

    @Override
    public void updateBuku(int pilihan, String data, String isbn) {
        if(pilihan == 1){
            AllObjectModel.bukuModel.UpdateJudul(isbn, data);
        }else if (pilihan == 2){
            AllObjectModel.bukuModel.UpdatePenerbit(isbn, data);
        }
    }

    @Override
    public ArrayList<BukuEntity> showAllData() {
        return AllObjectModel.bukuModel.getAll();
    }

    @Override
    public BukuEntity getData(String isbn) {
        return AllObjectModel.bukuModel.getById(isbn);
    }    
}