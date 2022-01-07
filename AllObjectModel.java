package Controller;

import Model.AdminModelInterface;
import Model.AdminModelInterfaceImpl;
import Model.AnggotaModelInterface;
import Model.AnggotaModelInterfaceImpl;
import Model.BukuModelInterface;
import Model.BukuModelInterfaceImpl;
import Model.PeminjamanModelInterface;
import Model.PeminjamanModelInterfaceImpl;

public class AllObjectModel {
    public static AdminModelInterface adminModel = new AdminModelInterfaceImpl();
    public static AnggotaModelInterface anggotaModel = new AnggotaModelInterfaceImpl();
    public static BukuModelInterface bukuModel = new BukuModelInterfaceImpl();
    public static PeminjamanModelInterface peminjamanModel = new PeminjamanModelInterfaceImpl();
}
