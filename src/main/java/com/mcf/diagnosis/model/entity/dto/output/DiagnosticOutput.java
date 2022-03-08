package com.mcf.diagnosis.model.entity.dto.output;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.mcf.diagnosis.model.entity.Person;
import com.mcf.diagnosis.model.entity.Question;
import com.mcf.diagnosis.model.enums.Classification;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiagnosticOutput {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Person person;
	
	@OneToMany(mappedBy = "question")
	private ArrayList<Question> diagnostic = new ArrayList<>();
	
	private BigDecimal finalNote;
	
	@Enumerated(value = EnumType.STRING)
	private Classification classification;

}
