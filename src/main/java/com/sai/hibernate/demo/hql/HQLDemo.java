package com.sai.hibernate.demo.hql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.sai.hibernate.demo.caching.Book;
import com.sai.hibernate.demo.operations.DatabaseOperations;

public class HQLDemo
{
	public static void main(String[] args)
	{
		try
		{
			//Creating some data in e_order table to demo HQL
			ThreadLocalRandom currThreadRandom = ThreadLocalRandom.current();
			List<Object> books = DatabaseOperations.read(new Book(), true);
			for(int count = 1; count <= 5; count++)
			{
				Order order = new Order();
				List<Book> orderedBooks = new ArrayList<Book>();
				
				Book book = (Book)books.get(currThreadRandom.nextInt(1,50));
				orderedBooks.add(book);
				order.setOrderSum(book.getCost());
				
				book = (Book)books.get(currThreadRandom.nextInt(50,100));
				orderedBooks.add(book);
				order.setOrderSum(order.getOrderSum() + book.getCost());
				
				order.setBooks(orderedBooks);
				order.setOrderDateTime(LocalDateTime.now());
				DatabaseOperations.create(order);
			}
			
			//HQL is not bothered about the table names and column names it uses only class names and variable names
			//HQL from clause
			List<Object> orders = DatabaseOperations.read(new Order(),true);
			orders.forEach(System.out::println);

			Session session = DatabaseOperations.openSession();
			session.beginTransaction();
			
			//HQL where clause -> orderSum is the variable name and order is the class name
			Query<Object> query = session.createQuery("from Order where orderSum > 1000");
			orders = query.list();
			orders.forEach(System.out::println);
			
			//uniqueResult() will give a single record or null
			query = session.createQuery("from Order where orderId = 3");
			Object order = query.uniqueResult();
			System.out.println(order);
			
			//HQL specific column in select
			query = session.createQuery("select orderSum from Order");
			//object in the list is an instance of same class as of orderSum variable in order class
			List<Object> orderSums = query.list();
			orderSums.forEach(System.out::println);
			
			//HQL specific column in select with where clause
			query = session.createQuery("select orderSum from Order where orderId = 3");
			//object here is an instance of same class as of orderSum variable in order class
			Object orderSum = query.uniqueResult();
			System.out.println(orderSum);
			
			//HQL some columns in select with where clause
			query = session.createQuery("select orderDateTime,orderSum from Order where orderId = 3");
			//here it will return an object of array, since we have selected only some columns
			Object selectedColumns[] = (Object[])query.uniqueResult();
			System.out.println("orderDateTime : "+selectedColumns[0] + " orderSum : "+selectedColumns[1]);
			
			query = session.createQuery("select orderDateTime,orderSum from Order where orderId > 3");
			//in the list every object is an object of an array since we have selected only some columns
			List<Object> selectedData = query.list();
			selectedData.forEach((Object row) -> 
			{
				Object data[] = (Object[])row;
 				System.out.println("orderDateTime : "+data[0] + " orderSum : "+data[1]);
			});
			
			//example of an aggregate function 
			query = session.createQuery("select sum(orderSum) from Order where orderId > 3");
			//aggregate function will return only one record so unique result can be used
			Object sum = query.uniqueResult();
			System.out.println("Sum of all orders is :"+sum);
			
			//HQL with user parameter
			query = session.createQuery("from Order where orderId > :input");
			query.setParameter("input", 3l);
			orders = query.list();
			orders.forEach(System.out::println);
			
			//HQL raw SQL query
			NativeQuery<Object> nativeQuery = session.createSQLQuery("select * from e_order where order_sum > 500");
			nativeQuery.addEntity(Order.class);
			orders = nativeQuery.list();
			orders.forEach(System.out::println);
			
			nativeQuery = session.createSQLQuery("select order_sum from e_order where order_sum > 1000");
			//object in the list is an instance of same class as of orderSum variable in order class
			orders = nativeQuery.list();
			orders.forEach(System.out::println);
			
			nativeQuery = session.createSQLQuery("select order_sum,order_date from e_order where order_sum > 1000");
			//in the list every object is an object of an array since we have selected only some columns
			orders = nativeQuery.list();
			orders.forEach((Object row) -> 
			{
				Object values[] = (Object[])row;
				System.out.println("orderSum : "+values[0] + " orderDateTime : "+values[1]);
			});
			
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
