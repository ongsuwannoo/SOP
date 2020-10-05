package com.ong.springswagger.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ong.springswagger.models.Student;
import com.ong.springswagger.repositorys.StudentRepository;


@RestController
@RequestMapping(value = "/Evaluation")
public class Evaluation {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/")
	public List<Student> General_assessment_results() {
		return studentRepository.findAll();
	}

	@GetMapping("/{id}")
	public Student evaluation_results(@PathVariable long id) {
		Optional<Student> student = studentRepository.findById(id);
		return student.get();
	}


	@PostMapping("/")
	public ResponseEntity<Object> General_assessment(@RequestBody Student student) {
		Student savedStudent = studentRepository.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

}