package com.sai.hibernate.demo.oneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COLLEGE")

public class College
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "COLLEGE_ID")
	private Long collegeId;
	
	@Column(name = "COLLEGE_NAME")
	private String collegeName;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Teacher> teachers = new ArrayList<Teacher>();

	private Long getCollegeId()
	{
		return collegeId;
	}

	private void setCollegeId(Long collegeId)
	{
		this.collegeId = collegeId;
	}

	public String getCollegeName()
	{
		return collegeName;
	}

	public void setCollegeName(String collegeName)
	{
		this.collegeName = collegeName;
	}

	public List<Teacher> getTeachers()
	{
		return teachers;
	}

	private void setTeachers(List<Teacher> teachers)
	{
		this.teachers = teachers;
	}

	@Override
	public String toString()
	{
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", teachers=" + teachers + "]";
	}
}
