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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mcf.diagnosis.model.enums.Classification;

import lombok.Data;
/**
 * Classe que especifica o diagnóstico financeiro
 * @author dius_
 *
 */
@Entity
@Data
public class Diagnostic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "diagnostic")
	private Person person;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "diagnostic")
    @JoinColumn(name = "id_answer", referencedColumnName = "id")
	private Answer answer;
	
	@JsonIgnore
	@Column(name = "final_note")
	private BigDecimal finalNote;
	
	@JsonIgnore
	@Enumerated(value = EnumType.STRING)
	private Classification classification;
	
	public void setPerson(Person person) {
		this.person = person;
		person.setDiagnostic(this);
	}
}