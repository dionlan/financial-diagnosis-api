package com.mcf.diagnosis.model.entity.dto.input;

import java.util.ArrayList;
import javax.validation.constraints.NotBlank;
import com.mcf.diagnosis.model.entity.Person;
import com.mcf.diagnosis.model.entity.Question;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiagnosticInput {

	@NotBlank
	private Person person;
	
	@NotBlank
	private ArrayList<Question> diagnostic = new ArrayList<>();
	
}
