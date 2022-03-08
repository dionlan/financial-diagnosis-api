package com.mcf.diagnosis.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcf.diagnosis.model.entity.Diagnostic;

public interface DiagnosticRepository extends JpaRepository<Diagnostic, Long>{

}
