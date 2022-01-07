package Entity;

public class AdminEntity extends UserEntityAbstract {
    int id;

    public AdminEntity(int id, String nama, String password) {
        super(nama, password);       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
