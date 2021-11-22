package com.sai.hibernate.demo.caching;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "BOOK")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Book
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "BOOK_ID")
	private Long bookId;
	@Column(name = "BOOK_NAME")
	private String name;
	@Column(name = "BOOK_COST")
	private Double cost;
	@Column(name = "BOOK_AUTHOR")
	private String author;
	
	public Long getBookId()
	{
		return bookId;
	}
	
	public void setBookId(Long id)
	{
		this.bookId = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Double getCost()
	{
		return cost;
	}
	
	public void setCost(Double cost)
	{
		this.cost = cost;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}

	@Override
	public String toString()
	{
		return "Book [bookId=" + bookId + ", name=" + name + ", cost=" + cost + ", author=" + author + "]";
	}
}
