package com.sai.hibernate.demo.annotationConfigEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Asset
{
	@Column(name = "ASSET_NAME")
	private String assetName;
	
	@Column(name = "ASSET_VALUE")
	private Double assetValue;
	
	public String getAssetName()
	{
		return assetName;
	}
	
	public void setAssetName(String assetName)
	{
		this.assetName = assetName;
	}
	
	public Double getAssetValue()
	{
		return assetValue;
	}
	
	public void setAssetValue(Double assetValue)
	{
		this.assetValue = assetValue;
	}
	
	@Override
	public String toString()
	{
		return this.assetName+"-"+this.assetValue;
	}
}
