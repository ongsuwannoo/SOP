package com.ong.springswagger.controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ong.springswagger.models.Student;
import com.ong.springswagger.repositorys.StudentRepository;


@RestController
@RequestMapping(value = "/student")
public class AuthenController {

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("register/")
	public ResponseEntity<Object> registerStudent(@RequestBody Student student) {
		Student savedStudent = studentRepository.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PostMapping("login/")
	public String loginStudent(@RequestBody Student student_) {

		Optional<Student> student = studentRepository.findByUsername(student_.getUsername());
		
		if (!student.isPresent())
			return ("Username is invalid");
		
		return ("fake-token ".concat(student.get().getUsername()));
		
	}
	
}