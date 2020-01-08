package com.exemple.personne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.personne.beans.Personne;
import com.exemple.personne.dao.PersonneRepository;

@RestController
@RequestMapping("/personnes")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonneController {
	
	@Autowired
	PersonneRepository personneRepository;
	
	@GetMapping("/all")
	public List<Personne> getAll(){
		return personneRepository.findAll();
	}
	
	@PostMapping("/add")
	public void addPersonne(@RequestBody Personne per) {
		 personneRepository.save(per);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		personneRepository.deleteById(id);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody Personne per) {
		personneRepository.delete(per);
	}
	
	@GetMapping("/{id}")
	public Personne findById(@PathVariable Long id) {
		return personneRepository.findById(id).get();
	}

}
