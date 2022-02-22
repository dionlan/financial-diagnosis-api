package com.mcf.diagnosis.api.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.mcf.diagnosis.api.enums.Classification;

import lombok.Data;

@Entity
@Data
public class FinancialQuestionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Person person;
	
	@OneToMany(mappedBy = "question")
	private ArrayList<Question> questionnaire = new ArrayList<>();
	
	private BigDecimal finalNote;
	
	@Enumerated(value = EnumType.STRING)
	private Classification classification;
}
