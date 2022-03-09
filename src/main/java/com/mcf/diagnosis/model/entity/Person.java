package com.mcf.diagnosis.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Person {
	
    @Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	/*
	@NotBlank
	private Integer age;
	
	@NotBlank
	private String phone;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private Behavior behavior;*/

}
