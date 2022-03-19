package com.mcf.diagnosis.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcf.diagnosis.model.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
