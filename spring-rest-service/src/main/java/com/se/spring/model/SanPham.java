package com.se.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "SanPham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private String tenSP;
	private Double gia;
	
	@ManyToOne
	private LoaiSanPham loaiSanPham;
	
	public SanPham() {
		super();
	}
	public SanPham(String tenSP, Double gia) {
		super();
		this.tenSP = tenSP;
		this.gia = gia;
	}
	
	
	public SanPham(int id, String tenSP, Double gia, LoaiSanPham loaiSanPham) {
		super();
		this.id = id;
		this.tenSP = tenSP;
		this.gia = gia;
		this.loaiSanPham = loaiSanPham;
	}
	
	public SanPham(int id, String tenSP, Double gia) {
		super();
		this.id = id;
		this.tenSP = tenSP;
		this.gia = gia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public Double getGia() {
		return gia;
	}
	public void setGia(Double gia) {
		this.gia = gia;
	}
	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}
	
	
}
