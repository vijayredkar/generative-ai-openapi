package com.javatechie.aws.example.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
public class Provider {	
	
	@Id
	private Integer providerNum;	
	private String location;
	private String name;
	private Integer maxCapacity;
	private Integer reservedCapacity;
	private Integer availableCapacity;
	private String txnRemarks="";
	
	public Integer getProviderNum() {
		return providerNum;
	}
	public void setProviderNum(Integer providerNum) {
		this.providerNum = providerNum;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public Integer getReservedCapacity() {
		return reservedCapacity;
	}
	public void setReservedCapacity(Integer reservedCapacity) {
		this.reservedCapacity = reservedCapacity;
	}
	public Integer getAvailableCapacity() {
		return availableCapacity;
	}
	public void setAvailableCapacity(Integer availableCapacity) {
		this.availableCapacity = availableCapacity;
	}
	public String getTxnRemarks() {
		return txnRemarks;
	}
	public void setTxnRemarks(String txnRemarks) {
		this.txnRemarks = txnRemarks;
	}
	
	@Override
	public String toString() {
		return "Provider [providerNum=" + providerNum + ", location=" + location + ", name=" + name + ", maxCapacity="
				+ maxCapacity + ", reservedCapacity=" + reservedCapacity + ", availableCapacity=" + availableCapacity
				+ ", txnRemarks=" + txnRemarks + "]";
	}
	
	
	
			
}
