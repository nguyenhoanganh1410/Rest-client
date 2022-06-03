package com.se.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.spring.model.LoaiSanPham;
import com.se.spring.service.LoaiSanPhamService;

@Controller
@RequestMapping("/loaisanpham")
public class LoaiSanPhamController {

	@Autowired
	private LoaiSanPhamService lspService;
	
	@RequestMapping("/list")
	public String showList(Model model) {
		//lay ds LoaiSanPham
		List<LoaiSanPham> list = lspService.getListLoaiSP();
		
		//add model
		model.addAttribute("dsloaisanpham", list);
		
		return "loai-san-pham";
	}
}
