package jpa.serviceInterface;

import java.util.List;


import jpa.controllerModelPojo.EmployeePojo;
import jpa.daoMOdelEntity.EmployeeEntity;

public interface ServiceInterface {
	
	public EmployeePojo save(EmployeePojo ep);
	
	public List<EmployeePojo> findEmpAll();
	
	public void delete(int i);
	
	//----edit-------//
	public EmployeePojo getEmployeById(int id);
	
    public EmployeePojo editSave(EmployeePojo emp);
    
    //---------search--------//

    public List<EmployeePojo> search(String s);
}
