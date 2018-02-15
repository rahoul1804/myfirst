package jpa.daoRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;


import jpa.daoMOdelEntity.EmployeeEntity;

@Repository
public interface RepositoryInterface extends JpaRepository<EmployeeEntity, Integer>,QueryDslPredicateExecutor<EmployeeEntity>
{
	
	public List<EmployeeEntity> findById(int i);
	
	public List<EmployeeEntity> findByName(String s);
	
	
	//----------- search by id name ---
	public List<EmployeeEntity> findByIdAndName(int i,String s);
//	public List<EmployeeEntity> findById(String i);
	
	//merge
	/*public List<EmployeeEntity> findByMergeSearch(String i,String s);
	public List<EmployeeEntity> findById(String i);
	public List<EmployeeEntity> findByIdAndName(String i,String s);*/
}
