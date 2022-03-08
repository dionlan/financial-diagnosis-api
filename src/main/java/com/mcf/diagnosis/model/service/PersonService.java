package com.mcf.diagnosis.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcf.diagnosis.model.entity.Person;
import com.mcf.diagnosis.model.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Transactional
	public Person save(Person person) {
		return personRepository.save(person);
	}
}
