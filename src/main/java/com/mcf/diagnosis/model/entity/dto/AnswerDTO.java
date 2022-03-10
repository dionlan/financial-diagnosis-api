package com.mcf.diagnosis.model.entity.dto;

import java.util.ArrayList;
import java.util.List;

import com.mcf.diagnosis.model.entity.Item;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerDTO {

	private Long id;
	
	private List<Item> respostas = new ArrayList<>();
}
