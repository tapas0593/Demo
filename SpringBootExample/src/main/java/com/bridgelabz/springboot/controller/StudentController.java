package com.bridgelabz.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.springboot.model.Student;
import com.bridgelabz.springboot.model.StudentUpdate;
import com.bridgelabz.springboot.service.StudentService;

@RestController
@RequestMapping("/springboot")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {

		service.addStudent(student);
		return student;
	}

	@PostMapping("/students")
	public List<Student> addStudents(@RequestBody List<Student> students) {

		service.addStudents(students);
		return students;
	}

	@GetMapping("/student")
	public List<Student> getStudents() {
		return service.getStudents();
	}

	@GetMapping("/studentByName/{name}")
	public Student getStudentByName(@PathVariable("name") String name) {
		return service.getStudentByName(name);
	}

	@GetMapping("/studentByTech/{tech}")
	public Student getStudentByTech(@PathVariable("tech") String tech) {
		return service.getStudentByTech(tech);
	}

	@GetMapping("/studentByRollNum/{rollNum}")
	public Optional<Student> getStudent(@PathVariable("rollNum") int rollNum) {
		return service.getStudent(rollNum);
	}

	@DeleteMapping("/student/{rollNum}")
	public String deleteStudent(@PathVariable("rollNum") int rollNum) {
		return service.deleteStudent(rollNum);
	}

	@PutMapping("/student/{rollNum}")
	public StudentUpdate saveOrUpdateStudents(@RequestBody StudentUpdate student,
			@PathVariable("rollNum") int rollNum) {
		return service.saveOrUpdateStudent(student, rollNum);
	}
	
	@GetMapping("studentSortByName/{tech}")
	public List<Student> getSortedByName(@PathVariable String tech) {
		return service.getSortedByTech(tech);
	}
}
