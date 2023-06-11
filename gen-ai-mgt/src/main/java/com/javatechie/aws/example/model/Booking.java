package com.javatechie.aws.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {	
	
	@Id
	private Integer bookingNum;
	private String location;
	private String rider;
	private String provider;
	private String status;
	public Integer getBookingNum() {
		return bookingNum;
	}
	public void setBookingNum(Integer bookingNum) {
		this.bookingNum = bookingNum;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRider() {
		return rider;
	}
	public void setRider(String rider) {
		this.rider = rider;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Booking [bookingNum=" + bookingNum + ", location=" + location + ", rider=" + rider + ", provider="
				+ provider + ", status=" + status + "]";
	}
	
	
	
	}
