package com.danish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.danish.dao.RegistrationDaoService;
import com.danish.model.Student;


@RestController
@CrossOrigin(origins="*")
public class StudentController {

	@Autowired
	RegistrationDaoService dao;
	
	@GetMapping("getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		
		List<Student> students = dao.getAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@PostMapping("addStudent")
	public ResponseEntity<List<Student>> addStudent(@RequestBody Student student){
		
		System.out.println(student.getJoiningDate());
		 dao.saveStudent(student);
		 return getAllStudents();
	}
	
	@DeleteMapping("deleteStudent/{id}")
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable long id){
		
		dao.deleteStudent(id);
		return getAllStudents();
	}
}
