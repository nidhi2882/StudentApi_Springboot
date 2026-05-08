package com.example.studentapi.controller;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.studentapi.entity.Student;
import com.example.studentapi.service.StudentService;
@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student s)
	{
		Student saved = studentservice.saveStudent(s);
		return ResponseEntity.ok(saved);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents()
	{
		List<Student> students = studentservice.getAllStudents();
		return ResponseEntity.ok(students);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable int id)
	{
		 studentservice.deleteStudent(id);
		return ResponseEntity.ok("Deleted Student with id: "+id);
	}
}
