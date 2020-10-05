package com.ong.springswagger.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ong.springswagger.models.Student;
import com.ong.springswagger.repositorys.StudentRepository;


@RestController
@RequestMapping(value = "/student")
public class StudentController2 {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/")
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("/{id}")
	public Student retrieveStudent(@PathVariable long id) {
		Optional<Student> student = studentRepository.findById(id);
		return student.get();
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentRepository.deleteById(id);
	}

//	@PostMapping("/")
//	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
//		Student savedStudent = studentRepository.save(student);
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedStudent.getId()).toUri();
//
//		return ResponseEntity.created(location).build();
//
//	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {
//
//		Optional<Student> studentOptional = studentRepository.findById(id);
//
//		if (!studentOptional.isPresent())
//			return ResponseEntity.notFound().build();
//
//		student.setId(id);
//		
//		studentRepository.save(student);
//
//		return ResponseEntity.noContent().build();
//	}
}