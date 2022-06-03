package com.se.spring.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Student> getList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.query.Query<Student> list = session.createQuery("from Student", Student.class);
		
		List<Student> students = list.getResultList();
		return students;
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		return session.find(Student.class, id);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(getStudentById(id));
	}

	@Override
	@Transactional
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(s);
		
	}

	@Override
	@Transactional
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(s);
	}

}
