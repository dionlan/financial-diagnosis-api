package com.mcf.diagnosis.api.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.Entity;

import com.mcf.diagnosis.api.EnumClassification;

import lombok.Data;

@Entity
@Data
public class FinancialQuestionnaire {

	private Long id;
	private Person person;
	private ArrayList<Question> questionnaire = new ArrayList<>();
	private BigDecimal finalNote;
	private EnumClassification classification;
}
