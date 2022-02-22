package com.mcf.diagnosis.api.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Item {
	
	@Id
	private Long id;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private BigDecimal noteItem;
	
	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_question")
	private Question question;

}
