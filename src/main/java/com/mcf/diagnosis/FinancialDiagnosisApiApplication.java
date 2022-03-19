package com.mcf.diagnosis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mcf.diagnosis.model.entity.ItemResponse;
import com.mcf.diagnosis.model.entity.ItemResponses;
import com.mcf.diagnosis.model.entity.Person;
import com.mcf.diagnosis.model.repository.ItemResponseRepository;
import com.mcf.diagnosis.model.repository.ItemResponsesRepository;
import com.mcf.diagnosis.model.repository.PersonRepository;

@SpringBootApplication
public class FinancialDiagnosisApiApplication implements CommandLineRunner{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ItemResponseRepository itemResponseRepository;
	
	@Autowired
	private ItemResponsesRepository itemResponsesRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinancialDiagnosisApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		List<ItemResponse> itemResponseList = new ArrayList<>();
		List<ItemResponses> itemResponsesList = new ArrayList<>();
		
		Person p = Person.builder().name("dionlan alves de jesus").email("dionlan.alves@gmail.com").build();
		ItemResponse ir1 = ItemResponse.builder().person(p).itemResponse(3L).build();
		ItemResponse ir2 = ItemResponse.builder().person(p).itemResponse(2L).build();
		ItemResponse ir3 = ItemResponse.builder().person(p).itemResponse(1L).build();
		ItemResponse ir4 = ItemResponse.builder().person(p).itemResponse(2L).build();
		ItemResponse ir5 = ItemResponse.builder().person(p).itemResponse(3L).build();
		ItemResponse ir6 = ItemResponse.builder().person(p).build();
		itemResponseList.addAll(Arrays.asList(ir1, ir2, ir3, ir4, ir5, ir6));
		
		ItemResponses irs1 = ItemResponses.builder().itemResponse(ir6).itemObjetivo("7").build();
		ItemResponses irs2 = ItemResponses.builder().itemResponse(ir6).itemObjetivo("12").build();
		ItemResponses irs3 = ItemResponses.builder().itemResponse(ir6).itemObjetivo("3").build();
		ItemResponses irs4 = ItemResponses.builder().itemResponse(ir6).itemObjetivo("Outros Objetivos Imediatos").build();
		itemResponsesList.addAll(Arrays.asList(irs1, irs2, irs3, irs4));
		
		personRepository.save(p);
		itemResponseRepository.saveAll(itemResponseList);
		itemResponsesRepository.saveAll(itemResponsesList);
		*/
	}
}
