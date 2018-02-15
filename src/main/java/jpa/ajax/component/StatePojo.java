package jpa.ajax.component;


import org.springframework.stereotype.Component;

@Component
public class StatePojo 
{
	
	String cid;
	String sid;
	String state;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
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
		return "StatePojo [cid=" + cid + ", sid=" + sid + ", state=" + state + "]";
	}
	
	

}
