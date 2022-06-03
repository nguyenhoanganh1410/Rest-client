package com.se.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.dao.LoaiSanPhamDao;
import com.se.spring.model.LoaiSanPham;
import com.se.spring.model.SanPham;
import com.se.spring.service.LoaiSanPhamService;

@RestController
@RequestMapping("/api")
public class LoaiSanPhamController {

	@Autowired
	private LoaiSanPhamService loaiSpService;
	
	@RequestMapping("/LoaiSanPham")
	public List<LoaiSanPham> getList() {	
		return loaiSpService.getListLoaiSP();
	}
	@RequestMapping("/LoaiSanPham/{id}")
	public LoaiSanPham getStudentByID(@PathVariable int id) {
		LoaiSanPham s = loaiSpService.getLoaiById(id);
		if (s == null) {
			throw new StudentNotFoundException("Product id not found " + id);
		}
		
		return s;
		
		
	}
}
