package com.se.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.StudentDao;
import com.se.spring.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Override
	@Transactional
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		List<Student> list = studentDao.getStudent();
		return list;
	}

	@Override
	@Transactional
	public void saveStudent(Student s) {
		// TODO Auto-generated method stub
		studentDao.saveStudent(s);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(id);
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(id);
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		studentDao.updateStudent(s);
	}

}
