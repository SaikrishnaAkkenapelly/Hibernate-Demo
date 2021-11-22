package com.sai.hibernate.demo.annotationConfigEntity;

import com.sai.hibernate.demo.operations.DatabaseOperations;

public class AnnotationEntityDemo
{
	public static void main(String[] args)
	{
		try
		{
			//Department POJO is created using annotations
			
			//Simple insertion
			Long departmentId = 0l;
			Department developemet = new Department();
			
			developemet.setDepartmentName("Development");
			
			departmentId = DatabaseOperations.create(developemet);
			
			System.out.println("Record inserted into Department table with departmentId "+departmentId);
			
			//Inserting into department with embedded object asset
			departmentId = 0l;
			Asset asset = new Asset();
			developemet = new Department();
			
			asset.setAssetName("Laptop");
			asset.setAssetValue(10000.00);
			
			developemet.setDepartmentName("Development");
			developemet.setAsset(asset);
			
			departmentId = DatabaseOperations.create(developemet);
			
			System.out.println("Record inserted into Department table with departmentId "+departmentId);
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
