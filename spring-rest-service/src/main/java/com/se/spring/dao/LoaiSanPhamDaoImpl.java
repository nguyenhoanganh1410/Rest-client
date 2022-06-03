package com.se.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.model.LoaiSanPham;
import com.se.spring.model.SanPham;


@Repository
public class LoaiSanPhamDaoImpl implements LoaiSanPhamDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public LoaiSanPham getLoaiById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		return session.find(LoaiSanPham.class, id);
		
	}

	@Override
	@Transactional
	public List<LoaiSanPham> getListLoaiSP() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.query.Query<LoaiSanPham> list = session.createQuery("from LoaiSanPham", LoaiSanPham.class);
		
		List<LoaiSanPham> students = list.getResultList();
		return students;
	}

}
