package com.sai.hibernate.demo.manyToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "PERSON_ID")
	private Long personId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	
	private Long getPersonId()
	{
		return personId;
	}

	private void setPersonId(Long personId)
	{
		this.personId = personId;
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
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
