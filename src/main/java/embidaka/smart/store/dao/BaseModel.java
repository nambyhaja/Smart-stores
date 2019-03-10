package embidaka.smart.store.dao;

import embidaka.smart.stores.dto.BaseDto;

public class BaseModel extends BaseDto{

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
    
    
}
