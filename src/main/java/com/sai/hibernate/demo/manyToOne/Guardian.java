package com.sai.hibernate.demo.manyToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GUARDIAN")
public class Guardian
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "GUARDIAN_ID")
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
		return "Guardian [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
