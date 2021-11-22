package com.sai.hibernate.demo.xmlConfigEntity;

import javax.persistence.Embeddable;

@Embeddable
public class Address
{
	private String houseNo;
	private String street;
	private String landmark;
	private String zipcode;
	private String country;
	
	public String getHouseNo()
	{
		return houseNo;
	}
	
	public void setHouseNo(String houseNo)
	{
		this.houseNo = houseNo;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public String getLandmark()
	{
		return landmark;
	}
	
	public void setLandmark(String landmark)
	{
		this.landmark = landmark;
	}
	
	public String getZipcode()
	{
		return zipcode;
	}
	
	public void setZipcode(String zipcode)
	{
		this.zipcode = zipcode;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	@Override
	public String toString()
	{
		return this.houseNo+"-"+this.street+"-"+this.landmark+"-"+this.zipcode+"-"+this.country;
	}
}
