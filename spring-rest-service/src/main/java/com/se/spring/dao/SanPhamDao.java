package com.se.spring.dao;

import java.util.List;

import com.se.spring.model.SanPham;

public interface SanPhamDao {
	public void deleteSP(int id);
	public void update(SanPham sp);
	
	public  List<SanPham> getListByLoai(int maLoai);
	
	
	public List<SanPham> getList();
	
	public SanPham getSPById(int id);
	
	public void save(SanPham sp);
}
