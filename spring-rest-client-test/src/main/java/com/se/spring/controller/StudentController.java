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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.spring.model.Student;
import com.se.spring.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String getList(Model model) {
		List<Student> list = studentService.getStudent();
		System.out.println(list);
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
	
	@RequestMapping("/save-student")
	public String saveStudent(@Valid @ModelAttribute Student student, BindingResult theBindingResult) {
		System.out.println(theBindingResult.hasErrors());
		if(theBindingResult.hasErrors()) {
			return "add-student";
		}
		
			studentService.saveStudent(student);
			
			return "redirect:/students/list"; 
		
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(HttpServletRequest req) {
		//get param id
		String id = req.getParameter("studentId");
		
		//delete 
		studentService.deleteStudent(Integer.parseInt(id));
		return "redirect:/students/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(HttpServletRequest req, Model model) {
		//get id
		String id = req.getParameter("studentId");
		//find Student byID
		Student s = studentService.getStudentById(Integer.parseInt(id));
		
		//add in model
		model.addAttribute("student", s);
		
		return "update-student";
		
	}
	
	@RequestMapping("/update")
	public String update(@Valid @ModelAttribute Student student, BindingResult theBindingResult) {
		System.out.println(theBindingResult.hasErrors());
		if(theBindingResult.hasErrors()) {
			return "add-student";
		}
		
			//studentService.updateStudent(student);
			System.out.println(student);
			return "redirect:/students/list"; 
		
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
