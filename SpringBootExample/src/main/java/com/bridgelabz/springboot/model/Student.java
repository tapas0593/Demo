package com.bridgelabz.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rollNum;
	private String name;
	private String tech;

	public Student() {
	}

	public Student(StudentUpdate studentUpdate) {
		this.name = studentUpdate.getName();
	}
}
