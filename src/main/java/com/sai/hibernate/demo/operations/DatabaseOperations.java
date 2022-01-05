package com.sai.hibernate.demo.operations;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DatabaseOperations
{
	private static SessionFactory sessionFactory = null;
	
	/**
	 * Creates a session factory on load
	 */
	static 
	{
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(HibernateException hibernateException)
		{
			hibernateException.printStackTrace();
		}
	}

	/**
	 * Opens a session
	 * @return
	 */
	public static Session openSession()
	{
		try
		{
			return sessionFactory.openSession();
		}
		catch(HibernateException hibernateException)
		{
			hibernateException.printStackTrace();
	    		return null;
	    	}
	}
	
	/**
	 * Closes the given session
	 * @param session
	 */
	public static void closeSession(Session session)
	{
		if(session != null)
    			session.close();
	}
	
	/**
	 * Closes the session factory created on load
	 * @param session
	 */
	public static void closeSessionFactory()
	{
		if(sessionFactory != null)
			sessionFactory.close();	
	}
	
	/**
	 * Creates a record in respective table associated with the given object
	 * @param object
	 * @return id
	 */
	public static Long create(Object object)
	{
		Long id = 0l;
		Session session = null;
	    
	    try
	    {
	    	session = sessionFactory.openSession();
	    	session.beginTransaction();
	    	id = (Long)session.save(object);
	    	session.getTransaction().commit();
	    }
	    catch(HibernateException hibernateException)
	    {
	    	hibernateException.printStackTrace();
	    	session.getTransaction().rollback();
	    }
	    finally
	    {
	    	if(session != null)
	    		session.close();
	    }
	    
	    return id;
	}
	
	/**
	 * Reads a single record from respective table associated with the given object using the given id 
	 * @param object
	 * @param id
	 * @return object 
	 */
	public static Object read(Object object,Long id)
	{
		Object record = null;
		Session session = null;
		
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			record = session.get(object.getClass(),id);
			session.getTransaction().commit();
		}
		catch(HibernateException hibernateException)
	   	 {
	    		hibernateException.printStackTrace();
	    		session.getTransaction().rollback();
	   	 }
		finally
		{
			if(session != null)
	    		session.close();
		}
		
		return record;
	}
	
	/**
	 * Reads records from respective table associated with the given object 
	 * @param object
	 * @param cacheableYn
	 * @return object list 
	 */
	public static List<Object> read(Object object,Boolean cacheableYn)
	{
		List<Object> records = null;
		Session session = null;
		Query<Object> query = null;
		
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			query = session.createQuery("FROM "+object.getClass().getSimpleName());
			query.setCacheable(cacheableYn);
			records = query.list();
			session.getTransaction().commit();
		}
		catch(HibernateException hibernateException)
	 	{
	    	hibernateException.printStackTrace();
	    	session.getTransaction().rollback();
	   	}
		finally
		{
			if(session != null)
	    			session.close();
		}
		
		return records;
	}
	
	/**
	 * Updates a single record in respective table associated with the given object using it's id
	 * This has to be used after fetching that particular record from table using read method 
	 * @param object
	 */
	public static void update(Object object)
	{
		Session session = null;
		
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		}
		catch(HibernateException hibernateException)
	    	{
	    		hibernateException.printStackTrace();
	    		session.getTransaction().rollback();
	    	}
		finally
		{
			if(session != null)
	    		session.close();
		}
	}
	
	/**
	 * Deletes a single record in respective table associated with the given object using it's id
	 * This has to be used after fetching that particular record from table using read method
	 * @param object
	 */
	public static void delete(Object object)
	{
		Session session = null;
		
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		}
		catch(HibernateException hibernateException)
	   	{
	    		hibernateException.printStackTrace();
	    		session.getTransaction().rollback();
	   	}
		finally
		{
			if(session != null)
	    		session.close();
		}
	}
}
