package com.mcf.diagnosis.model.entity;

import java.io.Serializable;

/**
 * O serviço de respostas irá calcular o somatório das respostas (utilizado pelos planejadores) o cliente receberá o cálculo direto no front.
 * Cada resposta terá uma referência para a tabela de items, onde conterá o id, descrição e nota
 * @author dius_
 *
 
@Setter
@Getter
@Entity*/
public class Response implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/*
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "response")
	private List<ItemResponse> responses;

	public void setResponses(List<ItemResponse> responses) {
		this.responses = responses;
		this.responses
			.stream()
			.forEach(response -> response.setResponse(this));
	}
	
	@CreationTimestamp
	@Column(name = "reply_submission_date", nullable = false, columnDefinition = "datetime")
	private OffsetDateTime replySubmissionDate;
	*/
	
}
