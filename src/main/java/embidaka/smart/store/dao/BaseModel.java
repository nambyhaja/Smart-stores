package embidaka.smart.store.dao;

public abstract class BaseModel {

    private int id;

    public BaseModel() {
    }

    public BaseModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public abstract BaseModel getInstance();
}
