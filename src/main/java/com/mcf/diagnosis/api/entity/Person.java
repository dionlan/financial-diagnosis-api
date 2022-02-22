package com.mcf.diagnosis.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class Person {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private Integer age;
	
	@NotBlank
	private String phone;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private FinancialHabit financialHabit;

}
