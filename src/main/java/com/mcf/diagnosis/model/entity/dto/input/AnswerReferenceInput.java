package com.mcf.diagnosis.model.entity.dto.input;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerReferenceInput {
	
	@Valid
	@NotNull
	private List<ItemReferenceInput> respostas;
}
