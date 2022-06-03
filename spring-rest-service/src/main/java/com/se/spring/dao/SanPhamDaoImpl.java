package com.se.spring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.model.LoaiSanPham;
import com.se.spring.model.SanPham;

@Repository
public class SanPhamDaoImpl implements SanPhamDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private LoaiSanPhamDao loaiSpDao;
	
	@Override
	@Transactional
	public void deleteSP(int id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		SanPham sanpham = getSPById(id);
		session.delete(sanpham);
	}

	@Override
	@Transactional
	public void update(SanPham sp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(sp);
	}

	@Override
	@Transactional
	public List<SanPham> getListByLoai(int maLoai) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSP = new ArrayList<SanPham>();
		List<?> list = session.createNativeQuery("select * from SanPham where loaiSanPham_id =	"+maLoai+"").getResultList();
		for (Object object : list) {
			Object[] o = (Object[]) object;
			SanPham sanPham = new SanPham(Integer.parseInt(o[0].toString()), o[2].toString(), Double.parseDouble(o[1].toString()) );
			LoaiSanPham lsp = loaiSpDao.getLoaiById(Integer.parseInt(o[3].toString()));
			sanPham.setLoaiSanPham(lsp);
			listSP.add(sanPham);
		}
		return listSP;
		
	
	}

	@Override
	@Transactional
	public List<SanPham> getList() {
				// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				org.hibernate.query.Query<SanPham> list = session.createQuery("from SanPham", SanPham.class);
				
				List<SanPham> students = list.getResultList();
				return students;
	}

	@Override
	@Transactional
	public SanPham getSPById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.find(SanPham.class, id);
	}

	@Override
	@Transactional
	public void save(SanPham sp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(sp);
	}

}
