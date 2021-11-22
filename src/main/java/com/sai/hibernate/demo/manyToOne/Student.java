package com.sai.hibernate.demo.manyToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "STUDENT_ID")
	private Long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@ManyToOne(optional = false,fetch = FetchType.EAGER)//optional ensures not null
	private Guardian guardian;
	
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

	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian)
	{
		this.guardian = guardian;
	}

	@Override
	public String toString()
	{
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", guardian=" + guardian + "]";
	}
}
