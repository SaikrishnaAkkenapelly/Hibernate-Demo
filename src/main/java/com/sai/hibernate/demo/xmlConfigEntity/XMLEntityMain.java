package com.sai.hibernate.demo.xmlConfigEntity;

import java.util.List;

import com.sai.hibernate.demo.operations.DatabaseOperations;

public class XMLEntityMain
{
	public static void main(String[] args)
	{
		try
		{
			//Employee entity is created using XML mapping file
			
			//Simple insertion
			Long employeeId = 0l;
			Employee developer = new Employee();
			
			developer.setFirstName("Saikrishna");
			developer.setLastName("Akkenapelly");
			developer.setSalary(100000.00);
			
			employeeId = DatabaseOperations.create(developer);
			
			System.out.println("Record inserted into Employee table with employeeId "+employeeId);
			
			//Insertion with embedded object
			Address address = new Address();
			developer = new Employee();
			
			address.setHouseNo("6-3/a");
			address.setStreet("Adams Street");
			address.setLandmark("Chemical Factory");
			address.setZipcode("123321");
			address.setCountry("India");
			
			developer.setFirstName("Harini");
			developer.setLastName("Akkenapelly");
			developer.setSalary(100000.00);
			developer.setAddress(address);
			  
			employeeId = DatabaseOperations.create(developer);
			
			System.out.println("Record inserted into Employee table with employeeId "+employeeId);
			
			//Fetching all employees
			List<Object> employees = DatabaseOperations.read(new Employee(),false);
			
			employees.forEach(System.out::println);
			
			//Fetch specific employee with primary key
			Object employee = DatabaseOperations.read(new Employee(), 1l);
			
			System.out.println(employee);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DatabaseOperations.closeSessionFactory();
		}
	}
}
