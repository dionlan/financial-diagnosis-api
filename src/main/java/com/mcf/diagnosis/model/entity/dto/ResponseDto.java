package com.mcf.diagnosis.model.entity.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mcf.diagnosis.model.enums.Classification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDto {

	private Long id;

	private PersonDto person; 
	
	private List<ItemResponseDto> responses = new ArrayList<>();
	/*
	public void setAnswers(List<ItemResponseDto> response) {
		this.response = response;
    	this.response
    		.stream()
    		.forEach(item -> item.setItem(this));
	}*/

	private BigDecimal notaFinal;
	
	private Classification classificacao;


}