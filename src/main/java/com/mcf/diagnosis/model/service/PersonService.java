package com.mcf.diagnosis.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcf.diagnosis.model.entity.Person;
import com.mcf.diagnosis.model.exception.PersonNotFoundException;
import com.mcf.diagnosis.model.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired private PersonRepository personRepository;

	@Transactional
	public Person salvar(Person person) {
		return personRepository.save(person);
	}

	public Person obterPorId(Long id) {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}
}
