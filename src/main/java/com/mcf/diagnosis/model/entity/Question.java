package com.mcf.diagnosis.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL) //@OneToMany + @JoinColumn associação unidirecional = APENAS a entidade PAI mapeia a relação
	@JoinColumn(name = "question_id", referencedColumnName = "id")
	private List<ItemsQuestion> question;

}
