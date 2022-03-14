package com.mcf.diagnosis.model.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description; 
	
	@Column(name = "note_item")
	private BigDecimal noteItem; 
	/*
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Answer codigo;*/

	private Long codigo;
	/*
	public void setResposta(Answer resposta) {
		this.resposta = resposta;
		resposta.setId(getCodigo());
	}*/

	/*
	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question; */

}
