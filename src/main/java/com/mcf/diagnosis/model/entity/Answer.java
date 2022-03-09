package com.mcf.diagnosis.model.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
    @JoinColumn(name = "id_diagnostic", referencedColumnName = "id")
	private Diagnostic diagnostic;

	@OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id")
	private Person person;
	
	@OneToMany (mappedBy = "answer")
	private List<Item> respostas = new ArrayList<>();
	
	/**
	 * Respostas possíveis: id do item ou lista de itens selecionados (objetivos financeiros imediatos)
	 */
	
	/* comentado para teste. Quando testar informando o nome, idade, email, telefone, descomentar e utilizar.
	private Person person;
	
	private Diagnostic diagnostic;
	
	private Question question;
	*/

	//criar a classe de objetivos financeiros imediatos com id e descricao
	
	@CreationTimestamp
	@Column(name = "reply_submission_date", nullable = false, columnDefinition = "datetime")
	private OffsetDateTime replySubmissionDate;
	
	public void setPerson(Person person) {
		this.person = person;
		person.setDiagnostic(diagnostic);
	}
}
