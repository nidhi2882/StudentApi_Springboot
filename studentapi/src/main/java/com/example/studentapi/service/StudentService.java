package com.example.studentapi.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.example.studentapi.entity.Student;
import com.example.studentapi.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	public Student saveStudent(Student s)
	{
		return repo.save(s);
	}
	
	public List<Student> getAllStudents()
	{
		return repo.findAll();
	}
	public void deleteStudent(int id)
	{
		repo.deleteById(id);
	}
}
