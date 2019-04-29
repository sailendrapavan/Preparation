package persistence;

import domian.EmployeeEntity;

public class EmployeeDAO {

    private DataBaseStore enitityManager;
    public EmployeeDAO(DataBaseStore store) {
        this.enitityManager=store;
    }
    
    public EmployeeEntity getEmployeeById(int id)
    {
        
        
    }
}
