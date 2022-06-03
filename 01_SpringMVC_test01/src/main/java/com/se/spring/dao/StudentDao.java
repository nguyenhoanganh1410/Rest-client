package com.se.spring.dao;

import java.util.List;

import com.se.spring.model.Student;

public interface StudentDao {
	public List<Student> getStudent();
	public void saveStudent(Student s);
	public void deleteStudent(int id);
	public Student getStudentById(int id);
	public void updateStudent(Student s);
}
