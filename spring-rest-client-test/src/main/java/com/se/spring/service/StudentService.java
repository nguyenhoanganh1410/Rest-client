package com.se.spring.service;

import java.util.List;

import com.se.spring.model.Student;

public interface StudentService {
	public List<Student> getStudent();
	public void saveStudent(Student s);
	public void deleteStudent(int id);
	public Student getStudentById(int id);
	public void updateStudent(Student s);

}
