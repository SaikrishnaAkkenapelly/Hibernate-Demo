package com.sai.hibernate.demo.oneToOne;

import java.time.LocalDateTime;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "PASSPORT")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Passport
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "PASSPORT_ID")
	private Long id;
	@Column(name = "DATE_OF_ISSUE")
	private LocalDateTime dateOfIssue;
	@Column(name = "DATE_OF_EXPIRY")
	private LocalDateTime dateOfExpiry;
	@OneToOne(optional = false, fetch = FetchType.EAGER)//optional ensures not null and one to one ensures unique on foreign key
	private Citizen citizen;
	
	private Long getId()
	{
		return id;
	}
	
	private void setId(Long id)
	{
		this.id = id;
	}
	
	public LocalDateTime getDateOfIssue()
	{
		return dateOfIssue;
	}
	
	public void setDateOfIssue(LocalDateTime dateOfIssue)
	{
		this.dateOfIssue = dateOfIssue;
	}
	
	public LocalDateTime getDateOfExpiry()
	{
		return dateOfExpiry;
	}
	
	public void setDateOfExpiry(LocalDateTime dateOfExpiry)
	{
		this.dateOfExpiry = dateOfExpiry;
	}
	
	public Citizen getCitizen()
	{
		return citizen;
	}
	
	public void setCitizen(Citizen citizen)
	{
		this.citizen = citizen;
	}

	@Override
	public String toString()
	{
		return "Passport [id=" + id + ", dateOfIssue=" + dateOfIssue + ", dateOfExpiry=" + dateOfExpiry + ", citizen=" + citizen + "]";
	}
}
