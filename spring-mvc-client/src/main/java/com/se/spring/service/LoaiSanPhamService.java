package com.se.spring.service;

import java.util.List;

import com.se.spring.model.LoaiSanPham;

public interface LoaiSanPhamService {
	public LoaiSanPham getLoaiById(int id);
	public List<LoaiSanPham> getListLoaiSP();
}
