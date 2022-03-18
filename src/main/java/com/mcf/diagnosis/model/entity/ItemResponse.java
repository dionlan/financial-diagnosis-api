package com.mcf.diagnosis.model.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class ItemResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "response_id")
	private Response response;
	
	private Long itemResponse;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "objetivo")
	private List<ItemResponses> itemResponses;

	public void setItemResponses(List<ItemResponses> itemResponses) {
		if(itemResponses != null) {
			this.itemResponses = itemResponses;
	    	this.itemResponses
	    		.stream()
	    		.forEach(item -> item.setObjetivo(this));
		}
	}
}
