package com.bridgelabz.HQLDemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "HQL_Student")
public class Student {

	@Id
	private int rollNum;
	private String name;
	private int marks;

}
