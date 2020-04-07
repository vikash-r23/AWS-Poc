package com.aws.lambda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID" , nullable = false , unique = true)
	private long id;
	
	@Column(name = "NAME" , nullable = false , unique = false, length = 20)
	private String name;
	
	@Column(name = "DEPARTMENT" , nullable = false , unique = false, length = 20)
	private String department;
	
	@Column(name = "SALARY" , nullable = true , unique = false, length = 10)
	private double salary;
	
	@Column(name = "ADDRESS" , nullable = true , unique = false, length = 50)
	private String address;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
