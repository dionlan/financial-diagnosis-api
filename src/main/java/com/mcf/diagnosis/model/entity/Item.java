package com.mcf.diagnosis.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Tabela fixa, estática, não será alterada, apenas para vincular o id com a descrição e a nota
 * @author dius_
 *
 */
@Setter
@Getter
@Entity
public class Item {
	
	@Id
	private Long id;
	
	private String description; 
	
	@Column(name = "note_item")
	private BigDecimal noteItem; 
	
	@ManyToOne
	private Answer answer;
	
	/*
	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question; */

}
