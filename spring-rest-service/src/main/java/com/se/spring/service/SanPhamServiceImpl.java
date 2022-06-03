package com.se.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.SanPhamDao;
import com.se.spring.model.SanPham;


@Service
public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	private SanPhamDao spDao;
	@Override
	public void deleteSP(int id) {
		// TODO Auto-generated method stub
		spDao.deleteSP(id);
	}

	@Override
	public void update(SanPham sp) {
		// TODO Auto-generated method stub
		spDao.update(sp);
	}

	@Override
	public  List<SanPham> getListByLoai(int maLoai) {
		// TODO Auto-generated method stub
		return spDao.getListByLoai(maLoai);
	}

	@Override
	public List<SanPham> getList() {
		// TODO Auto-generated method stub
		return spDao.getList();
	}

	@Override
	public SanPham getSPById(int id) {
		// TODO Auto-generated method stub
		return spDao.getSPById(id);
	}

	@Override
	public void save(SanPham sp) {
		// TODO Auto-generated method stub
		 spDao.save(sp);
	}

}
