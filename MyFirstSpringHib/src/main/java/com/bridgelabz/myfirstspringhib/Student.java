package com.bridgelabz.myfirstspringhib;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Student {

	@Id
	private int aid;
	private StudentName name;
	private String address;
//	@OneToOne
//	@OneToMany(mappedBy = "student")
	@ManyToMany(mappedBy = "student")
	private List<Laptop> laptop = new ArrayList<>();

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}

	public StudentName getName() {
		return name;
	}

	public void setName(StudentName name) {
		this.name = name;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [aid=" + aid + ", name=" + name + ", address=" + address + "]";
	}

}
