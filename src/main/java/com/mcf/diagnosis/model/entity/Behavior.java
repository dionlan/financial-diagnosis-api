package com.mcf.diagnosis.model.entity;

import java.util.HashMap;

import lombok.Data;

/**
 * Cada questão tem um Id chave e Id valor. Uma questão de múltipla escolha pode ter entre 4 e 5 alternativas, podendo marcar apenas uma resposta
 * @author dius_
 *
 * Classe que especifica informações o comportamento (hábito, conduta, questões emocionais) financeiro do cliente
 */

@Data
public class Behavior {
	
	private HashMap<Integer, Question> anwser = new HashMap<>(); 

}
