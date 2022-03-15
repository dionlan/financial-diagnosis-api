package com.mcf.diagnosis.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * O serviço de respostas irá calcular o somatório das respostas (utilizado pelos planejadores) o cliente receberá o cálculo direto no front.
 * Cada resposta terá uma referência para a tabela de items, onde conterá o id, descrição e nota
 * @author dius_
 *
 */
@Setter
@Getter
@Entity
public class Answers implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Person person;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="answers_id")
	private Set<Item> answers = new HashSet<>();
	
	public void setPerson(Person person) {
		this.person = person;
		person.setAnswers(this);
	}

	
	/*
    public void setRespostas(Set<Item> respostas) {
    	this.respostas = respostas;
    	this.respostas
    		.stream()
    		.forEach(codigo -> codigo.setResposta(this));
    }*/
    
	/* comentado para teste. Quando testar informando o nome, idade, email, telefone, descomentar e utilizar.
	private Person person;
	
	private Diagnostic diagnostic;
	
	private Question question;
	*/

	//criar a classe de objetivos financeiros imediatos com id e descricao
	
}
