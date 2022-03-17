package com.mcf.diagnosis.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcf.diagnosis.model.entity.Response;
import com.mcf.diagnosis.model.repository.ResponseRepository;

@Service
public class ResponseService {

	@Autowired
	private ResponseRepository repository;

	@Transactional
	public Response salvar(Response response) {
	
		return repository.save(response);
	}
}
