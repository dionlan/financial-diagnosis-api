package com.mcf.diagnosis.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Tabela fixa, estática, não será alterada, apenas para vincular o id com a descrição e a nota
 * @author dius_
 *
 */
@Data
@Entity
public class Item {
	
	@Id
	private Long id;
	
	private String description; 
	
	@Column(name = "note_item")
	private BigDecimal noteItem; 
	
	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_answer")
	private Answer answer;
	
	/*
	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_question")
	private Question question; */

}
