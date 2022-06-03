package com.se.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.StudentDao;
import com.se.spring.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	@Override
	@Transactional
	public List<Student> getList() {
		// TODO Auto-generated method stub
		return studentDao.getList();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		
		return studentDao.getStudentById(id);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(id);
	}

	@Override
	@Transactional
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		studentDao.updateStudent(s);
	}

	@Override
	@Transactional
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		studentDao.addStudent(s);
	}

}
