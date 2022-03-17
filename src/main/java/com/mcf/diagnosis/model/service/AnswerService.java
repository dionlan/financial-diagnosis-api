package com.mcf.diagnosis.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcf.diagnosis.model.entity.Answer;
import com.mcf.diagnosis.model.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository repository;

	@Transactional
	public Answer salvar(Answer answer) {
	
		return repository.save(answer);
	}
}
