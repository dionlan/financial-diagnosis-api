package com.mcf.diagnosis.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * Tabela fixa, estática, não será alterada, apenas para vincular o id com a descrição e a nota
 * @author dius_
 *
 */
@Data
@Entity(name = "items_question")
public class Item {
	
	@Id
	private Long id;
	
	private String description; 
	
	@Column(name = "note_item")
	private BigDecimal noteItem; 
	
	/*
	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_question")
	private Question question; */

}
