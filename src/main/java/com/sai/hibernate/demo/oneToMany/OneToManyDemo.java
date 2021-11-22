package com.sai.hibernate.demo.oneToMany;

import java.util.List;

import com.sai.hibernate.demo.operations.DatabaseOperations;

public class OneToManyDemo
{
	public static void main(String[] args)
	{
		try
		{
			//creating teachers
			Teacher teacher = new Teacher();
			
			teacher.setFirstName("Saikrishna");
			teacher.setLastName("Akkenapelly");
			
			DatabaseOperations.create(teacher);
			
			teacher = new Teacher();
			
			teacher.setFirstName("Saiharini");
			teacher.setLastName("Akkenapelly");
			
			DatabaseOperations.create(teacher);
			
			//creating college
			College college = new College();
			
			college.setCollegeName("ASKCET");
			
			List<Object> teachers = DatabaseOperations.read(teacher, false);
			
			teachers.forEach((Object object)->
			{
				college.getTeachers().add((Teacher)object);
			});
			
			DatabaseOperations.create(college);
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
