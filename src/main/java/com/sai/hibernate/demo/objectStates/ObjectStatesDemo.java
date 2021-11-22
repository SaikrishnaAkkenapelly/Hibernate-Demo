package com.sai.hibernate.demo.objectStates;

import org.hibernate.Session;

import com.sai.hibernate.demo.caching.Book;
import com.sai.hibernate.demo.operations.DatabaseOperations;

public class ObjectStatesDemo
{
	public static void main(String[] args)
	{
		try
		{
			Session session = DatabaseOperations.openSession();
			
			//example 1
			session.beginTransaction();
			//new state
			Book book = new Book();
			
			//transient state
			book.setName("The magic of thinking big");
			book.setCost(500.00);
			book.setAuthor("David");
			
			Long id = (Long) session.save(book);
			//persistence state -> changes made to POJO are reflected in database table and made permanent once commit
			System.out.println(session.get(Book.class,id));
			book.setCost(600.00);
			System.out.println(session.get(Book.class,id));
			
			session.getTransaction().commit();
			
			//example 2			
			session.beginTransaction();
			book = session.get(Book.class,id);
			//persistence state -> changes made to POJO are reflected in database table and made permanent once commit
			System.out.println(book);
			
			session.detach(book);
			//detached state
			book.setCost(800.00);
			System.out.println(session.get(Book.class,id));
			
			session.getTransaction().commit();
			
			//example 3
			session.beginTransaction();
			book = session.get(Book.class,id);
			//persistence state -> changes made to POJO are reflected in database table and made permanent once commit
			System.out.println(book);
			
			session.remove(book);
			//removed state
			book.setCost(1000.00);
			System.out.println(session.get(Book.class,id));
			
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
