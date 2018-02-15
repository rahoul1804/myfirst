package jpa.serviceInterface;

import java.util.List;

import jpa.ajax.component.CountryPojo;
import jpa.ajax.component.StatePojo;
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
     //byname//
    public List<EmployeePojo> searchEmpByNameService(String s);
    //byId//
   // public List<EmployeePojo> searchEmpByIdService(String s);
    public List<EmployeePojo> searchEmpByIdService(int s);
    //by IDandNAme//
    public List<EmployeePojo> searchEmpByIdAndNameService(int i,String s);
    
    //by idNameMerge//
  /*  public List<EmployeePojo> searchEmpMergeService(String i, String s);*/
    
    //---------login------------//
    
    //login same method of view,,,findEmpAll()  //
    
    
    
    //----pagination------
    
    public List<EmployeePojo> getEmpByPage(int pageid, int total);
    
    //=========== State ============
    public List<StatePojo> getAllstates(String s);    
    //==== Get All County ===================
    public List<CountryPojo> getAllCountries();
    
    
}
