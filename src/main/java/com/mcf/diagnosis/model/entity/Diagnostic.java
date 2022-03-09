package com.mcf.diagnosis.model.entity;

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
public class Diagnostic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person", referencedColumnName = "id")
	private Person person;
	
	/**
	 * mapeamento para o quesquinário (diagnóstico financeiro)
	 */
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_answer", referencedColumnName = "id")
	private Answer answer;
	
	@JsonIgnore
	@Column(name = "final_note")
	private BigDecimal finalNote;
	
	@JsonIgnore
	@Enumerated(value = EnumType.STRING)
	private Classification classification;
}
/**
 * [
    {
        "idQuestao": "q1",
        "idResposta": "r1",
        "resposta": "asdf"
    },
    {
        "idQuestao": "q29",
        "idResposta": "r29",
        "resposta": [
            {
                "id": 6,
                "objetivo": "Montar minha reserva de segurança"
            },
            {
                "id": 10,
                "objetivo": "Melhorar a minha educação financeira"
            },
            {
                "id": 11,
                "objetivo": "Melhorar meus pensamentos e emoções relacionadas ao dinheiro"
            },
            {
                "id": 12,
                "objetivo": "Comprar algum bem pessoal ou imóvel"
            },
            []
        ]
    },
    {
        "idQuestao": "q30",
        "idResposta": "r30",
        "resposta": 7
    },
    {
        "idQuestao": "q31",
        "idResposta": "r31",
        "resposta": "asdf"
    }
]
 * */