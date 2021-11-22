package com.sai.hibernate.demo.xmlConfigEntity;

public class Employee
{
	private Long employeeId;
	private String firstName;
	private String lastName;  
	private Double salary;
	private Address address;

	public Long getEmployeeId()
	{
		return employeeId;
	}
	
	public void setEmployeeId(Long employeeId)
	{
		this.employeeId = employeeId;
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
	
	public Double getSalary()
	{
		return salary;
	}
	
	public void setSalary(Double salary)
	{
		this.salary = salary;
	}
	
	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}
	
	@Override
	public String toString()
	{
		return this.employeeId+"-"+this.firstName+"-"+this.lastName;
	}
}
