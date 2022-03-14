package com.mcf.diagnosis.model.entity.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerDTO {

	private Set<ItemDTO> respostas = new HashSet<>();
}
