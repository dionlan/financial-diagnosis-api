package com.mcf.diagnosis.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.mcf.diagnosis.model.enums.Classification;

import lombok.Data;
/**
 * Classe que especifica o diagnóstico financeiro
 * @author dius_
 *
 */
@Entity
@Data
public class Diagnostic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Person person;
	
	/**
	 * mapeamento para o quesquinário (diagnóstico financeiro)
	 */
	@OneToMany(mappedBy = "question")
	private ArrayList<Question> diagnostic = new ArrayList<>();
	
	private BigDecimal finalNote;
	
	@Enumerated(value = EnumType.STRING)
	private Classification classification;
}
