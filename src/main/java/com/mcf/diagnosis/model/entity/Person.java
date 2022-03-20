package com.mcf.diagnosis.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "id") //fk person_id referenciando o id dessa classe Person
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
	private Diagnostic diagnostic;
	
	@NotBlank
	private Integer age;
	
	@NotBlank
	private String phone;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private Behavior behavior;
	public void setDiagnostic(Diagnostic diagnostic) {
		if(diagnostic != null) {
			this.diagnostic = diagnostic;
		}
	}*/
}
