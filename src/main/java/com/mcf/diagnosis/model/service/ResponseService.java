package com.mcf.diagnosis.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcf.diagnosis.model.entity.ItemResponse;
import com.mcf.diagnosis.model.entity.ItemResponses;
import com.mcf.diagnosis.model.entity.Response;
import com.mcf.diagnosis.model.repository.ItemResponseRepository;
import com.mcf.diagnosis.model.repository.ItemResponsesRepository;
import com.mcf.diagnosis.model.repository.PersonRepository;
import com.mcf.diagnosis.model.repository.ResponseRepository;

@Service
public class ResponseService {

	@Autowired private ResponseRepository responseRepository;
	@Autowired private PersonRepository personRepository;
	@Autowired private ItemResponseRepository itemResponseRepository;
	@Autowired private ItemResponsesRepository itemResponsesRepository;
	

	@Transactional
	public Response salvar(Response response) {
		List<ItemResponse> objetivosFinanceiros = new ArrayList<>();
		personRepository.save(response.getPerson());
		//itemResponseRepository.saveAll(response.getPerson().getResponses());
		//objetivosFinanceiros.addAll(response.getPerson().getResponses());
		
		itemResponseRepository.saveAll(objetivosFinanceiros);
		//		.getResponses().forEach(c -> c.setItemResponses(objetivosFinanceiros)));
		
		//itemResponseRepository.saveAll(response.getPerson());

		return responseRepository.save(response);
	}
}
