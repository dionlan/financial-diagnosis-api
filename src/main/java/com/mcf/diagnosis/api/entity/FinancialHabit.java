package com.mcf.diagnosis.api.entity;

import java.util.HashMap;

import javax.persistence.Entity;

import lombok.Data;

/**
 * Cada questão tem um Id chave e Id valor. Uma questão de múltipla escolha pode ter entre 4 e 5 alternativas, podendo marcar apenas uma resposta
 * @author dius_
 *
 */
@Entity
@Data
public class FinancialHabit {
	
	private HashMap<Integer, Question> anwser = new HashMap<>(); 

}
