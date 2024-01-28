
package com.example.CrudOperation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudOperation.dto.Student;
import com.example.CrudOperation.repository.StudentRepository;

@RestController
public class StudentController 
{
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/")
	public String index() {
		return "welcome";
	}
	
	//creating or inserting new data
	@PostMapping("/saveStudents")
	public Student saveStudent(@RequestBody Student student) 
	{
		return student;
	}
	
	//Fetch Single record
	@GetMapping("/getStudent/{rollNo}")
	public Student getStudentData(@PathVariable int rollNo) 
	{
		Optional<Student> student =  studentRepository.findById(rollNo);
		Student student1 = student.get();
		return student1;
	}
	
	// Fetching or reading All data
	@GetMapping("/getAll")
	public List<Student> getAll()
	{
		List<Student> studentList=studentRepository.findAll();
		return studentList;
	}
	
	//deleting the records
	@DeleteMapping("/deleteStudent")
	public String deleteStudent(@PathVariable int rollNo) 
	{
		Student student = studentRepository.findById(rollNo).get();
		if(student!=null)
		{
			studentRepository.delete(student);
		}
		return "Delete Succesfully";
	}
	
	
	//update the record
	@PutMapping("/updateData")
	public Student updateStudent(@RequestBody Student student)
	{
		studentRepository.save(student);
		return student;
	}
}
