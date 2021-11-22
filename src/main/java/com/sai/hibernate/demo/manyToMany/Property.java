package com.sai.hibernate.demo.manyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTY")
public class Property
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "PROPERTY_ID")
	private Long propertyId;
	@Column(name = "NAME")
	private String propertyName;
	@ManyToMany(targetEntity = Person.class, fetch = FetchType.EAGER)
	private List<Person> persons = new ArrayList<Person>();
	
	private Long getPropertyId()
	{
		return propertyId;
	}
	
	private void setPropertyId(Long propertyId)
	{
		this.propertyId = propertyId;
	}
	
	public String getPropertyName()
	{
		return propertyName;
	}
	
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}

	public List<Person> getPersons()
	{
		return persons;
	}

	private void setPersons(List<Person> persons)
	{
		this.persons = persons;
	}

	@Override
	public String toString()
	{
		return "Property [propertyId=" + propertyId + ", propertyName=" + propertyName + ", persons=" + persons + "]";
	}
}
