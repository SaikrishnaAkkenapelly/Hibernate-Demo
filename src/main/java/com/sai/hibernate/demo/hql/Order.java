package com.sai.hibernate.demo.hql;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sai.hibernate.demo.caching.Book;

@Entity
@Table(name = "E_ORDER")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Order
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ORDER_ID")
	private Long orderId;
	@OneToMany
	private List<Book> books;
	@Column(name = "ORDER_SUM")
	private Double orderSum;
	@Column(name = "ORDER_DATE")
	private LocalDateTime orderDateTime;

	public Long getOrderId()
	{
		return orderId;
	}
	
	public void setOrderId(Long orderId)
	{
		this.orderId = orderId;
	}
	
	public List<Book> getBooks()
	{
		return books;
	}
	
	public void setBooks(List<Book> books)
	{
		this.books = books;
	}
	
	public Double getOrderSum()
	{
		return orderSum;
	}
	
	public void setOrderSum(Double sum)
	{
		this.orderSum = sum;
	}
	
	public LocalDateTime getOrderDateTime()
	{
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime)
	{
		this.orderDateTime = orderDateTime;
	}

	@Override
	public String toString()
	{
		return "Order [orderId=" + orderId + ", orderSum=" + orderSum + ", orderDateTime=" + orderDateTime + "]";
	}
}
