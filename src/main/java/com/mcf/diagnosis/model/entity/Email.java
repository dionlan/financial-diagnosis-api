package com.mcf.diagnosis.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.mcf.diagnosis.model.enums.StatusEmail;

import lombok.Data;

@Data
@Entity
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ownerRef;
	private String emailFrom;
	private String emailTo;
	private String subject;
	//@Column(columnDefinition = "TEXT")
	//private String text;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "file64", columnDefinition = "LONGBLOB")
	private String file64;
	private LocalDateTime sendDateEmail;
	private StatusEmail statusEmail;
	
	private Long personId;
	//private Person personId; TODO: refatorar para considerar o relacionamento entre Person e Email
}
