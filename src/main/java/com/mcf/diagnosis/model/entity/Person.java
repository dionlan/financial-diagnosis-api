package com.mcf.diagnosis.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity 
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome deve ser informado")
	private String name;
	
	@NotNull
	private String email;
	
	//fk ADICIONADA e criada a coluna person_id na tabela ITEM_RESPONSE referenciando o id desta classe Person
	@OneToMany(cascade = CascadeType.ALL) //@OneToMany + @JoinColumn associação unidirecional = APENAS a entidade PAI mapeia a relação
	@JoinColumn(name = "person_id", referencedColumnName = "id") 
	private List<ItemResponse> responses = new ArrayList<>();
/*
	public void setResponses(List<ItemResponse> responses) {
		if(responses != null) {
			this.responses = responses;
	    	this.responses
	    		.stream()
	    		.forEach(item -> item.setPerson(this));
		} else {
			return;
		}
	}*/
	
	/*

	
	/*
	@OneToOne(mappedBy = "person")
	private PreDiagnosticDto diagnostic;
	
	@NotBlank
	private Integer age;
	
	@NotBlank
	private String phone;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private Behavior behavior;
	public void setDiagnostic(PreDiagnosticDto diagnostic) {
		if(diagnostic != null) {
			this.diagnostic = diagnostic;
		}
	}*/
}
