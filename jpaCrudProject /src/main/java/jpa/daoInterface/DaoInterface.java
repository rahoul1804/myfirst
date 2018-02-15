package jpa.daoInterface;

import java.util.List;


import jpa.daoMOdelEntity.EmployeeEntity;

public interface DaoInterface {
	
	
	public EmployeeEntity save(EmployeeEntity ee);
	
	public List<EmployeeEntity> findEmpAll();
	
	public void deleteemp(int id);
	
	//-----edit-----//
	public List<EmployeeEntity> getId(int s);

	
	//-----------search----------//
	public List<EmployeeEntity> search(String s);

}
