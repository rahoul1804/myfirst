package jpa.daoMOdelEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.ForeignKey;

@Entity
public class StateEntity 
{
	@ForeignKey(name = "cid")
	String cid;
	@Id
	String sid;
	String state;
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "StatePojo [cid=" + cid + ", state=" + state + "]";
	}
	
	

}
