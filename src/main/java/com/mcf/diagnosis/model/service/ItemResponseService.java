package com.mcf.diagnosis.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcf.diagnosis.model.entity.ItemResponse;
import com.mcf.diagnosis.model.repository.ItemResponseRepository;

@Service
public class ItemResponseService {

	@Autowired
	private ItemResponseRepository itemResponseRepository;

	@Transactional
	public ItemResponse salvar(ItemResponse itemResponse) {
		return itemResponseRepository.save(itemResponse);
	}
}
