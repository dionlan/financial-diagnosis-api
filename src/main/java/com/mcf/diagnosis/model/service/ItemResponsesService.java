package com.mcf.diagnosis.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcf.diagnosis.model.entity.ItemResponses;
import com.mcf.diagnosis.model.repository.ItemResponsesRepository;

@Service
public class ItemResponsesService {

	@Autowired
	private ItemResponsesRepository itemResponsesRepository;

	@Transactional
	public ItemResponses salvar(ItemResponses itemResponses) {
		return itemResponsesRepository.save(itemResponses);
	}
}
