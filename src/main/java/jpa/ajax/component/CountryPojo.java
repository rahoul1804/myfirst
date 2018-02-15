package jpa.ajax.component;

import org.springframework.stereotype.Component;

@Component
public class CountryPojo 
{
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
