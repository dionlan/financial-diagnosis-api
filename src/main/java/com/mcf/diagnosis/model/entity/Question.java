package com.mcf.diagnosis.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Question {

	@Id
	private Long id;
	
	@NotNull
	private String description; //descrição da questão = comando = título
	
	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_questionaire")
	private Diagnostic diagnostic;
	
	@OneToMany(mappedBy = "question")
	private List<Item> items = new ArrayList<Item>();
}
