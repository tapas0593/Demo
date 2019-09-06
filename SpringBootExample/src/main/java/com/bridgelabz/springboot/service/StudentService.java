package com.bridgelabz.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.springboot.dao.StudentRepo;
import com.bridgelabz.springboot.model.Student;
import com.bridgelabz.springboot.model.StudentUpdate;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;

	public Student addStudent(Student student) {
		repo.save(student);
		return student;
	}

	public List<Student> addStudents(List<Student> students) {
		repo.saveAll(students);
		return students;
	}

	public List<Student> getStudents() {
		return repo.findAll();
	}

	public Student getStudentByName(String name) {
		return repo.findByName(name);
	}

	public Student getStudentByTech(String tech) {

		return repo.findByTech(tech);
	}
	public Optional<Student> getStudent(int rollNum) {
		return repo.findById(rollNum);
	}

	public String deleteStudent(int rollNum) {
		repo.deleteById(rollNum);
		return rollNum + " deleted";
	}

	public StudentUpdate saveOrUpdateStudent(StudentUpdate student, int rollNum) {
		List<Student> students = repo.findAll();
		students.forEach(user -> {
			if (user.getRollNum() == rollNum) {
				user.setName(student.getName());
				repo.save(user);
			}
		});
		return student;
	}

	public List<Student> getSortedByTech(String tech) {
		return repo.findByTechSorted(tech);
	}

	
}
