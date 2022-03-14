package com.mcf.diagnosis.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.mcf.diagnosis.model.enums.Classification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Classe que especifica o diagnóstico financeiro
 * @author dius_
 *
 */
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Diagnostic implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
	private Person person; 
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "answer_id")
	private Answer answer;

	@Column(name = "final_note")
	private BigDecimal finalNote;
	
	@Enumerated(value = EnumType.STRING)
	private Classification classification;
	
	@CreationTimestamp
	@Column(name = "reply_submission_date", nullable = false, columnDefinition = "datetime")
	private OffsetDateTime replySubmissionDate;
	
	public void setPerson(Person person) {
		this.person = person;
		person.setAnswer(getAnswer());
		answer.setPerson(getPerson());
	}
}