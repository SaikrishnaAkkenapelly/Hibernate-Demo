package com.sai.hibernate.demo.fetchingTechniques;

import java.util.List;

import org.hibernate.Session;

import com.sai.hibernate.demo.manyToMany.Property;
import com.sai.hibernate.demo.oneToMany.College;
import com.sai.hibernate.demo.operations.DatabaseOperations;

public class FetchingTechniqueDemo
{
	public static void main(String[] args)
	{
		try
		{
			//EAGER
			//EAGER fetch type will get the child entity objects are well when reading the parent entity
			//this will form a join query with a single fetch
			List<Object> properties = DatabaseOperations.read(new Property(), false);
			
			properties.forEach((Object property) ->
			{
				System.out.println(property);
			});
			
			//LAZY
			//LAZY fetch type will get the child entity objects only when used
			//we need a session to be kept open for lazy fetching
			Session session = DatabaseOperations.openSession();
			session.beginTransaction();
			
			//only college is fetched here with a simple query
			Object college = session.get(College.class, 1l);
			System.out.println("college object fetched but not with teachers");
			//fetching of teachers is done here with a join query
			System.out.println("now teachers are being fetched");
			System.out.println(college);
			
			session.getTransaction().commit();
			DatabaseOperations.closeSession(session);
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
