package com.se.spring.service;

import java.util.List;

import com.se.spring.model.Student;

public interface StudentService {
	public List<Student> getList();
	public Student getStudentById(int id);
	public void deleteStudent(int id);
	public void updateStudent(Student s);
	public void addStudent(Student s);
}
