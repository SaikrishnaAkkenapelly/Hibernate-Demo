package com.sai.hibernate.demo.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;

import com.sai.hibernate.demo.operations.DatabaseOperations;

public class CachingDemo
{
	public static void main(String[] args)
	{
		try
		{
			//Creating some data to demo caching
			Random random = new Random();
			for(int count = 0; count < 100; count++)
			{
				Book book = new Book();
				book.setName("IKIGAI_"+random.nextInt(1000));
				book.setAuthor("HECTOR_"+random.nextInt(1000));
				book.setCost(Double.valueOf(random.nextInt(1000)));
				
				DatabaseOperations.create(book);
			}

			//Hibernate provides 2 caching mechanisms
			
			//1.First level caching -> caching data in the same session
			Book book = new Book();
			
			Session session = DatabaseOperations.openSession();
			session.beginTransaction();
			
			book = (Book)session.get(book.getClass(),10l);
			System.out.println(book);
			
			System.out.println("Getting the same record again, no sql query will be formed since the result is already stored in first level cache");
			
			book = (Book)session.get(book.getClass(),10l);
			System.out.println(book);
			
			session.getTransaction().commit();
			DatabaseOperations.closeSession(session);
			
			//2.Second level caching -> caching data in cross sessions
			book = new Book();
			
			book = (Book)DatabaseOperations.read(book, 11l);
			System.out.println(book);
			
			System.out.println("Getting the same record again, no sql query will be formed since the result is already stored in second level cache");
			
			book = (Book)DatabaseOperations.read(book, 11l);
			System.out.println(book);
			
			//2.Second level caching for list of objects -> caching data in cross sessions
			List<Object> books = new ArrayList<Object>();
			
			books = DatabaseOperations.read(book, true);
			books.forEach(System.out::println);
			
			System.out.println("Getting the same records again, no sql query will be formed since the result is already stored in second level cache");
			
			books = DatabaseOperations.read(book, true);
			books.forEach(System.out::println);
		}
		finally
		{
			DatabaseOperations.closeSessionFactory();
		}
	}
}
