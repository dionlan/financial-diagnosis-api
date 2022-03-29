package com.mcf.diagnosis.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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

import com.mcf.diagnosis.model.enums.Classification;

import lombok.Getter;
import lombok.Setter;
/*
 * Classe que especifica o diagnóstico financeiro
 * @author dius_
 */
@Setter
@Getter
@Entity 
public class PreDiagnostic implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
	private Person person; 

	@Column(name = "final_note")
	private BigDecimal finalNote;
	
	@Enumerated(value = EnumType.STRING)
	private Classification classification;

}