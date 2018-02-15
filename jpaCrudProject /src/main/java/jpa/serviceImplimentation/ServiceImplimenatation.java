package jpa.serviceImplimentation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jpa.controllerModelPojo.EmployeePojo;
import jpa.daoInterface.DaoInterface;
import jpa.daoMOdelEntity.EmployeeEntity;
import jpa.serviceInterface.ServiceInterface;


@Service
public class ServiceImplimenatation implements ServiceInterface {
	
	@Autowired
	DaoInterface di;
	
	public EmployeePojo save(EmployeePojo ep)
	{	//System.out.println("inside Service");
		
		EmployeeEntity ee=new EmployeeEntity();
		//System.err.println(ep);
		
		BeanUtils.copyProperties(ep,ee);  //Converting Employee Pojjo To Employee Entity
		//System.err.println(ee);
		
		EmployeeEntity ee1=di.save(ee);
		
		EmployeePojo ep1=new EmployeePojo();
		BeanUtils.copyProperties(ee1, ep1); //Converting Employee Entity to Employee Pojo
		
		
		return ep1; // Returning Employee Pojo to Controller 
	}

	//-------------- view =======//
	
	/*public List<EmployeePojo> findEmpAll()
	{
		List<EmployeeEntity> e=di.findEmpAll();
		List<EmployeePojo> list=new ArrayList<EmployeePojo>();
		Iterator<EmployeeEntity> itr=e.iterator();
		
		while(itr.hasNext())
		{
			EmployeeEntity ee=itr.next();
			EmployeePojo ep=new EmployeePojo();
			ep.setId(ee.getId());
			ep.setName(ee.getName());
			ep.setAge(ee.getAge());
			ep.setCountry(ee.getCountry());
			list.add(ep);
		}
		return list;
	}*/
	
	    public List<EmployeePojo> findEmpAll() {

		List<EmployeeEntity> ve=di.findEmpAll();
		List<EmployeePojo> list=new ArrayList<EmployeePojo>();
		Iterator<EmployeeEntity> itr=ve.iterator();
		
		while(itr.hasNext())
		{
			EmployeeEntity ee=itr.next();
			EmployeePojo ep=new EmployeePojo();
			
			BeanUtils.copyProperties(ee,ep);
			list.add(ep);
		}	
		return list;
	}
	    

	    //---------delete-----------//
	    
		public void delete(int id) 
		
		{
			di.deleteemp(id);
		}
		
		//--------------edit------------//
		
		

		public EmployeePojo getEmployeById(int id) 
		{
			List<EmployeeEntity> el=di.getId(id);
			Iterator<EmployeeEntity> itr=el.iterator();
	      	List<EmployeePojo> model=new ArrayList<EmployeePojo>();
	      	
	      	EmployeePojo st=new EmployeePojo();
	      	
	      	while(itr.hasNext())
	      	{
	      		EmployeeEntity ep=itr.next();
	      		
	      		BeanUtils.copyProperties(ep, st);

		}
			return st;
     }
		
		

		public EmployeePojo editSave(EmployeePojo emp) 
		{
			EmployeeEntity ee=new EmployeeEntity();
			//System.err.println(ep);
			
			BeanUtils.copyProperties(emp,ee);  //Converting Employee Pojjo To Employee Entity
			//System.err.println(ee);
			
			EmployeeEntity ee1=di.save(ee);
			
			EmployeePojo ep1=new EmployeePojo();
			BeanUtils.copyProperties(ee1, ep1); //Converting Employee Entity to Employee Pojo
			
			
			return ep1; 
			
		}
		
		
		
		//-------------search-------------//

		 public List<EmployeePojo> search(String s)
		 {
			 
			 List<EmployeeEntity> e= di.search(s);
			 List<EmployeePojo> list=new ArrayList<EmployeePojo>();
	    		Iterator<EmployeeEntity> itr=e.iterator();
	    		
	    		while(itr.hasNext())
	    		{
	    			EmployeeEntity se=itr.next();
	    			EmployeePojo ep=new EmployeePojo();
	    			BeanUtils.copyProperties(se,ep);
 
	    			list.add(ep);
	    		}
				return list;
			 

//				public List<EmployeePojo> searchByName(String name) 
//				{
//					List<EmployeePojo> list=new ArrayList<EmployeePojo>();
//					//EmployeeEntity entity=new EmployeeEntity();
//					
//					List<EmployeeEntity> elist=di.searchByName(name);
//					Iterator<EmployeeEntity> it=elist.iterator();
//					
//					while(it.hasNext()){
//						EmployeeEntity se=it.next();
//						EmployeePojo st=new EmployeePojo();
//						
//						BeanUtils.copyProperties(se,st);
//						list.add(st);
//					}
//					return list;
//				}
		
		
}
}
