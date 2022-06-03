package com.se.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.model.Student;
@Repository
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
				Session currentSession = sessionFactory.getCurrentSession();
				Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
				
				List<Student> list = theQuery.getResultList();
				
				return list;
	}

	@Override
	@Transactional
	public void saveStudent(Student s) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(s);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(getStudentById(id));
		
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student s = currentSession.get(Student.class, id);	
		return s;
	}

	@Override
	@Transactional
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println(s);
		currentSession.saveOrUpdate(s);
		
	}
	
	
}
