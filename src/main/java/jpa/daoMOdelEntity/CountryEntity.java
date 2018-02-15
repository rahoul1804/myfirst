package jpa.daoMOdelEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountryEntity 
{
	@Id
	String cid;
	String country;
	
	
	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "CountryPojo [cid=" + cid + ", country=" + country + "]";
	}

}
