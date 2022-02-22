package com.mcf.diagnosis.api.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Answer {

	@Id
	private Long id;
	
	private Person person;
	
	private FinancialQuestionnaire questionnaire;
	
	private Question question;
	
	private Item item;
	
	@CreationTimestamp
	@Column(name = "reply_submission_date", nullable = false, columnDefinition = "datetime")
	private OffsetDateTime replySubmissionDate;
}
