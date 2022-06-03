package com.se.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.se.spring.model.Student;
import com.se.spring.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/students")
	public List<Student> getList() {
		return studentService.getList();
	}
	
	@RequestMapping("/students/{id}")
	public Student getStudentByID(@PathVariable int id) {
		Student s = studentService.getStudentById(id);
		if (s == null) {
			throw new StudentNotFoundException("student id not found " + id);
		}
		
		return s;
		
		
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student s) {
		s.setId(0);
		studentService.addStudent(s);
		return s;
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		
		Student customer = studentService.getStudentById(id);
		if (customer == null) {
			throw new StudentNotFoundException("Student id not found " + id);
		}
		studentService.deleteStudent(id);
		return "delete : "+id+" ";
	}
	
	@PutMapping("/students")
	public Student update(@RequestBody Student s) {
		studentService.updateStudent(s);
		return s;
	}
}
