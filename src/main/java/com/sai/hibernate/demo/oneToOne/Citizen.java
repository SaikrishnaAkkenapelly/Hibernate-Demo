package com.sai.hibernate.demo.oneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITIZEN")
public class Citizen
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "CITIZEN_ID")
	private Long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	
	private Long getId()
	{
		return id;
	}
	
	private void setId(Long id)
	{
		this.id = id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Override
	public String toString()
	{
		return "Citizen [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
