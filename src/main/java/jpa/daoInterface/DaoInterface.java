package jpa.daoInterface;

import java.util.List;

import jpa.daoMOdelEntity.CountryEntity;
import jpa.daoMOdelEntity.EmployeeEntity;
import jpa.daoMOdelEntity.StateEntity;

public interface DaoInterface {
	
	
	public EmployeeEntity save(EmployeeEntity ee);
	
	public List<EmployeeEntity> findEmpAll();
	
	public void deleteemp(int id);
	
	//-----edit-----//
	public List<EmployeeEntity> getId(int s);

	
	//-----------search----------//
	//byname//
	public List<EmployeeEntity> searchEmpByNameDao(String s);
	//byID//
	public List<EmployeeEntity> searchEmpByIdDao(int s);
	//public List<EmployeeEntity> searchEmpByIdDao(String s);

	//by id and name
    public List<EmployeeEntity> searchEmpByIdAndNameDao(int i,String s);

    //mergeSearch//
    
   /* public List<EmployeeEntity> searchEmpMergeDao(String i,String s);*/

	 
    //---------login------------//
    
    //login same method of view,,,findEmpAll()  //
    
    //---pagination----
    public List<EmployeeEntity> getEmpByPageDao(int pageid,int total);
    
    
    //======== State ===============
    public List<StateEntity> getAllStates(String cid) ;
    
    //========== Country ================================
    public  List<CountryEntity> daoGetAllCountry();
    
    
}
