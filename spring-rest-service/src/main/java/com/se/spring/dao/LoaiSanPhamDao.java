package com.se.spring.dao;

import java.util.List;

import com.se.spring.model.LoaiSanPham;

public interface LoaiSanPhamDao {
	public LoaiSanPham getLoaiById(int id);
	public List<LoaiSanPham> getListLoaiSP();
}
