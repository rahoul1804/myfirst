package jpa.daoRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import jpa.daoMOdelEntity.EmployeeEntity;

@Repository
public interface RepositoryInterface extends JpaRepository<EmployeeEntity, Integer>
{
	
	public List<EmployeeEntity> findById(int i);
	public List<EmployeeEntity> findByName(String s);
}
