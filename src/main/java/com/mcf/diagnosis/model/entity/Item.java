package com.mcf.diagnosis.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	private Long codigoResposta;
	
}
