package com.se.spring.dao;

import java.util.List;

import com.se.spring.model.Student;

public interface StudentDao {
	public List<Student> getList();
	public Student getStudentById(int id);
	public void deleteStudent(int id);
	public void updateStudent(Student s);
	public void addStudent(Student s);
}
