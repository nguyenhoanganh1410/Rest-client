package com.se.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.spring.model.LoaiSanPham;
import com.se.spring.model.SanPham;
import com.se.spring.service.LoaiSanPhamService;
import com.se.spring.service.SanPhamService;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {

	@Autowired
	private SanPhamService spService;
	
	@RequestMapping("/list")
	public String showList(Model model, HttpServletRequest req) {
		//lay id tren url
		String id = req.getParameter("ma-loai");
		
		
		//lay ds LoaiSanPham theo ma loai
		List<SanPham> list = spService.getListByLoai(Integer.parseInt(id));
		
		//add model
		model.addAttribute("dsSanPham", list);
		
		return "san-pham";
	}
}
