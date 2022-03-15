package com.mcf.diagnosis.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcf.diagnosis.model.entity.Answers;
import com.mcf.diagnosis.model.repository.AnswersRepository;

@Service
public class AnswersService {

	@Autowired
	private AnswersRepository repository;

	@Transactional
	public Answers salvar(Answers answers) {
	
		return repository.save(answers);
	}
}
