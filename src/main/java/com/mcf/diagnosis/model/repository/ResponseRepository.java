package com.mcf.diagnosis.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcf.diagnosis.model.entity.Response;

public interface ResponseRepository extends JpaRepository<Response, Long>{

}
