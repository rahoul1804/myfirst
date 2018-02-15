package jpa.daoImplimentation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.impl.JPAQuery;

import jpa.daoInterface.DaoInterface;
import jpa.daoMOdelEntity.CountryEntity;
import jpa.daoMOdelEntity.EmployeeEntity;
import jpa.daoMOdelEntity.QEmployeeEntity;
import jpa.daoMOdelEntity.StateEntity;
import jpa.daoRepository.CountryReposiory;
import jpa.daoRepository.RepositoryInterface;
import jpa.daoRepository.StateRepository;

@Repository
public class DaoImplimenatation implements DaoInterface{
	
	@Autowired
	RepositoryInterface ri;
	
	@Autowired
	CountryReposiory cri;
	
	@Autowired
	JdbcTemplate template;
	
	@Autowired
	StateRepository sri;
	
	
	
	public void setTemplate(JdbcTemplate template) 
	{
		this.template = template;
	}
	
	@PersistenceContext
	private EntityManager entitymanager;
	
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
	//byname//
	public List<EmployeeEntity> searchEmpByNameDao(String s) 
	{
		//List<EmployeeEntity> sel=ri.findByName(s);
		List<EmployeeEntity> sel=searchByNameByDSL(s);
		return sel;
	}
	
	//querDSl//
	public List<EmployeeEntity> searchByNameByDSL(String nameEmp)
	{
		JPAQuery query=new JPAQuery(entitymanager);
		QEmployeeEntity employee=QEmployeeEntity.employeeEntity;
		
		List<EmployeeEntity> emp=query.from(employee).where(employee.name.eq(nameEmp)).list(employee);
		return emp;
		
	}
	
	//byId//
		public List<EmployeeEntity> searchEmpByIdDao(int s) 
		{
			List<EmployeeEntity> sel=ri.findById(s);
			return sel;
		}
	//by idAndNAme//
		public List<EmployeeEntity> searchEmpByIdAndNameDao(int i,String s)
		{
			List<EmployeeEntity> sel=ri.findByIdAndName(i, s);
			return sel;
		}
	//merge search//
	/*	
		
		public List<EmployeeEntity> searchEmpMergeDao(String i,String s)
		{

			 

				if((s.equals(null) || s.isEmpty())&& ((i.equals(null) || i.isEmpty())))
				{ 
					return ri.findAll();
				}
				 
				else if(s != null && !s.isEmpty() && ( i.equals(null) || i.equals("")) )
					{
					List<EmployeeEntity> se=ri.findByName(s);
					return se;
					}

				else if(s.equals(null) || s.equals("")&& (i!= null && !i.isEmpty()))
				{
					List<EmployeeEntity> se=ri.findById(i);
					return se;
				}
				
				else if(s != null && !s.isEmpty()&& ( !i.equals(null) || !i.equals("")) )
				{
				List<EmployeeEntity> se=ri.findByMergeSearch(i, s);
				return se;
				}
				return null;
		}
*/
		/*public List<EmployeeEntity> searchEmpByIdDao(String s) 
		{
			List<EmployeeEntity> sel=ri.findById(s);
			return sel;
		}*/

	
			 
			/*
			if((s.equals(null) || s.isEmpty())&& (check.equals(null) || check.isEmpty()))
			{
				return ri.findAll();
			}
			else if(((s.equals(null)) || s.isEmpty()) && (check!=null || !check.isEmpty()))
			{
				return ri.findById(i);
			}
			else if((!s.equals(null)) || (!s.isEmpty()) && (check.equals(null) || check.isEmpty()))
			{ 
				return ri.findByName(s);
			}
			return ri.findByIdAndName(i, s);*/
		 		
			
		
		
		
		
	 
    //---------login------------//
    
    //login same method of view,,,findEmpAll()  //
	
	

//------pagination----
public List<EmployeeEntity> getEmpByPageDao(int pageid, int total)
{  
    String sql="select * from EmployeeEntity limit "+(pageid-1)+","+total;  
    
    return template.query(sql,new RowMapper<EmployeeEntity>()
    {  
        public EmployeeEntity mapRow(ResultSet rs, int row) throws SQLException 
        {  
        	EmployeeEntity e=new EmployeeEntity(); 
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(4));  
            e.setAge(rs.getInt(2));
            e.setCountry(rs.getString(3));
            e.setPassword(rs.getString(5));
            e.setState(rs.getString(6));
            e.setDate(rs.getString(7));
            return e;  
        }  
    });  
  }

//===========  State ================

@Override
public List<StateEntity> getAllStates(String cid) 
{
	//-------TRY WITH JDBCTEMPLATE ROWMAPER------//
	/*String qry="select state from StateEntity join CountryEntity on StateEntity.cid=CountryEntity.cid where StateEntity.cid=? ";
	Object[] obj={cid};
	   return template.query(qry, obj, new RowMapper<StateEntity>()
	{
		    public StateEntity mapRow(ResultSet rs, int arg1) throws SQLException 
		    {
				StateEntity se=new StateEntity();
			    se.setState(rs.getString(1));
				return se;
			}
		    }
	   );*/
    System.err.println(cid);
    //--------------TRY WITH @Query-------//
	//List<StateEntity> ss= sri.findByState(cid);	
	//System.err.println(ss);
    
    //-------FIND BY DIRECTLY TAKING CID -------//
	return sri.findByCid(cid);
}



//public List<StateEntity> getAllStates(String countrycode) {
//  String QUERY="select statecode,statename from state join country on state.countrycode=country.countrycode where state.countrycode=?";
//  Object[] obj={countrycode};
//  return jdbcTemplate.query(QUERY,obj,new RowMapper<StateEntity>(){
//
//	public StateEntity mapRow(ResultSet rs, int arg1) throws SQLException {
//		StateEntity se=new StateEntity();
//	    se.setStatecode(rs.getString(1));
//	    se.setStatename(rs.getString(2));
//		return se;
//	}});
//}





//============ Country  =====================
@Override
public List<CountryEntity> daoGetAllCountry() {
	return cri.findAll();
}  

//public List<CountryEntity> getAllCountries() 
//{
//      return repo1.findAll();
//}

}
	

