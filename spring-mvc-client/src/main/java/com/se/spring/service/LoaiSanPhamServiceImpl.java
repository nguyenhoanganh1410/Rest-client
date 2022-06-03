package com.se.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.spring.model.LoaiSanPham;
import com.se.spring.model.SanPham;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService{
	private RestTemplate restTemplate;
	private String srmRestUrl;
	
	@Autowired
	public LoaiSanPhamServiceImpl(RestTemplate restTemplate,@Value("${crm.rest.url}") String srmRestUrl) {
		
		this.restTemplate = restTemplate;
		this.srmRestUrl = srmRestUrl;
	}

	@Override
	public LoaiSanPham getLoaiById(int id) {
		// TODO Auto-generated method stub
		 return restTemplate.getForObject(srmRestUrl+"/"+id, LoaiSanPham.class);
	}

	@Override
	public List<LoaiSanPham> getListLoaiSP() {
		
		ResponseEntity<List<LoaiSanPham>> response =
				restTemplate.exchange(srmRestUrl,HttpMethod.GET,null,new ParameterizedTypeReference<List<LoaiSanPham>>() {
				});
		List<LoaiSanPham>list =response.getBody();
		return list;
	}
	
}
