package com.mcf.diagnosis.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mcf.diagnosis.model.entity.PreDiagnostic;

public interface PreDiagnosticRepository extends JpaRepository<PreDiagnostic, Long> {

	@Query(value = " select sum(l.note) from Lancamento l join l.usuario u "
			+ "  where u.email = :email group by u")
				PreDiagnostic buscarResultadoPrevio(@Param("email") String email);
}
