package com.se.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.se.spring.model.Student;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class StudentServiceImpl implements StudentService{
	private RestTemplate restTemplate;
	private String srmRestUrl;
	
	@Autowired
	public StudentServiceImpl(RestTemplate restTemplate,@Value("${crm.rest.url}") String srmRestUrl) {
		
		this.restTemplate = restTemplate;
		this.srmRestUrl = srmRestUrl;
	}

	@Override
	public List<Student> getStudent() {
		ResponseEntity<List<Student>> response =
				restTemplate.exchange(srmRestUrl,HttpMethod.GET,null,new ParameterizedTypeReference<List<Student>>() {
				});
		List<Student>list =response.getBody();
		return list;
	}

	@Override
	public void saveStudent(Student s) {
		// TODO Auto-generated method stub
		restTemplate.postForEntity(srmRestUrl, s, String.class);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		restTemplate.delete(srmRestUrl+ "/"+id);
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(srmRestUrl+"/"+id, Student.class);
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		restTemplate.put(srmRestUrl, s);;
		
	}

}
