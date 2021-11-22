package com.sai.hibernate.demo.annotationConfigEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class Department
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "DEPARTMENT_ID")
	private Long departmentId;
	
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	private Asset asset;
	
	public Long getDepartmentId()
	{
		return departmentId;
	}
	
	public void setDepartmentId(Long departmentId)
	{
		this.departmentId = departmentId;
	}
	
	public String getDepartmentName()
	{
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}

	public Asset getAsset()
	{
		return asset;
	}

	public void setAsset(Asset asset)
	{
		this.asset = asset;
	}
	
	@Override
	public String toString()
	{
		return this.departmentId+"-"+this.departmentName+"-"+this.asset;
	}
}
