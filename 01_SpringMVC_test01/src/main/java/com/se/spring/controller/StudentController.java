package com.se.spring.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.spring.model.Student;
import com.se.spring.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String showHome(Model model) {
		List<Student> list = studentService.getStudent();
		System.out.println(list);
		//add into model
		model.addAttribute("students",list);
		return "list-student";
	}
	
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student c = new Student();
		System.out.println(c);
		model.addAttribute("student", c);
		return "add-student";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(HttpServletRequest req ,Model model) {
		//lay ra id tren param
		String id = req.getParameter("studentId");
		System.out.println(id);
		//delete in DB
		studentService.deleteStudent(Integer.parseInt(id));
		return "redirect:/student/list";
	}
	
	
	
	
	
	@RequestMapping("/save-student")
	public String saveStudent(@Valid @ModelAttribute Student student, BindingResult theBindingResult) {
		System.out.println(theBindingResult.hasErrors());
		if(theBindingResult.hasErrors()) {
			return "add-student";
		}
		
			studentService.saveStudent(student);
			
			return "redirect:/student/list"; 
		
	}
	
	@RequestMapping("/form-update")
	public String updateStudent(HttpServletRequest req ,Model model) {
		//lay ra id tren param
		String id = req.getParameter("studentId");
		System.out.println(id);
		//Lay ra student theo ID
		Student s = studentService.getStudentById(Integer.parseInt(id));
		System.out.println(s);
		//truyen student vao Model
		model.addAttribute("student", s);
		
		return "update-student";
	}
	
	@RequestMapping("/update-student")
	public String updateStudent(@Valid @ModelAttribute Student student, BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {
			return "add-student";
		}
		
			studentService.updateStudent(student);
			System.out.println(student);
			
			return "redirect:/student/list"; 
		
	}
	
	
	//luon chay dau tien
	//xoa khoang trang dau va cuoi
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		System.out.println("second");
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
}
