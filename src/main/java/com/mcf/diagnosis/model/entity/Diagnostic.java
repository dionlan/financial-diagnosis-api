package com.mcf.diagnosis.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.mcf.diagnosis.model.enums.Classification;
/**
 * Classe que especifica o diagnóstico financeiro
 * @author dius_
 *
@Setter
@Getter
@Entity */
public class Diagnostic implements Serializable {
	
	private static final long serialVersionUID = 1L;
/*
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
	private Person person; 
	
	@OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "response_id")
	private Set<ItemResponse> response = new HashSet<>();
	*/

	@Column(name = "final_note")
	private BigDecimal finalNote;
	
	@Enumerated(value = EnumType.STRING)
	private Classification classification;

}