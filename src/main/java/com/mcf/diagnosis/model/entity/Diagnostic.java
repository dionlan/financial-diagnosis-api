package com.mcf.diagnosis.model.entity;

import java.io.Serializable;
/**
 * Classe que especifica o diagnóstico financeiro
 * @author dius_
 *

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor */
public class Diagnostic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
	private Person person; 
	
	@OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "answer_id")
	private Set<Item> answer = new HashSet<>();

	@Column(name = "final_note")
	private BigDecimal finalNote;
	
	@Enumerated(value = EnumType.STRING)
	private Classification classification;
	
	@CreationTimestamp
	@Column(name = "reply_submission_date", nullable = false, columnDefinition = "datetime")
	private OffsetDateTime replySubmissionDate;
*/
}