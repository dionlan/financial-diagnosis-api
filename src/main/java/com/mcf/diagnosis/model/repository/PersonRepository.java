package com.mcf.diagnosis.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcf.diagnosis.model.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
