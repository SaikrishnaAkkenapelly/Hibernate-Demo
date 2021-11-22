package com.sai.hibernate.demo.oneToOne;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.sai.hibernate.demo.operations.DatabaseOperations;

public class OneToOneDemo
{
	public static void main(String[] args)
	{
		try
		{
			//the following relation is one to one from passport to citizen
			//creating a citizen
			Citizen citizen = new Citizen();
			
			citizen.setFirstName("Saikrishna");
			citizen.setLastName("Akkenapelly");
			
			Long citizenId = DatabaseOperations.create(citizen);
			
			System.out.println("Citizen created with id: "+citizenId);
			
			//creating a passport against citizen
			Passport passport = new Passport();
			
			passport.setDateOfIssue(LocalDateTime.now());
			passport.setDateOfExpiry(LocalDateTime.now().plus(5,ChronoUnit.YEARS));
			passport.setCitizen(citizen);
			
			Long passportId = DatabaseOperations.create(passport);
			
			System.out.println("Passport created for citizen : " + citizenId + "with id : " + passportId );
			
			//fetching passports
			
			List<Object> passports = DatabaseOperations.read(new Passport(), true);
			
			passports.forEach(System.out::println);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DatabaseOperations.closeSessionFactory();	
		}
	}
}
