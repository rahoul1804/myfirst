package jpa.daoRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jpa.daoMOdelEntity.CountryEntity;
import jpa.daoMOdelEntity.StateEntity;

//@Repository
public interface CountryReposiory extends JpaRepository<CountryEntity, String>
{
	
	//@Query(select  s.state FROM  StateEntity s INNER JOIN CountryEntity e ON e.cid = s.cid WHERE s.cid =?)
	//@Query("SELECT s.state FROM StateEntity s join CountryEntity e ON s.cid = e.cid where s.cid=?")
	//public List<StateEntity> findByState(String s1);

}
