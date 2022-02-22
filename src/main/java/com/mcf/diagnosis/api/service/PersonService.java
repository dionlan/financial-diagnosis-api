package com.mcf.diagnosis.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcf.diagnosis.api.entity.Person;
import com.mcf.diagnosis.api.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Transactional
	public Person save(Person person) {
		return personRepository.save(person);
	}
}
