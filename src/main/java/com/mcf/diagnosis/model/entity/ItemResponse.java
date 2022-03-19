package com.mcf.diagnosis.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Tabela fixa, estática, não será alterada, apenas para vincular o id com a descrição e a nota
 * @author dius_
 *
 */
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long itemResponse;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<ItemResponses> itemResponses;
	/*
	public void setItemResponses(List<ItemResponses> itemResponses) {
		if(itemResponses != null) {
			this.itemResponses = itemResponses;
	    	this.itemResponses
	    		.stream()
	    		.forEach(item -> item.setItemResponse(this));
		} else {
			return;
		}
	}*/
	
	/*
	public void setPerson(Person person) {
		this.person = person;
		person.setResponses(null);
	} */
	
	/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "objetivo")
	private List<ItemResponses> itemResponses;

	public void setItemResponses(List<ItemResponses> itemResponses) {
		if(itemResponses != null) {
			this.itemResponses = itemResponses;
	    	this.itemResponses
	    		.stream()
	    		.forEach(item -> item.setObjetivo(this));
		} else {
			return;
		}
	}*/
}
