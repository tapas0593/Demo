package com.bridgelabz.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.springboot.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	Student findByName(String string);

	Student findByTech(String tech);

	@Query("from Student where tech=?1 order by name")
	List<Student> findByTechSorted(String tech);

}
