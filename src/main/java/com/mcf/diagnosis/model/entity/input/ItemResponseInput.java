package com.mcf.diagnosis.model.entity.input;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemResponseInput {
	
	private Long itemResponse;
	
	private List<ItemResponsesInput> itemResponses;
}
