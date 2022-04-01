package com.mcf.diagnosis.model.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mcf.diagnosis.model.entity.PreDiagnostic;

public interface PreDiagnosticRepository extends JpaRepository<PreDiagnostic, Long> {

		@Query(value = " SELECT SUM(q.note) FROM ItemResponse i, ItemsQuestion q , Person p "
				+ " WHERE i.question = q.question "
				+ " AND i.itemResponse = q.itemResponse "
				+ "	AND p.id = :personId " )
		BigDecimal obterFinalNote(@Param("personId") Long personId);
		
		@Query(value = " SELECT p.classification, finalNote FROM PreDiagnostic p "
				+ " WHERE p.personId = :id " )
		PreDiagnostic obterPreviaDiagnostico(@Param("id") Long id);
}
