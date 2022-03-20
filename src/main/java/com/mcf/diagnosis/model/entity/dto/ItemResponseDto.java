package com.mcf.diagnosis.model.entity.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mcf.diagnosis.model.entity.input.ItemResponsesInput;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class ItemResponseDto {
	
	private Long itemResponse;
	
	@JsonInclude(Include.NON_EMPTY)
	private List<ItemResponsesInput> itemResponses;
}