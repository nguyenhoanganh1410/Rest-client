package com.se.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.model.SanPham;
import com.se.spring.service.SanPhamService;

@RestController
@RequestMapping("/api")
public class SanPhamController {

	@Autowired
	private SanPhamService spService;
	
	@RequestMapping("/sanpham/loaisp/{id}")
	public List<SanPham> getSPTheoLoai(@PathVariable int id){
		return spService.getListByLoai(id);
	}
	
	@RequestMapping("/sanpham")
	public List<SanPham> getListSanPham(){
		System.out.println("sanPham");
		List<SanPham> list = spService.getList();
		System.out.println(list);
		return list;
	}
	@RequestMapping("/sanpham/{id}")
	public SanPham getStudentByID(@PathVariable int id) {
		SanPham s = spService.getSPById(id);
		if (s == null) {
			throw new StudentNotFoundException("Product id not found " + id);
		}
		
		return s;
		
		
	}
	
	@PostMapping("/sanpham")
	public SanPham addStudent(@RequestBody SanPham s) {
		s.setId(0);
		spService.save(s);
		return s;
	}
	
	@DeleteMapping("/sanpham/{id}")
	public String deleteStudent(@PathVariable int id) {
		
		SanPham customer = spService.getSPById(id);
		if (customer == null) {
			throw new StudentNotFoundException("Product id not found " + id);
		}
		spService.deleteSP(id);
		return "delete : "+id+" ";
	}
	
	@PutMapping("/sanpham")
	public SanPham update(@RequestBody SanPham s) {
		spService.update(s);
		return s;
	}
}
