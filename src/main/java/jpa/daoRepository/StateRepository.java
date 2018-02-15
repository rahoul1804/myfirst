package jpa.daoRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jpa.daoMOdelEntity.StateEntity;

//@Repository
public interface StateRepository extends JpaRepository<StateEntity, String>
{

	
	    //@Query("select state from StateEntity join CountryEntity on StateEntity.cid=CountryEntity.cid where StateEntity.cid=s1")
		//@Query("SELECT s.state FROM StateEntity s join CountryEntity e ON s.cid = e.cid where s.cid=?")
		//public List<StateEntity> findByState( String s1);
		public List<StateEntity> findByCid( String s1);

}
