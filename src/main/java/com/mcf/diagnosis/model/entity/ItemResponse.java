package com.mcf.diagnosis.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
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
public class ItemResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long itemResponse;
	
	//entidade dona do relacionamento(pai); Cria uma CONSTRAINT FK e coluna na tabela ITEM_RESPONSES e refencia o id desta classe ITEM_RESPONSE
	//ALTER TABLE item_responses ADD CONSTRAINT fk_item_response_item_responses FOREIGN KEY (item_response_id) REFERENCES item_responses (id);
	@OneToMany(cascade = CascadeType.ALL)//@OneToMany + @JoinColumn associação unidirecional = APENAS a entidade PAI mapeia a relação
	@JoinColumn(name = "item_response_id", referencedColumnName = "id") //fk item_responses_id referenciando o id dessa classe ItemResponse
	private List<ItemResponses> itemResponses = new ArrayList<>(); 
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
