package com.mcf.diagnosis.model.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

/**
 * O serviço de respostas irá calcular o somatório das respostas (utilizado pelos planejadores) o cliente receberá o cálculo direto no front.
 * Cada resposta terá uma referência para a tabela de items, onde conterá o id, descrição e nota
 * @author dius_
 *
 */
@Data
@Entity
public class Answer {

	@Id
	private Long id;
	
	/* comentado para teste. Quando testar informando o nome, idade, email, telefone, descomentar e utilizar.
	private Person person;
	
	private Diagnostic diagnostic;
	
	private Question question;
	*/
	
	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_diagnostic")
	private Diagnostic diagnostic;
	
	/**
	 * Respostas possíveis: id do item ou lista de itens selecionados (objetivos financeiros imediatos)
	 */
	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_item")
	private Item item;
	
	//criar a classe de objetivos financeiros imediatos com id e descricao
	
	@CreationTimestamp
	@Column(name = "reply_submission_date", nullable = false, columnDefinition = "datetime")
	private OffsetDateTime replySubmissionDate;
}
