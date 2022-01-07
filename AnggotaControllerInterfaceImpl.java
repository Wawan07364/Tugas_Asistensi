package Controller;

import Entity.AnggotaEntity;
import java.util.ArrayList;

public class AnggotaControllerInterfaceImpl implements AnggotaControllerInterface{

    @Override
    public void insertAnggota(String nama, String password, String noTelp, String alamat) {
        AnggotaEntity anggota = new AnggotaEntity(nama,password,noTelp,alamat);
        AllObjectModel.anggotaModel.add(anggota);
    }

    @Override
    public int login(String nama, String password) {
        return AllObjectModel.anggotaModel.login(nama, password);
    }

    @Override
    public ArrayList<AnggotaEntity> showAllData() {
        return AllObjectModel.anggotaModel.getAllData();
    }

    @Override
    public AnggotaEntity getDataId(int id) {
        return AllObjectModel.anggotaModel.getById(id);
    }

    @Override
    public void updateAkun(int pilihan, String data, int id) {
        if (pilihan == 1){
            AllObjectModel.anggotaModel.updatenPassword(data, id);
        }else if (pilihan == 2){
            AllObjectModel.anggotaModel.updateAlamat(data, id);
        }else if (pilihan == 3){
            AllObjectModel.anggotaModel.updatenoTelp(data, id);
        }
    }    
}
