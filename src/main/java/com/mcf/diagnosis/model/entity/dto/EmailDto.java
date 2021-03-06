package com.mcf.diagnosis.model.entity.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDto {

	//@NotBlank
	private String ownerRef;
	//@NotBlank
	//@Email
	private String emailFrom;
	
	@Email
	@NotBlank
	private String emailTo;
	
	//@NotBlank
	private String subject;
	
	private String file64;
	
	private Long personId;
	//private Person personId;
}
