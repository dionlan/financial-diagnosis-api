package com.mcf.diagnosis.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcf.diagnosis.model.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
