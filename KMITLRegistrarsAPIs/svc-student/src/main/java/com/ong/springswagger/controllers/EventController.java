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

import com.ong.springswagger.models.Event;
import com.ong.springswagger.repositorys.EventRepository;


@RestController
@RequestMapping(value = "/event")
public class EventController {

	@Autowired
	private EventRepository eventRepository;
	
	@GetMapping("/")
	public List<Event> retrieveAllEvent() {
		return eventRepository.findAll();
	}

	@GetMapping("/{id}")
	public Event retrieveEvent(@PathVariable long id) {
		Optional<Event> event = eventRepository.findById(id);
		return event.get();
	}

	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable long id) {
		eventRepository.deleteById(id);
	}

	@PostMapping("/")
	public ResponseEntity<Object> createEvent(@RequestBody Event event) {
		Event savedEvent = eventRepository.save(event);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEvent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Event event, @PathVariable long id) {

		Optional<Event> eventOptional = eventRepository.findById(id);

		if (!eventOptional.isPresent())
			return ResponseEntity.notFound().build();

		event.setId(id);
		
		eventRepository.save(event);

		return ResponseEntity.noContent().build();
	}
}