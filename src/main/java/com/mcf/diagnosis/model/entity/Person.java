package com.mcf.diagnosis.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "answer_id")
	private Answer answer;
	
	/*
	@OneToOne(mappedBy = "person")
	private Diagnostic diagnostic;
	
	@NotBlank
	private Integer age;
	
	@NotBlank
	private String phone;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private Behavior behavior;
	public void setDiagnostic(Diagnostic diagnostic) {
		if(diagnostic != null) {
			this.diagnostic = diagnostic;
		}
	}*/
}
