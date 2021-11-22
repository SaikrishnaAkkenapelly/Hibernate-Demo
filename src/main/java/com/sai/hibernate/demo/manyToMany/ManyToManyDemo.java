package com.sai.hibernate.demo.manyToMany;

import java.util.List;

import com.sai.hibernate.demo.operations.DatabaseOperations;

public class ManyToManyDemo
{
	public static void main(String[] args)
	{
		try
		{
			//creating persons
			Person person = new Person();
			
			person.setFirstName("Saikrishna");
			person.setLastName("Akkenapelly");
			
			DatabaseOperations.create(person);
			
			person = new Person();
			
			person.setFirstName("Saiharini");
			person.setLastName("Akkenapelly");
			
			DatabaseOperations.create(person);
			
			List<Object> persons = DatabaseOperations.read(person, false);
			
			//creating property
			
			Property activa = new Property();
			
			activa.setPropertyName("Activa");
			persons.forEach((Object object ) ->
			{
				activa.getPersons().add((Person)object);	
			});
			
			DatabaseOperations.create(activa);
			
			Property inspiron = new Property();
			
			inspiron.setPropertyName("Inspiron");
			persons.forEach((Object object ) ->
			{
				inspiron.getPersons().add((Person)object);	
			});
			
			DatabaseOperations.create(inspiron);
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
