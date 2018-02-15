package jpa.serviceImplimentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jpa.ajax.component.CountryPojo;
import jpa.ajax.component.StatePojo;
import jpa.controllerModelPojo.EmployeePojo;
import jpa.daoInterface.DaoInterface;
import jpa.daoMOdelEntity.CountryEntity;
import jpa.daoMOdelEntity.EmployeeEntity;
import jpa.daoMOdelEntity.StateEntity;
import jpa.serviceInterface.ServiceInterface;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


@Service
public class ServiceImplimenatation implements ServiceInterface {
	
	@Autowired
	DaoInterface di;
	
	//----------reg--------------//
	//--------------encrypt decrypt-----------//
	private static Random rand = new Random((new Date()).getTime());//Use for randomly select 
	 
	public static String encrypt(String str) 
	{
		   BASE64Encoder encoder = new BASE64Encoder();
		   byte[] salt = new byte[8];
		   rand.nextBytes(salt);
		   return encoder.encode(salt) + encoder.encode(str.getBytes());
		     }
	
	 //======== Decrypt fnction ==================
	
	 public static String decrypt(String encstr)
	 {
		   if (encstr.length() > 12) 
		   {
		 String cipher = encstr.substring(12);
		 BASE64Decoder decoder = new BASE64Decoder();
		 try {
		     return new String(decoder.decodeBuffer(cipher));
		 } catch (IOException e) 
		 {
		     //  throw new InvalidImplementationException(
		     //Fail
		 }
		   }
		   return null;
		     }//----------------------------------//
	
	
	public EmployeePojo save(EmployeePojo ep)
	{	//System.out.println("inside Service");
		
		EmployeeEntity ee=new EmployeeEntity();
		//System.err.println(ep);
		
		//---------by beansutil-----------//
		/*BeanUtils.copyProperties(ep,ee);  //Converting Employee Pojjo To Employee Entity
		//System.err.println(ee);
		
		EmployeeEntity ee1=di.save(ee);
		
		EmployeePojo ep1=new EmployeePojo();
		BeanUtils.copyProperties(ee1, ep1); //Converting Employee Entity to Employee Pojo
*/		
		//--------------------//
		
		ee.setId(ep.getId());
		ee.setName(ep.getName());
		ee.setAge(ep.getAge());
		ee.setDate(ep.getDate());
		ee.setCountry(ep.getCountry());
		ee.setState(ep.getState());
		ee.setPassword(encrypt(ep.getPassword()));
		EmployeeEntity ee1=di.save(ee);
		
		
		EmployeePojo ep1=new EmployeePojo();
		ep1.setId(ee1.getId());
		ep1.setName(ee1.getName());
		ep1.setAge(ee1.getAge());
		ep1.setDate(ee1.getDate());
		ep1.setCountry(ee1.getCountry());
		ep1.setState(ee1.getState());
		ep1.setPassword(decrypt(ee1.getPassword()));
		
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
			
			//----encrypted-----//
			ep.setId(ee.getId());
			ep.setName(ee.getName());
			ep.setAge(ee.getAge());
			ep.setDate(ee.getDate());
			ep.setCountry(ee.getCountry());
			ep.setState(ee.getState());
			ep.setPassword(decrypt(ee.getPassword()));
			
			//---without encrypted----//
			//BeanUtils.copyProperties(ee,ep);
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

		//byname//
		 public List<EmployeePojo> searchEmpByNameService(String s)
		 {
			 
			 List<EmployeeEntity> e= di.searchEmpByNameDao(s);
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
			 }
		
		//byId//
		 public List<EmployeePojo> searchEmpByIdService(int s)
		 {
			 
			 List<EmployeeEntity> e= di.searchEmpByIdDao(s);
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
		 }
		 
		//-----------------
		/* public List<EmployeePojo> searchEmpByIdService(String s)
		 {
			 
			 List<EmployeeEntity> e= di.searchEmpByIdDao(s);
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
		 }*/
		 //=================

		 //search byId and name//
		public List<EmployeePojo> searchEmpByIdAndNameService(int i, String s)
		{
			
			List<EmployeeEntity> e= di.searchEmpByIdAndNameDao(i, s);
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
		}
			 
		// Search By ID NAme merge //
		/*public List<EmployeePojo> searchEmpMergeService(String i, String s)
		{

			List<EmployeeEntity> e= di.searchEmpMergeDao(i, s);
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
		}*/

		/*public List<EmployeePojo> searchEmpByIdService(int s) {
			// TODO Auto-generated method stub
			return null;
		}*/

				/*public List<EmployeePojo> searchByName(String name) 
				{
					List<EmployeePojo> list=new ArrayList<EmployeePojo>();
					//EmployeeEntity entity=new EmployeeEntity();
					
					List<EmployeeEntity> elist=di.searchByName(name);
					Iterator<EmployeeEntity> it=elist.iterator();
					
					while(it.hasNext()){
						EmployeeEntity se=it.next();
						EmployeePojo st=new EmployeePojo();
						
						BeanUtils.copyProperties(se,st);
						list.add(st);
					}
					return list;
				}*/
		
				
				 
			//-------------------------login--------------------------//
			    
			    //login same method of view,,,findEmpAll()  //
		

		
		
		//----pagination----
		public List<EmployeePojo> EntityListToModel(List<EmployeeEntity> elist)
		{		
			List slist=new ArrayList();	
			Iterator it=elist.iterator();	
			while(it.hasNext())
			{		
				EmployeeEntity se=(EmployeeEntity) it.next();	
				EmployeePojo me=EntitytoModel(se);	
				slist.add(me);	
			}
			return slist;
		}
		
		public  EmployeePojo EntitytoModel(EmployeeEntity ec) {
			
			EmployeePojo c=new EmployeePojo();
			 c.setId(ec.getId());
	          c.setName(ec.getName());
	          c.setCountry(ec.getCountry());
	          c.setAge(ec.getAge());
	          c.setPassword(ec.getPassword());
	          c.setState(ec.getState());
			return c;
		}

		
		public List<EmployeePojo> getEmpByPage(int pageid, int total)
		{
			List<EmployeeEntity> ec=di.getEmpByPageDao(pageid,total);
			List<EmployeePojo> c=EntityListToModel(ec);
			return c;
		}

		//=========  Sate ================/
		
		@Override
		public List<StatePojo> getAllstates(String s)

		{
			List<StateEntity> se= di.getAllStates(s);
	        
	        System.out.println(se);
	        
	        List<StatePojo> sm=new ArrayList<StatePojo>();
	        for(StateEntity entity:se){
	        	StatePojo model=new StatePojo();
	      	  BeanUtils.copyProperties(entity, model);
	            sm.add(model);
	        }
			return sm;
		}	
		
		//============= Country ====
		public List<CountryPojo> getAllCountries()
		{ 
         List<CountryEntity> se= di.daoGetAllCountry();
	        
	        System.out.println(se);
	        
	        List<CountryPojo> sm=new ArrayList<CountryPojo>();
	        for(CountryEntity entity:se)
	        {
	        	CountryPojo model=new CountryPojo();
	      	    BeanUtils.copyProperties(entity, model);
	            sm.add(model);
	        }
			return sm;
			
		}
		
		

		
		
		

	
		
		
}
