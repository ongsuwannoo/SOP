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

import com.ong.springswagger.models.Lecturer;
import com.ong.springswagger.repositorys.LecturerRepository;


@RestController
@RequestMapping(value = "/lecturers")
public class CourseManagementController {

	@Autowired
	private LecturerRepository lecturerRepository;

	@GetMapping("/")
	public List<Lecturer> retrieveAllCourses() {
		return lecturerRepository.findAll();
	}

	@GetMapping("/{id}")
	public Lecturer retrieveCourse(@PathVariable long id) {
		Optional<Lecturer> lecturer = lecturerRepository.findById(id);
		return lecturer.get();
	}

	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable long id) {
		lecturerRepository.deleteById(id);
	}

	@PostMapping("/")
	public ResponseEntity<Object> createCourse(@RequestBody Lecturer lecturer) {
		Lecturer savedCourse = lecturerRepository.save(lecturer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCourse.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCourse(@RequestBody Lecturer lecturer, @PathVariable long id) {

		Optional<Lecturer> lecturerOptional = lecturerRepository.findById(id);

		if (!lecturerOptional.isPresent())
			return ResponseEntity.notFound().build();

		lecturer.setId(id);
		
		lecturerRepository.save(lecturer);

		return ResponseEntity.noContent().build();
	}
}