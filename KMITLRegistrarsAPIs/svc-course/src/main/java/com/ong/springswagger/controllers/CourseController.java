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

import com.ong.springswagger.models.Course;
import com.ong.springswagger.repositorys.CourseRepository;


@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("/")
	public List<Course> retrieveAllCourses() {
		return courseRepository.findAll();
	}

	@GetMapping("/{id}")
	public Course retrieveCourse(@PathVariable long id) {
		Optional<Course> course = courseRepository.findById(id);
		return course.get();
	}

	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable long id) {
		courseRepository.deleteById(id);
	}

	@PostMapping("/")
	public ResponseEntity<Object> createCourse(@RequestBody Course course) {
		Course savedCourse = courseRepository.save(course);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCourse.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Course course, @PathVariable long id) {

		Optional<Course> courseOptional = courseRepository.findById(id);

		if (!courseOptional.isPresent())
			return ResponseEntity.notFound().build();

		course.setId(id);
		
		courseRepository.save(course);

		return ResponseEntity.noContent().build();
	}
}