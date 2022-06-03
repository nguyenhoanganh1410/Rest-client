package com.se.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.LoaiSanPhamDao;
import com.se.spring.model.LoaiSanPham;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService{
	@Autowired
	private LoaiSanPhamDao loaiSPDao;
	@Override
	@Transactional
	public LoaiSanPham getLoaiById(int id) {
		// TODO Auto-generated method stub
		return loaiSPDao.getLoaiById(id);
	}

	@Override
	@Transactional
	public List<LoaiSanPham> getListLoaiSP() {
		// TODO Auto-generated method stub
		return loaiSPDao.getListLoaiSP();
	}

}
