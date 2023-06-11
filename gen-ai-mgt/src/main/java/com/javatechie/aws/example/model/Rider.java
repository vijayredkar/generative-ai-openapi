package com.javatechie.aws.example.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rider")
public class Rider {	
	
	@Id
	private Integer riderNum;	
	private String location;
	private String name;
	private String status;
	
	public Integer getRiderNum() {
		return riderNum;
	}
	public void setRiderNum(Integer riderNum) {
		this.riderNum = riderNum;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Rider [riderNum=" + riderNum + ", location=" + location + ", name=" + name + ", status=" + status + "]";
	}
}
