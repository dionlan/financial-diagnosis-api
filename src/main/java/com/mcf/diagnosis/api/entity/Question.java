package com.mcf.diagnosis.api.entity;

import java.math.BigDecimal;
import java.util.HashMap;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Question {

	private Long id;
	private String description; //descrição da questão = comando = título
	private HashMap<Integer, BigDecimal> itens = new HashMap<>(); //cada questão possui um id e sua respectiva nota
}
