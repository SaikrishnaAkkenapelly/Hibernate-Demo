package com.sai.hibernate.demo.manyToOne;

import com.sai.hibernate.demo.operations.DatabaseOperations;

public class ManyToOneDemo
{
	public static void main(String[] args)
	{
		try
		{
			//the following relation is many to one from student to guardian
			//creating guardian
			Guardian guardian = new Guardian();
			
			guardian.setFirstName("Saikrishna");
			guardian.setLastName("Akkenapelly");
			
			Long guardianId = DatabaseOperations.create(guardian);
			
			System.out.println("Guardian created with Id : " + guardianId);
			
			//creating students against guardian
			
			Student student = new Student();
			
			student.setFirstName("Srinish");
			student.setLastName("Sreepada");
			student.setGuardian(guardian);
			
			Long studentId = DatabaseOperations.create(student);
			
			System.out.println("Student created with id : " + studentId + " against guardian with id :" + guardianId);
			
			student.setFirstName("Srishtika");
			student.setLastName("Sreepada");
			student.setGuardian(guardian);
			
			studentId = DatabaseOperations.create(student);
			
			System.out.println("Student created with id : " + studentId + " against guardian with id :" + guardianId);
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
