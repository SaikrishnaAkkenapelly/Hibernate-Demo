package com.sai.hibernate.demo.getVsLoad;

import org.hibernate.Session;

import com.sai.hibernate.demo.caching.Book;
import com.sai.hibernate.demo.operations.DatabaseOperations;

public class GetVsLoad
{
	public static void main(String[] args)
	{
		try
		{
			Session session = DatabaseOperations.openSession();
			//get example
			session.beginTransaction();
			//get method will hit the database and get the record immediately
			Book book = session.get(Book.class,50l);
			System.out.println("Sleeping..");
			Thread.sleep(5000);
			System.out.println("Awake..");
			System.out.println(book);
			
			session.getTransaction().commit();
			
			//load example
			session.beginTransaction();
			//load method will hit the database and get the record when used
			book = session.load(Book.class,51l);
			System.out.println("Sleeping..");
			Thread.sleep(5000);
			System.out.println("Awake..");
			System.out.println(book);
			
			session.getTransaction().commit();
			
			session.close();
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
