package jpa.daoImplimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jpa.controllerModelPojo.EmployeePojo;
import jpa.daoInterface.DaoInterface;
import jpa.daoMOdelEntity.EmployeeEntity;
import jpa.daoRepository.RepositoryInterface;

@Repository
public class DaoImplimenatation implements DaoInterface{
	
	@Autowired
	RepositoryInterface ri;
	
	//=== insert ===/
	public EmployeeEntity save(EmployeeEntity ee) {
		//System.out.println("inside Dao");
		EmployeeEntity e1=ri.save(ee);
		//System.err.println(e1);
		return e1;
	}

	//=== view == /
	public List<EmployeeEntity> findEmpAll() {
		return  ri.findAll();
	}

	
	
	//----delete-----//
	public void deleteemp(int id) 
	{
		ri.delete(id);
	}
	
	
	//---------------edit------------//
	
	
	public List<EmployeeEntity> getId(int s)
	{
		List<EmployeeEntity> se=ri.findById(s);
		return se;
		
	}

	
	//------------------search--------------//
	public List<EmployeeEntity> search(String s) 
	{
		List<EmployeeEntity> sel=ri.findByName(s);
		return sel;
	}
	
	
	
	
	
	
}
